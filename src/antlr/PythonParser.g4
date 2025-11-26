parser grammar PythonParser;

options {tokenVocab=PythonLexer;}

program: decl+ EOF #Prog;
decl: ID EQUAL value #Declaration;
value: INT_VALUE
     | FLOAT_VALUE
     ;