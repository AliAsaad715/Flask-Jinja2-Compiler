lexer grammar PythonLexer;

tokens { INDENT, DEDENT }

@members {
    private java.util.LinkedList<Token> pendingTokens = new java.util.LinkedList<>();
        private java.util.Stack<Integer> indents = new java.util.Stack<>();
        private int opened = 0;

        private boolean initialized = false;
        private org.antlr.v4.runtime.Token lastToken = null;

        @Override
        public org.antlr.v4.runtime.Token nextToken() {

            if (!initialized) {
                indents.push(0);
                initialized = true;
            }

            if (!pendingTokens.isEmpty()) {
                org.antlr.v4.runtime.Token t = pendingTokens.poll();

                if (t.getChannel() == org.antlr.v4.runtime.Token.DEFAULT_CHANNEL) {
                    lastToken = t;
                }
                return t;
            }

            org.antlr.v4.runtime.Token next = super.nextToken();

            if (next.getChannel() == org.antlr.v4.runtime.Token.DEFAULT_CHANNEL
                    && indents.size() == 1
                    && (lastToken == null || lastToken.getType() == NEWLINE)
                    && next.getCharPositionInLine() > 0
                    && next.getType() != NEWLINE
                    && next.getType() != EOF) {
                throw new RuntimeException("IndentationError: unexpected indent at line " + next.getLine());
            }

            if (next.getType() == EOF) {

                if (lastToken != null && lastToken.getType() != NEWLINE) {
                    pendingTokens.add(commonToken(NEWLINE, "\n"));
                }

                while (indents.size() > 1) {
                    indents.pop();
                    pendingTokens.add(commonToken(DEDENT, ""));
                }

                pendingTokens.add(next);
                org.antlr.v4.runtime.Token t = pendingTokens.poll();

                if (t.getChannel() == org.antlr.v4.runtime.Token.DEFAULT_CHANNEL) {
                    lastToken = t;
                }
                return t;
            }

            if (next.getChannel() == org.antlr.v4.runtime.Token.DEFAULT_CHANNEL) {
                lastToken = next;
            }

            return next;
        }


    private org.antlr.v4.runtime.CommonToken commonToken(int type, String text) {
        org.antlr.v4.runtime.CommonToken t =
                new org.antlr.v4.runtime.CommonToken(_tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, -1, -1);
        t.setText(text);
        t.setLine(getLine());
        t.setCharPositionInLine(getCharPositionInLine());
        return t;
    }

    private int getIndentationCount(String spaces) {
        int count = 0;
        for (int i = 0; i < spaces.length(); i++) {
            if (spaces.charAt(i) == '\t') {
                count += 8 - (count % 8);
            } else {
                count++;
            }
        }
        return count;
    }
}


FROM: 'from';
IMPORT: 'import';
AS: 'as';

DEFINETION: 'def';
RETURN: 'return';

IF: 'if';
ELIF: 'elif';
ELSE: 'else';

FOR: 'for';
IN: 'in';
IS: 'is';

AND: 'and';
OR: 'or';
NOT: 'not';

NONE: 'None';
TRUE: 'True';
FALSE: 'False';


DECORATOR: '@';
DOT: '.';
COMMA: ',';
COLON: ':';

EQEQ: '==';
NOTEQ: '!=';
EQUAL: '=';

PLUS: '+';

OPEN_B: '(' {opened++;};
CLOSE_B: ')' { if (opened > 0) opened--; };

LBRACK: '[' {opened++;};
RBRACK: ']' { if (opened > 0) opened--; };

LBRACE: '{' {opened++;};
RBRACE: '}' { if (opened > 0) opened--; };


FLOAT_VALUE: '-'? [0-9]+ '.' [0-9]+;

INT_VALUE
    : '0'
    | '-'? [1-9] [0-9]*
    ;


STRING
    : '\'' ( '\\' . | ~['\\\r\n] )* '\''
    | '"'  ( '\\' . | ~["\\\r\n] )* '"'
    ;


ID: [a-zA-Z_][a-zA-Z0-9_]*;


LINE_JOINING: '\\' [ \t]* ('\r'? '\n')+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;


NEWLINE
    : ('\r'? '\n')+ [ \t]*
      {
        String newLine = getText().replaceAll("[^\r\n]+", "");
        String spaces  = getText().replaceAll("[\r\n]+", "");

        int next = _input.LA(1);

        if (opened > 0 || next == '\r' || next == '\n' || next == '#' || next == EOF) {
            skip();
        } else {
            setText(newLine);

            int indent = getIndentationCount(spaces);
            int prev = indents.peek();

            if (lastToken != null && lastToken.getType() == COLON && indent <= prev) {
                throw new RuntimeException(
                    "IndentationError: expected an indented block at line " + getLine()
                );
            }

            if (indent > prev) {

                if (lastToken == null || lastToken.getType() != COLON) {
                    throw new RuntimeException(
                        "IndentationError: unexpected indent at line " + getLine()
                    );
                }
                indents.push(indent);
                pendingTokens.add(commonToken(INDENT, ""));

            } else if (indent < prev) {
                while (indents.size() > 1 && indent < indents.peek()) {
                    indents.pop();
                    pendingTokens.add(commonToken(DEDENT, ""));
                }
                if (indent != indents.peek()) {
                    throw new RuntimeException(
                        "IndentationError: unindent does not match any outer indentation level at line " + getLine()
                    );
                }
            }

        }
      }
    ;

WS: [ \t]+ -> channel(HIDDEN);


