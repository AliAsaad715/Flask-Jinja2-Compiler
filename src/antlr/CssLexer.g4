lexer grammar CssLexer;

@header { package antlr; }

COMMENT: '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;

LBRACE: '{';
RBRACE: '}';
COLON: ':';
SEMI: ';';
COMMA: ',';
LPAREN: '(';
RPAREN: ')';
PERCENT: '%';
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';

DOT: '.';
HASH: '#';

COLOR: HASH HEX HEX HEX (HEX HEX HEX)?;
NUMBER: DIGIT+ (DOT DIGIT+)?;
STRING: '"' (ESC | ~["\\])* '"' | '\'' (ESC | ~['\\])* '\'';
IDENT: [a-zA-Z_-][a-zA-Z0-9_-]*;

fragment HEX: [0-9a-fA-F];
fragment DIGIT: [0-9];
fragment ESC: '\\' .;
