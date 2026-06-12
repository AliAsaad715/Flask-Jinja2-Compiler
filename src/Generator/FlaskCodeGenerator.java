package Generator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FlaskCodeGenerator {
    public List<GeneratedFile> generate(String pythonSourcePath, List<String> sourcePaths, Path outputRoot)
            throws IOException {
        List<GeneratedFile> generated = new ArrayList<>();

        Files.createDirectories(outputRoot);
        Files.createDirectories(outputRoot.resolve("templates"));
        Files.createDirectories(outputRoot.resolve("static"));
        Files.createDirectories(outputRoot.resolve("static").resolve("uploads"));

        Path appSource = Path.of(pythonSourcePath);
        Path appOutput = outputRoot.resolve("app.py");
        copy(appSource, appOutput);
        generated.add(new GeneratedFile("python", appSource, appOutput));

        for (String sourcePath : sourcePaths) {
            Path source = Path.of(sourcePath);
            String fileName = source.getFileName().toString();

            if (isHtmlSource(fileName)) {
                Path target = outputRoot.resolve("templates").resolve(htmlOutputName(fileName));
                copy(source, target);
                generated.add(new GeneratedFile("template", source, target));
            } else if (isCssSource(fileName)) {
                Path target = outputRoot.resolve("static").resolve(cssOutputName(fileName));
                copy(source, target);
                generated.add(new GeneratedFile("css", source, target));
            }
        }

        Path readme = outputRoot.resolve("README_GENERATED.txt");
        Files.writeString(readme, generatedReadme(), StandardCharsets.UTF_8);
        generated.add(new GeneratedFile("readme", null, readme));

        return generated;
    }

    public static String format(List<GeneratedFile> files) {
        if (files == null || files.isEmpty()) {
            return "No files generated.\n";
        }

        StringBuilder sb = new StringBuilder();
        for (GeneratedFile file : files) {
            sb.append("- ").append(file).append("\n");
        }
        return sb.toString();
    }

    private void copy(Path source, Path target) throws IOException {
        String text = Files.readString(source, StandardCharsets.UTF_8);
        Files.createDirectories(target.getParent());
        Files.writeString(target, text, StandardCharsets.UTF_8);
    }

    private boolean isHtmlSource(String fileName) {
        return fileName.endsWith("_html.txt") || fileName.endsWith(".html");
    }

    private boolean isCssSource(String fileName) {
        return fileName.endsWith("_css.txt") || fileName.endsWith(".css");
    }

    private String htmlOutputName(String fileName) {
        if (fileName.endsWith("_html.txt")) {
            return fileName.substring(0, fileName.length() - "_html.txt".length()) + ".html";
        }
        return fileName;
    }

    private String cssOutputName(String fileName) {
        if (fileName.endsWith("_css.txt")) {
            return fileName.substring(0, fileName.length() - "_css.txt".length()) + ".css";
        }
        return fileName;
    }

    private String generatedReadme() {
        return """
                Generated Flask app
                ===================

                Run from this directory with:

                    python app.py

                Expected layout:

                    app.py
                    templates/*.html
                    static/*.css
                    static/uploads/
                """;
    }
}
