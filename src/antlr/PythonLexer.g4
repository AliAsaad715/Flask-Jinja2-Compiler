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
                lastToken = t;
                return t;
            }

            org.antlr.v4.runtime.Token next = super.nextToken();

            if (next.getType() == EOF) {

                if (lastToken != null && lastToken.getType() != NEWLINE) {
                    pendingTokens.add(commonToken(NEWLINE, "\n"));
                }

                // emit remaining DEDENTs before EOF
                while (indents.size() > 1) {
                    indents.pop();
                    pendingTokens.add(commonToken(DEDENT, ""));
                }

                pendingTokens.add(next);
                org.antlr.v4.runtime.Token t = pendingTokens.poll();
                lastToken = t;
                return t;
            }

            lastToken = next;
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

// -------------------- Keywords (only what you need) --------------------
FROM: 'from';
IMPORT: 'import';
AS: 'as';

DEFINETION: 'def';
RETURN: 'return';

IF: 'if';
ELIF: 'elif';
ELSE: 'else';

FOR: 'for';        // needed for: (p for p in products if ...)
IN: 'in';
IS: 'is';

AND: 'and';
OR: 'or';
NOT: 'not';

NONE: 'None';
TRUE: 'True';
FALSE: 'False';

// -------------------- Operators & punctuation --------------------
DECORATOR: '@';
DOT: '.';
COMMA: ',';
COLON: ':';

EQEQ: '==';
NOTEQ: '!=';
EQUAL: '=';

PLUS: '+';

OPEN_B: '(' {opened++;};
CLOSE_B: ')' {opened--;};

LBRACK: '[' {opened++;};
RBRACK: ']' {opened--;};

LBRACE: '{' {opened++;};
RBRACE: '}' {opened--;};

// -------------------- Literals --------------------
FLOAT_VALUE: '-'? [0-9]+ '.' [0-9]+;

INT_VALUE
    : '0'
    | '-'? [1-9] [0-9]*
    ;

// Single OR double quoted strings
STRING
    : '\'' ( '\\' . | ~['\\\r\n] )* '\''
    | '"'  ( '\\' . | ~["\\\r\n] )* '"'
    ;

// -------------------- Identifiers --------------------
ID: [a-zA-Z_][a-zA-Z0-9_]*;

// -------------------- Line handling --------------------
LINE_JOINING: '\\' [ \t]* ('\r'? '\n')+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;

// NEWLINE + INDENT/DEDENT
NEWLINE
    : ('\r'? '\n')+ [ \t]*
      {
        String newLine = getText().replaceAll("[^\r\n]+", "");
        String spaces  = getText().replaceAll("[\r\n]+", "");

        int next = _input.LA(1);

        // If inside (), [], {} OR blank/comment-only line: ignore newline
        if (opened > 0 || next == '\r' || next == '\n' || next == '#' || next == EOF) {
            skip();
        } else {
            setText(newLine);

            int indent = getIndentationCount(spaces);
            int prev = indents.peek();

            if (indent > prev) {
                indents.push(indent);
                pendingTokens.add(commonToken(INDENT, ""));
            } else if (indent < prev) {
                while (indents.size() > 1 && indent < indents.peek()) {
                    indents.pop();
                    pendingTokens.add(commonToken(DEDENT, ""));
                }
            }
        }
      }
    ;

// normal spaces (not indentation-leading spaces after NEWLINE)
WS: [ \t]+ -> channel(HIDDEN);
