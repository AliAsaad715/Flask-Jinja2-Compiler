parser grammar PythonParser;

options { tokenVocab=PythonLexer; }

program : stmt* EOF ;

stmt
    : import_stmt        #StmtImport
    | assign_stmt        #StmtAssign
    | decorated_funcdef  #StmtDecoratedFuncdef
    | funcdef            #StmtFuncdef
    | if_stmt            #StmtIf
    | return_stmt        #StmtReturn
    | expr_stmt          #StmtExpr
    | NEWLINE            #StmtNewline
    ;

return_stmt
    : RETURN expr (COMMA expr)* end_stmt
    ;

import_stmt
    : FROM dotted_name IMPORT dotted_name (COMMA dotted_name)* end_stmt  #ImportFrom
    | IMPORT dotted_name (COMMA dotted_name)* end_stmt                   #ImportDirect
    ;

dotted_name
    : ID (DOT ID)*
    ;

assign_stmt
    : assign_target EQUAL expr end_stmt
    ;

end_stmt
    : NEWLINE  #EndNewline
    | EOF      #EndEOF
    ;

assign_target
    : ID trailer_no_call*
    ;

trailer_no_call
    : DOT ID                #TrailerNoCallAttr
    | LBRACK expr RBRACK     #TrailerNoCallIndex
    ;

decorated_funcdef
    : decorator+ funcdef
    ;

decorator
    : DECORATOR dotted_name OPEN_B arglist? CLOSE_B end_stmt
    ;

funcdef
    : DEFINETION ID OPEN_B params? CLOSE_B COLON suite
    ;

params
    : ID (COMMA ID)*
    ;

suite
    : NEWLINE INDENT stmt+ DEDENT
    ;

if_stmt
    : IF expr COLON suite (ELIF expr COLON suite)* (ELSE COLON suite)?
    ;

expr_stmt
    : expr end_stmt
    ;

expr
    : or_test
    ;

or_test
    : and_test (OR and_test)*
    ;

and_test
    : not_test (AND not_test)*
    ;

not_test
    : NOT not_test   #NotUnary
    | comparison     #NotComparison
    ;

comparison
    : arith_expr (comp_op arith_expr)*
    ;

comp_op
    : EQEQ   #CompEq
    | NOTEQ  #CompNotEq
    | IN     #CompIn
    | IS     #CompIs
    ;

arith_expr
    : atom_expr (PLUS atom_expr)*
    ;

atom_expr
    : atom trailer*
    ;

trailer
    : DOT ID                    #TrailerAttr
    | OPEN_B arglist? CLOSE_B    #TrailerCall
    | LBRACK expr RBRACK         #TrailerIndex
    ;

arglist
    : argument (COMMA argument)* (COMMA)?
    ;

argument
    : ID EQUAL expr   #ArgKeyword
    | expr            #ArgPositional
    ;

atom
    : ID                                #AtomId
    | STRING                            #AtomString
    | INT_VALUE                         #AtomInt
    | FLOAT_VALUE                       #AtomFloat
    | NONE                              #AtomNone
    | TRUE                              #AtomTrue
    | FALSE                             #AtomFalse
    | list_literal                      #AtomList
    | dict_or_set_literal               #AtomDictOrSet
    | OPEN_B (gen_expr | expr)? CLOSE_B #AtomParen
    ;

gen_expr
    : expr FOR ID IN expr (IF expr)?
    ;

nl : NEWLINE* ;

list_literal
    : LBRACK nl
        (expr (nl COMMA nl expr)*)?
        (nl COMMA)?
      nl RBRACK
    ;

dict_or_set_literal
    : LBRACE nl
        (
          dict_entry (nl COMMA nl dict_entry)* (nl COMMA)?
        | expr       (nl COMMA nl expr)*       (nl COMMA)?
        )?
      nl RBRACE
    ;

dict_entry
    : expr nl COLON nl expr
    ;
