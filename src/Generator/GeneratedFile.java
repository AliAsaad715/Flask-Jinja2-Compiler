package Generator;

import java.nio.file.Path;

public class GeneratedFile {
    private final String kind;
    private final Path sourcePath;
    private final Path outputPath;

    public GeneratedFile(String kind, Path sourcePath, Path outputPath) {
        this.kind = kind;
        this.sourcePath = sourcePath;
        this.outputPath = outputPath;
    }

    public String getKind() {
        return kind;
    }

    public Path getSourcePath() {
        return sourcePath;
    }

    public Path getOutputPath() {
        return outputPath;
    }

    @Override
    public String toString() {
        String source = sourcePath == null ? "<generated>" : sourcePath.toString();
        return kind + ": " + source + " -> " + outputPath;
    }
}
