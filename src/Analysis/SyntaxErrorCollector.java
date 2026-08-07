package Analysis;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Collects lexer and parser errors so invalid input cannot reach code generation. */
public class SyntaxErrorCollector extends BaseErrorListener {
    private final String sourceName;
    private final List<String> errors = new ArrayList<>();

    public SyntaxErrorCollector(String sourceName) {
        this.sourceName = sourceName;
    }

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e
    ) {
        errors.add(sourceName + ":" + line + ":" + (charPositionInLine + 1) + " " + msg);
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
