parser grammar PythonParser;

options { tokenVocab=PythonLexer; }

program : stmt* EOF ;

// =====================
// Statements
// =====================

stmt
    : import_stmt
    | assign_stmt
    | decorated_funcdef
    | funcdef                      // allow plain "def ..."
    | if_stmt                      // allow if / elif / else
    | return_stmt
    | expr_stmt
    | NEWLINE
    ;

return_stmt
    : RETURN expr (COMMA expr)* NEWLINE     // allow: return "x", 404
    ;

import_stmt
    : FROM dotted_name IMPORT dotted_name (COMMA dotted_name)* NEWLINE
    | IMPORT dotted_name (COMMA dotted_name)* NEWLINE
    ;

dotted_name
    : ID (DOT ID)*
    ;

// allow targets like: app.config['UPLOAD_FOLDER'] = ...
assign_stmt
    : assign_target EQUAL expr NEWLINE
    ;

assign_target
    : ID trailer_no_call*
    ;

trailer_no_call
    : DOT ID
    | LBRACK expr RBRACK
    ;

// decorator supports args + keyword args:
// @app.route('/x', methods=['GET','POST'])
decorated_funcdef
    : decorator+ funcdef
    ;

decorator
    : DECORATOR dotted_name OPEN_B arglist? CLOSE_B NEWLINE
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
    : expr NEWLINE
    ;

// =====================
// Expressions (subset used by app_py.txt)
// =====================

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

// generator expr used by: next((p for p in products if ...), None)
gen_expr
    : expr FOR ID IN expr (IF expr)?
    ;

list_literal
    : LBRACK (expr (COMMA expr)* (COMMA)?)? RBRACK
    ;

// dict: {'id': 1, ...}   set: {'png','jpg'}
dict_or_set_literal
    : LBRACE
        (
          dict_entry (COMMA dict_entry)* (COMMA)?
        | expr (COMMA expr)* (COMMA)?
        )?
      RBRACE
    ;

dict_entry
    : expr COLON expr
    ;
