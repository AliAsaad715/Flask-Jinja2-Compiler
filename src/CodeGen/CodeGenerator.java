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

    public void generatePythonApp(ProgramNode program) throws IOException {
        write(outputDir.resolve(APP_FILE), PythonEmitter.emit(program));
    }

    public void generateTemplate(String name, TemplateFileNode template) throws IOException {
        String fileName = safeName(name, "template.html");
        write(outputDir.resolve(TEMPLATES_DIR).resolve(fileName), TemplateEmitter.emit(template));
    }

    public void generateStylesheet(String name, CssFileNode css) throws IOException {
        String fileName = safeName(name, DEFAULT_STYLESHEET);
        write(outputDir.resolve(STATIC_DIR).resolve(fileName), CssEmitter.emit(css));
    }

    public List<String> getGeneratedFiles() {
        return Collections.unmodifiableList(generatedFiles);
    }

    private void write(Path target, String content) throws IOException {
        Path parent = target.getParent();
        if (parent != null) Files.createDirectories(parent);
        Files.writeString(target, content, StandardCharsets.UTF_8);
        generatedFiles.add(target.toString());
    }

    private String safeName(String name, String fallback) {
        if (name == null || name.isBlank()) return fallback;

        String cleaned = name.trim().replace('\\', '/');
        int slash = cleaned.lastIndexOf('/');
        if (slash >= 0) cleaned = cleaned.substring(slash + 1);

        return cleaned.isBlank() ? fallback : cleaned;
    }
}
