package Semantic;

/**
 * One diagnostic produced by the semantic analyser.
 *
 * <p>Errors are collected rather than thrown so that a single run reports every
 * problem in the project instead of stopping at the first one.
 */
public class SemanticError {

    public enum Severity { ERROR, WARNING }

    private final String code;
    private final Severity severity;
    private final String source;
    private final int line;
    private final String message;

    public SemanticError(String code, Severity severity, String source, int line, String message) {
        this.code = code;
        this.severity = severity;
        this.source = source;
        this.line = line;
        this.message = message;
    }

    public static SemanticError error(String code, String source, int line, String message) {
        return new SemanticError(code, Severity.ERROR, source, line, message);
    }

    public static SemanticError warning(String code, String source, int line, String message) {
        return new SemanticError(code, Severity.WARNING, source, line, message);
    }

    public String getCode() { return code; }
    public Severity getSeverity() { return severity; }
    public String getSource() { return source; }
    public int getLine() { return line; }
    public String getMessage() { return message; }

    public boolean isError() { return severity == Severity.ERROR; }

    @Override
    public String toString() {
        return String.format("[%s] %s %s:%d  %s",
                code, severity, source, line, message);
    }
}
