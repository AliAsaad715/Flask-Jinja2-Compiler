parser grammar TemplateParser;

options { tokenVocab=TemplateLexer; }

@header { package antlr; }

@members {
    private boolean nextIsStmt(int kw) {
        return _input.LA(1) == JINJA_STMT_OPEN && _input.LA(2) == kw;
    }

    private boolean nextIsEndFor() {
        return nextIsStmt(ENDFOR);
    }

    private boolean nextIsEndBlock() {
        return nextIsStmt(ENDBLOCK);
    }

    private boolean nextIsEndIf() {
        return nextIsStmt(ENDIF);
    }

    private boolean nextIsIfBranchOrEnd() {
        return _input.LA(1) == JINJA_STMT_OPEN &&
               (_input.LA(2) == ELIF || _input.LA(2) == ELSE || _input.LA(2) == ENDIF);
    }
    private boolean nextIsEndWith() {
        return nextIsStmt(ENDWITH);
    }

}

template
    : item* EOF
    ;

item
    : htmlElement     #HtmlElementItem
    | jinjaBlock      #JinjaBlockItem
    | jinjaFor        #JinjaForItem
    | jinjaIf         #JinjaIfItem
    | jinjaWith       #JinjaWithItem
    | jinjaExtends    #JinjaExtendsItem
    | jinjaPrint      #JinjaPrintItem
    | htmlText        #HtmlTextItem
    ;


htmlText
    : TEXT            #PlainText
    ;

htmlElement
    : voidElement         #HtmlVoidElement
    | normalElement       #HtmlNormalElement
    | selfClosingElement  #HtmlSelfClosingElement
    ;

normalElement
    : openTag item* closeTag
    ;

openTag
    : TAG_OPEN TAG_NAME attribute* TAG_CLOSE
    ;

selfClosingElement
    : TAG_OPEN (TAG_NAME | VOID_TAG_NAME) attribute* TAG_SELF_CLOSE
    ;

closeTag
    : TAG_OPEN TAG_SLASH (TAG_NAME | VOID_TAG_NAME) TAG_CLOSE
    ;

voidElement
    : TAG_OPEN VOID_TAG_NAME attribute* TAG_CLOSE
    ;

attribute
    : TAG_NAME (EQ attrValue)?     #AttributeKV
    ;

attrValue
    : DQUOTE attrValuePart* DQUOTE #AttrDoubleQuoted
    | SQUOTE attrValuePart* SQUOTE #AttrSingleQuoted
    ;

attrValuePart
    : ATTR_TEXT   #AttrTextValuePart
    | jinjaPrint  #AttrJinjaPrintValuePart
    ;

jinjaExtends
    : JINJA_STMT_OPEN EXTENDS (STRING | ID) JINJA_STMT_CLOSE
    ;

jinjaBlock
    : JINJA_STMT_OPEN BLOCK ID JINJA_STMT_CLOSE
      blockBodyItem*
      JINJA_STMT_OPEN ENDBLOCK JINJA_STMT_CLOSE
    ;

blockBodyItem
    : { !nextIsEndBlock() }? item
    ;

jinjaFor
    : JINJA_STMT_OPEN FOR ID (COMMA ID)* IN expr JINJA_STMT_CLOSE
      forBodyItem*
      JINJA_STMT_OPEN ENDFOR JINJA_STMT_CLOSE
    ;

forBodyItem
    : { !nextIsEndFor() }? item
    ;

jinjaIf
    : JINJA_STMT_OPEN IF expr JINJA_STMT_CLOSE
      ifThenBodyItem*
      jinjaElif*
      jinjaElse?
      JINJA_STMT_OPEN ENDIF JINJA_STMT_CLOSE
    ;

ifThenBodyItem
    : { !nextIsIfBranchOrEnd() }? item
    ;

jinjaElif
    : JINJA_STMT_OPEN ELIF expr JINJA_STMT_CLOSE
      elifBodyItem*
    ;

elifBodyItem
    : { !nextIsIfBranchOrEnd() }? item
    ;

jinjaElse
    : JINJA_STMT_OPEN ELSE JINJA_STMT_CLOSE
      elseBodyItem*
    ;
jinjaWith
    : JINJA_STMT_OPEN WITH (name=ID EQ)? value=expr? JINJA_STMT_CLOSE
      withBodyItem*
      JINJA_STMT_OPEN ENDWITH JINJA_STMT_CLOSE
    ;

withBodyItem
    : { !nextIsEndWith() }? item
    ;

elseBodyItem
    : { !nextIsEndIf() }? item
    ;

jinjaPrint
    : JINJA_EXPR_OPEN expr JINJA_EXPR_CLOSE
    ;

// ---------------------------------------------------------------------------
// Expressions
//
// This used to be `expr : exprUnit+` — a flat token soup with no precedence,
// which forced the AST builder to re-parse ctx.getText() with string splitting.
// Because getText() concatenates tokens without whitespace, `user and admin`
// arrived as the single identifier "userandadmin". The cascade below gives the
// parser real precedence so the AST builder can walk the tree directly.
// ---------------------------------------------------------------------------

expr
    : condExpr
    ;

// Jinja inline conditional:  value if condition else fallback
condExpr
    : orExpr (IF orExpr (ELSE condExpr)?)?
    ;

orExpr
    : andExpr (OR andExpr)*
    ;

andExpr
    : notExpr (AND notExpr)*
    ;

notExpr
    : NOT notExpr   #NotUnary
    | comparison    #NotPassthrough
    ;

comparison
    : filterExpr (compOp filterExpr)*
    ;

compOp
    : EQEQ      #CompEq
    | NE        #CompNotEq
    | LE        #CompLe
    | GE        #CompGe
    | LT        #CompLt
    | GT        #CompGt
    | NOT IN    #CompNotIn
    | IN        #CompIn
    | IS NOT    #CompIsNot
    | IS        #CompIs
    ;

// Jinja filters:  value | length  |  value | default('n/a')
filterExpr
    : additive (PIPE filterCall)*
    ;

filterCall
    : ID (LPAREN argList? RPAREN)?
    ;

additive
    : multiplicative ((PLUS | MINUS) multiplicative)*
    ;

multiplicative
    : unary ((STAR | SLASH | PERCENT) unary)*
    ;

unary
    : MINUS unary   #UnaryMinus
    | postfix       #UnaryPassthrough
    ;

postfix
    : primary trailer*
    ;

trailer
    : DOT ID                    #TrailerAttr
    | LBRACK subscript RBRACK   #TrailerIndex
    | LPAREN argList? RPAREN    #TrailerCall
    ;

// Supports both x[0] and the slice forms x[:100], x[1:5], x[1:]
subscript
    : expr                #SubscriptIndex
    | start=expr? COLON stop=expr?  #SubscriptSlice
    ;

argList
    : argument (COMMA argument)* COMMA?
    ;

argument
    : ID EQ expr   #ArgKeyword
    | expr         #ArgPositional
    ;

primary
    : ID                        #PrimaryId
    | INT                       #PrimaryInt
    | FLOAT                     #PrimaryFloat
    | STRING                    #PrimaryString
    | TRUE                      #PrimaryTrue
    | FALSE                     #PrimaryFalse
    | NONE                      #PrimaryNone
    | LPAREN expr RPAREN        #PrimaryParen
    | LBRACK exprList? RBRACK   #PrimaryList
    ;

exprList
    : expr (COMMA expr)* COMMA?
    ;
