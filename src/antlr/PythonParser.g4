parser grammar PythonParser;

options {tokenVocab=PythonLexer;}

program: importing app_initialization route* server_startup EOF #Prog;
importing: FROM FLASK IMPORT libraries+ #Import;
libraries: FLASK_LIBRARY #Library;
app_initialization: ID EQUAL FLASK_LIBRARY OPEN_B APP_NAME CLOSE_B #App_Initialize;
route: DECORATOR ID DOT ROUTE OPEN_B SINGLE_QUOTES SLASH STRING_TEXT* INT_VALUE* STRING_END CLOSE_B function #Routes;
function: DEFINETION ID OPEN_B CLOSE_B COLON RETURN SINGLE_QUOTES STRING_TEXT* STRING_END #Functions;
server_startup: ID DOT RUN OPEN_B CLOSE_B #Run_Server;

