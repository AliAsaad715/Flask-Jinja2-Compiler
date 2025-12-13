//lexer grammar PythonLexer;
//
//FROM: 'from';
//IMPORT: 'import';
//FLASK: 'flask';
//FLASK_LIBRARY: 'Flask';
//DEFINETION: 'def';
//COLON: ':';
//RETURN: 'return';
//RUN: 'run';
//EQUAL: '=';
//OPEN_B: '(';
//CLOSE_B: ')';
//APP_NAME: '__name__';
//DECORATOR: '@';
//DOT: '.';
//ROUTE: 'route';
//
//SINGLE_QUOTES: '\'' -> pushMode(STRING_MODE);
//
//ID: [a-zA-Z_][a-zA-Z0-9_]*;
//INT_VALUE: '0'
//         | '-'?[1-9][0-9]*
//         ;
//WS: [ \t]+ -> channel(HIDDEN);
//NEWLINE: [\n\r] -> skip;
//
//mode STRING_MODE;
//SLASH: '/';
//STRING_VALUE: ~['\n\r\t\\/]+;
//Empty_String: ;
//STRING_ESCAPE: '\\' .;
//STRING_END: '\'' -> popMode;

lexer grammar PythonLexer;

FROM: 'from';
IMPORT: 'import';
FLASK: 'flask';
FLASK_LIBRARY: 'Flask';
DEFINETION: 'def';
COLON: ':';
RETURN: 'return';
RUN: 'run';
EQUAL: '=';
OPEN_B: '(';
CLOSE_B: ')';
APP_NAME: '__name__';
DECORATOR: '@';
DOT: '.';
ROUTE: 'route';

SINGLE_QUOTES: '\'' -> pushMode(STRING_MODE);

ID: [a-zA-Z_][a-zA-Z0-9_]*;
INT_VALUE: '0'
         | '-'?[1-9][0-9]*
         ;
WS: [ \t]+ -> channel(HIDDEN);
NEWLINE: [\n\r] -> skip;

mode STRING_MODE;
SLASH: '/';
STRING_VALUE: ~['\n\r\t\\/]+;
STRING_ESCAPE: '\\' .;
STRING_END: '\'' -> popMode;
