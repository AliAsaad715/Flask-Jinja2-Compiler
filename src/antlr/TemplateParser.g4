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
    : JINJA_STMT_OPEN FOR ID IN expr JINJA_STMT_CLOSE
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
    : JINJA_STMT_OPEN WITH expr JINJA_STMT_CLOSE
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

expr
    : exprUnit+     #ExprSequence
    ;

exprUnit
    : atom          #ExprAtomUnit
    | op            #ExprOpUnit
    | punct         #ExprPunctUnit
    ;

atom
    : ID                        #AtomId
    | INT                       #AtomInt
    | STRING                    #AtomString
    | LPAREN expr? RPAREN       #AtomParen
    | LBRACK expr? RBRACK       #AtomBracket
    ;

op
    : PLUS
    | MINUS
    | STAR
    | SLASH
    | GT
    | LT
    | GE
    | LE
    | EQEQ
    | NE
    | PIPE
    | EQ
    ;

punct
    : DOT
    | COMMA
    | COLON
    ;
