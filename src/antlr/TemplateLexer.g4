lexer grammar TemplateLexer;

@header { package antlr; }

tokens {
  ATTR_TEXT,
  LPAREN, RPAREN, LBRACK, RBRACK,
  COMMA, DOT, COLON, PIPE, PERCENT,
  GE, LE, EQEQ, NE, GT, LT,
  PLUS, MINUS, STAR, SLASH,
  AND, OR, NOT, IS, TRUE, FALSE, NONE,
  INT, FLOAT, STRING, ID
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
VOID_TAG_NAME
    : 'img'
    | 'input'
    | 'br'
    | 'hr'
    | 'meta'
    | 'link'
    | 'source'
    | 'area'
    | 'base'
    | 'col'
    | 'embed'
    | 'param'
    | 'track'
    | 'wbr'
    | '!DOCTYPE'
    | '!doctype'
    ;

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
PERCENT_E: '%' -> type(PERCENT);
EQ_E: '=' -> type(EQ);

// Keywords must precede ID_E. ANTLR prefers the longest match, so an
// identifier such as `android` still lexes as ID rather than AND + `roid`.
AND_E: 'and' -> type(AND);
OR_E: 'or' -> type(OR);
NOT_E: 'not' -> type(NOT);
IS_E: 'is' -> type(IS);
IN_E: 'in' -> type(IN);
IF_E: 'if' -> type(IF);
ELSE_E: 'else' -> type(ELSE);
TRUE_E: ('True' | 'true') -> type(TRUE);
FALSE_E: ('False' | 'false') -> type(FALSE);
NONE_E: ('None' | 'none') -> type(NONE);

FLOAT_E: [0-9]+ '.' [0-9]+ -> type(FLOAT);
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

// Word operators. These must precede ID_S so `and` never lexes as an
// identifier — that was the cause of `{% if user and admin %}` collapsing
// into a single symbol named `userandadmin`.
AND_S: 'and' -> type(AND);
OR_S: 'or' -> type(OR);
NOT_S: 'not' -> type(NOT);
IS_S: 'is' -> type(IS);
TRUE_S: ('True' | 'true') -> type(TRUE);
FALSE_S: ('False' | 'false') -> type(FALSE);
NONE_S: ('None' | 'none') -> type(NONE);

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
PERCENT_S: '%' -> type(PERCENT);
EQ_S: '=' -> type(EQ);

FLOAT_S: [0-9]+ '.' [0-9]+ -> type(FLOAT);
INT_S: [0-9]+ -> type(INT);
STRING_S: ('"' (~["\\] | '\\' .)* '"' | '\'' (~['\\] | '\\' .)* '\'') -> type(STRING);
WITH: 'with';
ENDWITH: 'endwith';

ID_S: [a-zA-Z_][a-zA-Z0-9_]* -> type(ID);
