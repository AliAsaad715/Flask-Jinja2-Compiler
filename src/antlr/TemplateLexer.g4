lexer grammar TemplateLexer;

@header { package antlr; }

tokens {
  ATTR_TEXT,
  LPAREN, RPAREN, LBRACK, RBRACK,
  COMMA, DOT, COLON, PIPE,
  GE, LE, EQEQ, NE, GT, LT,
  PLUS, MINUS, STAR, SLASH,
  INT, STRING, ID
}

JINJA_EXPR_OPEN: '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA_STMT_OPEN: '{%' -> pushMode(JINJA_STMT_MODE);
TAG_OPEN: '<' -> pushMode(TAG_MODE);
TEXT: (~[<{] | '{' ~[{%])+;

mode TAG_MODE;

TAG_SELF_CLOSE: '/>' -> popMode;
TAG_CLOSE: '>' -> popMode;
TAG_SLASH: '/';
EQ: '=';
DQUOTE: '"' -> pushMode(ATTR_DQ_MODE);
SQUOTE: '\'' -> pushMode(ATTR_SQ_MODE);
TAG_NAME: [a-zA-Z_!][a-zA-Z0-9_:-]*;
TAG_WS: [ \t\r\n]+ -> skip;

mode ATTR_DQ_MODE;

DQUOTE_END: '"' -> popMode, type(DQUOTE);
JINJA_EXPR_OPEN_ATTR_DQ: '{{' -> pushMode(JINJA_EXPR_MODE), type(JINJA_EXPR_OPEN);
ATTR_TEXT_DQ: (~["{] | '{' ~[{])+ -> type(ATTR_TEXT);

mode ATTR_SQ_MODE;

SQUOTE_END: '\'' -> popMode, type(SQUOTE);
JINJA_EXPR_OPEN_ATTR_SQ: '{{' -> pushMode(JINJA_EXPR_MODE), type(JINJA_EXPR_OPEN);
ATTR_TEXT_SQ: (~['{] | '{' ~[{])+ -> type(ATTR_TEXT);

mode JINJA_EXPR_MODE;

JINJA_EXPR_CLOSE: '}}' -> popMode;
JINJA_WS_E: [ \t\r\n]+ -> skip;

LPAREN_E: '(' -> type(LPAREN);
RPAREN_E: ')' -> type(RPAREN);
LBRACK_E: '[' -> type(LBRACK);
RBRACK_E: ']' -> type(RBRACK);
COMMA_E: ',' -> type(COMMA);
DOT_E: '.' -> type(DOT);
COLON_E: ':' -> type(COLON);
PIPE_E: '|' -> type(PIPE);

GE_E: '>=' -> type(GE);
LE_E: '<=' -> type(LE);
EQEQ_E: '==' -> type(EQEQ);
NE_E: '!=' -> type(NE);
GT_E: '>' -> type(GT);
LT_E: '<' -> type(LT);

PLUS_E: '+' -> type(PLUS);
MINUS_E: '-' -> type(MINUS);
STAR_E: '*' -> type(STAR);
SLASH_E: '/' -> type(SLASH);
EQ_E: '=' -> type(EQ);

INT_E: [0-9]+ -> type(INT);
STRING_E: ('"' (~["\\] | '\\' .)* '"' | '\'' (~['\\] | '\\' .)* '\'') -> type(STRING);
ID_E: [a-zA-Z_][a-zA-Z0-9_]* -> type(ID);

mode JINJA_STMT_MODE;

JINJA_STMT_CLOSE: '%}' -> popMode;
JINJA_WS_S: [ \t\r\n]+ -> skip;

EXTENDS: 'extends';
BLOCK: 'block';
ENDBLOCK: 'endblock';
FOR: 'for';
IN: 'in';
ENDFOR: 'endfor';
IF: 'if';
ELIF: 'elif';
ELSE: 'else';
ENDIF: 'endif';
SET: 'set';

LPAREN_S: '(' -> type(LPAREN);
RPAREN_S: ')' -> type(RPAREN);
LBRACK_S: '[' -> type(LBRACK);
RBRACK_S: ']' -> type(RBRACK);
COMMA_S: ',' -> type(COMMA);
DOT_S: '.' -> type(DOT);
COLON_S: ':' -> type(COLON);
PIPE_S: '|' -> type(PIPE);

GE_S: '>=' -> type(GE);
LE_S: '<=' -> type(LE);
EQEQ_S: '==' -> type(EQEQ);
NE_S: '!=' -> type(NE);
GT_S: '>' -> type(GT);
LT_S: '<' -> type(LT);

PLUS_S: '+' -> type(PLUS);
MINUS_S: '-' -> type(MINUS);
STAR_S: '*' -> type(STAR);
SLASH_S: '/' -> type(SLASH);
EQ_S: '=' -> type(EQ);

INT_S: [0-9]+ -> type(INT);
STRING_S: ('"' (~["\\] | '\\' .)* '"' | '\'' (~['\\] | '\\' .)* '\'') -> type(STRING);
ID_S: [a-zA-Z_][a-zA-Z0-9_]* -> type(ID);
