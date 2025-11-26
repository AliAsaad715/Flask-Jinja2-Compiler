lexer grammar PythonLexer;

ID: [a-zA-Z];
EQUAL: '=';
INT_VALUE: '0'
         | '-'?[1-9][0-9]*
         ;
FLOAT_VALUE: INT_VALUE '.' INT_VALUE;