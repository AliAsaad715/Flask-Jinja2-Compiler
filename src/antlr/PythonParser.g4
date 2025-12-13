parser grammar PythonParser;

options {tokenVocab=PythonLexer;}

program: importing+ declaration+ route* server_startup EOF #Prog;
importing: FROM FLASK IMPORT libraries+ #Import;
libraries: FLASK_LIBRARY #Library;
declaration: ID EQUAL value #Decl;
value: SINGLE_QUOTES STRING_VALUE? STRING_END #String_Value
     | INT_VALUE #Int_Value
     | FLASK_LIBRARY OPEN_B APP_NAME CLOSE_B #AppValue;
route: DECORATOR ID DOT ROUTE OPEN_B SINGLE_QUOTES SLASH STRING_VALUE? STRING_END CLOSE_B function #Routes;
function: DEFINETION ID OPEN_B parameter* CLOSE_B COLON declaration* RETURN (ID | value) #Functions;
parameter: ID #Params;
server_startup: ID DOT RUN OPEN_B CLOSE_B #RunServer;
