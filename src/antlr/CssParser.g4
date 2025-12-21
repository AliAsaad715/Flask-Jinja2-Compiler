parser grammar CssParser;

options { tokenVocab=CssLexer; }

@header { package antlr; }

stylesheet
    : cssRule* EOF
    ;

cssRule
    : selector LBRACE decl* RBRACE   #CssRuleDef
    ;

selector
    : selectorPart+                  #SelectorSeq
    ;

selectorPart
    : IDENT                          #SelIdent
    | DOT IDENT                      #SelClass
    | HASH IDENT                     #SelId
    | COMMA                          #SelComma
    ;

decl
    : property=IDENT COLON value SEMI  #Declaration
    ;

value
    : valuePart+                     #ValueSeq
    ;

valuePart
    : IDENT                          #ValIdent
    | NUMBER                         #ValNumber
    | STRING                         #ValString
    | COLOR                          #ValColor
    | DOT                            #ValDot
    | HASH                           #ValHash
    | COMMA                          #ValComma
    | PERCENT                        #ValPercent
    | PLUS                           #ValPlus
    | MINUS                          #ValMinus
    | STAR                           #ValStar
    | SLASH                          #ValSlash
    | LPAREN                         #ValLParen
    | RPAREN                         #ValRParen
    ;
