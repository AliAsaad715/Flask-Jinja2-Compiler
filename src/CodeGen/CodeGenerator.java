package CodeGen;

import AST.css.CssFileNode;
import AST.python.ProgramNode;
import AST.template.TemplateFileNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Writes a runnable Flask project out of the compiled abstract syntax trees.
 *
 * <p>The three generators emit into the layout Flask expects, so the parts work
 * together once written:
 *
 * <pre>
 *   &lt;outputDir&gt;/app.py
 *   &lt;outputDir&gt;/templates/&lt;name&gt;.html
 *   &lt;outputDir&gt;/static/&lt;name&gt;.css
 * </pre>
 *
 * <p>Everything is written as UTF-8 - the templates carry Arabic text that must
 * survive the round trip.
 */
public class CodeGenerator {

    private static final String TEMPLATES_DIR = "templates";
    private static final String STATIC_DIR = "static";
    private static final String APP_FILE = "app.py";
    private static final String DEFAULT_STYLESHEET = "style.css";

    private final Path outputDir;
    private final List<String> generatedFiles = new ArrayList<>();

    public CodeGenerator(Path outputDir) {
        this.outputDir = outputDir == null ? Path.of(".") : outputDir;
    }

    /** Emits {@code app.py} from the Python AST. */
    public void generatePythonApp(ProgramNode program) throws IOException {
        write(outputDir.resolve(APP_FILE), PythonEmitter.emit(program));
    }

    /** Emits {@code templates/<name>} from a template AST. {@code name} is like "products.html". */
    public void generateTemplate(String name, TemplateFileNode template) throws IOException {
        String fileName = safeName(name, "template.html");
        write(outputDir.resolve(TEMPLATES_DIR).resolve(fileName), TemplateEmitter.emit(template));
    }

    /** Emits {@code static/style.css} from a CSS AST. */
    public void generateStylesheet(String name, CssFileNode css) throws IOException {
        String fileName = safeName(name, DEFAULT_STYLESHEET);
        write(outputDir.resolve(STATIC_DIR).resolve(fileName), CssEmitter.emit(css));
    }

    /** Files written so far, in order, for reporting. */
    public List<String> getGeneratedFiles() {
        return Collections.unmodifiableList(generatedFiles);
    }

    // ---------------------------------------------------------------- helpers

    private void write(Path target, String content) throws IOException {
        Path parent = target.getParent();
        if (parent != null) Files.createDirectories(parent);
        Files.writeString(target, content, StandardCharsets.UTF_8);
        generatedFiles.add(target.toString());
    }

    /**
     * Keeps a caller-supplied name from escaping the output directory: only the
     * final path element is used, and an empty name falls back to the default.
     */
    private String safeName(String name, String fallback) {
        if (name == null || name.isBlank()) return fallback;

        String cleaned = name.trim().replace('\\', '/');
        int slash = cleaned.lastIndexOf('/');
        if (slash >= 0) cleaned = cleaned.substring(slash + 1);

        return cleaned.isBlank() ? fallback : cleaned;
    }
}
