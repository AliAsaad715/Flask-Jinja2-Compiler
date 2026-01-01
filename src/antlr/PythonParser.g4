parser grammar PythonParser;

options { tokenVocab=PythonLexer; }

program : stmt* EOF ;

stmt
    : import_stmt
    | assign_stmt
    | decorated_funcdef
    | funcdef
    | if_stmt
    | return_stmt
    | expr_stmt
    | NEWLINE
    ;

return_stmt
    : RETURN expr (COMMA expr)* end_stmt
    ;

import_stmt
    : FROM dotted_name IMPORT dotted_name (COMMA dotted_name)* end_stmt
    | IMPORT dotted_name (COMMA dotted_name)* end_stmt
    ;

dotted_name
    : ID (DOT ID)*
    ;

assign_stmt
    : assign_target EQUAL expr end_stmt
    ;

end_stmt
    : NEWLINE
    | EOF
    ;

assign_target
    : ID trailer_no_call*
    ;

trailer_no_call
    : DOT ID
    | LBRACK expr RBRACK
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
    : NOT not_test
    | comparison
    ;

comparison
    : arith_expr (comp_op arith_expr)*
    ;

comp_op
    : EQEQ
    | NOTEQ
    | IN
    | IS
    ;

arith_expr
    : atom_expr (PLUS atom_expr)*
    ;

atom_expr
    : atom trailer*
    ;

trailer
    : DOT ID
    | OPEN_B arglist? CLOSE_B
    | LBRACK expr RBRACK
    ;

arglist
    : argument (COMMA argument)* (COMMA)?
    ;

argument
    : ID EQUAL expr
    | expr
    ;

atom
    : ID
    | STRING
    | INT_VALUE
    | FLOAT_VALUE
    | NONE
    | TRUE
    | FALSE
    | list_literal
    | dict_or_set_literal
    | OPEN_B (gen_expr | expr)? CLOSE_B
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
