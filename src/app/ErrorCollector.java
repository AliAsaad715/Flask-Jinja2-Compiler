package app;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ErrorCollector extends BaseErrorListener {

    private final String source;
    private final List<String> messages = new ArrayList<>();

    public ErrorCollector(String source) {
        this.source = source;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        messages.add(String.format("%s:%d:%d  %s", source, line, charPositionInLine, msg));
    }

    public boolean hasErrors() { return !messages.isEmpty(); }

    public int count() { return messages.size(); }

    public List<String> getMessages() { return Collections.unmodifiableList(messages); }
}
