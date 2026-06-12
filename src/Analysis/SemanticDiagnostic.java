package Analysis;

public class SemanticDiagnostic {
    public enum Severity {
        ERROR,
        WARNING
    }

    private final Severity severity;
    private final String source;
    private final int line;
    private final String code;
    private final String message;

    public SemanticDiagnostic(Severity severity, String source, int line, String code, String message) {
        this.severity = severity;
        this.source = source == null || source.isBlank() ? "<unknown>" : source;
        this.line = line;
        this.code = code == null || code.isBlank() ? "SEMANTIC" : code;
        this.message = message == null ? "" : message;
    }

    public static SemanticDiagnostic error(String source, int line, String code, String message) {
        return new SemanticDiagnostic(Severity.ERROR, source, line, code, message);
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getSource() {
        return source;
    }

    public int getLine() {
        return line;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return severity + " " + source + ":" + line + " [" + code + "] " + message;
    }
}
