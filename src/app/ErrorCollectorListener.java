package app;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollectorListener extends BaseErrorListener {
    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errors.add("line " + line + ":" + charPositionInLine + " " + msg);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        for (String s : errors) sb.append(s).append("\n");
        return sb.toString();
    }
}
