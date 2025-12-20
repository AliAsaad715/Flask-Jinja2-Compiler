parser grammar TemplateParser;

options { tokenVocab=TemplateLexer; }

@header { package antlr; }

template
    : item* EOF
    ;

item
    : htmlElement     #HtmlElementItem
    | jinjaBlock      #JinjaBlockItem
    | jinjaFor        #JinjaForItem
    | jinjaIf         #JinjaIfItem
    | jinjaExtends    #JinjaExtendsItem
    | jinjaPrint      #JinjaPrintItem
    | htmlText        #HtmlTextItem
    ;

htmlText
    : TEXT            #PlainText
    ;

htmlElement
    : normalElement       #HtmlNormalElement
    | selfClosingElement  #HtmlSelfClosingElement
    ;

normalElement
    : openTag item* closeTag
    ;

openTag
    : TAG_OPEN TAG_NAME attribute* TAG_CLOSE
    ;

closeTag
    : TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE
    ;

selfClosingElement
    : TAG_OPEN TAG_NAME attribute* TAG_SELF_CLOSE
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
      item*
      JINJA_STMT_OPEN ENDBLOCK JINJA_STMT_CLOSE
    ;

jinjaFor
    : JINJA_STMT_OPEN FOR ID IN expr JINJA_STMT_CLOSE
      item*
      JINJA_STMT_OPEN ENDFOR JINJA_STMT_CLOSE
    ;

jinjaIf
    : JINJA_STMT_OPEN IF expr JINJA_STMT_CLOSE
      item*
      jinjaElif*
      jinjaElse?
      JINJA_STMT_OPEN ENDIF JINJA_STMT_CLOSE
    ;

jinjaElif
    : JINJA_STMT_OPEN ELIF expr JINJA_STMT_CLOSE
      item*
    ;

jinjaElse
    : JINJA_STMT_OPEN ELSE JINJA_STMT_CLOSE
      item*
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
    | LPAREN expr RPAREN        #AtomParen
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
