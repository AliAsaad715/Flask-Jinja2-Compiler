# Flask & Jinja2 Compiler

A compiler for a Flask web application and its Jinja2 templates, written in Java 21
with ANTLR 4.13.2. It front-ends **four languages** — Python, Jinja2, HTML and CSS —
builds two abstract syntax trees, links them together, checks them for meaning, and
emits a runnable Flask project.

Compilers course project, 2025/2026.

## Quick start

```powershell
.\build.ps1 -Grammar     # regenerate out-of-date ANTLR parsers, then compile
.\run.ps1                # compile the project in Tests/ and generate the app
```

The build is incremental: only changed sources are recompiled, and grammar
pairs are regenerated only when their `.g4` inputs are newer than the parsers
generated from them. Use `.\build.ps1 -Clean` to force a full rebuild.

Then run what the compiler produced:

```powershell
cd generated
python app.py
```

Other useful invocations:

```powershell
.\run.ps1 --nodes                    # also list every AST node with its children
.\run.ps1 Tests/errors/app_py.txt Tests/errors/base_html.txt `
          Tests/errors/broken_html.txt Tests/errors/orphan_html.txt
```

That last one compiles the deliberately broken fixture set and reports all twelve
kinds of semantic error.

## Pipeline

```
source ──▶ lexer ──▶ parser ──▶ visitor ──▶ AST ──┬─▶ generator ──▶ semantic ──▶ code
                                                  │    analysis      generation
                                            symbol tables
```

| Stage | Where |
|---|---|
| Lexical analysis | `src/antlr/*Lexer.g4` |
| Syntax analysis | `src/antlr/*Parser.g4` |
| AST construction | `src/Visitor/` |
| Node hierarchy | `src/AST/` |
| Symbol tables | `src/Symbol/` |
| Data generator | `src/Generator/DataGenerator.java` |
| Semantic analysis | `src/Semantic/` |
| Code generation | `src/CodeGen/` |
| Driver | `src/app/Main.java` |

### Lexers

`PythonLexer.g4` synthesises `INDENT` / `DEDENT` tokens from a Java-side indent
stack, since Python's block structure is whitespace-significant.

`TemplateLexer.g4` uses **six lexer modes** — default, `TAG_MODE`, `ATTR_DQ_MODE`,
`ATTR_SQ_MODE`, `JINJA_EXPR_MODE`, `JINJA_STMT_MODE` — pushed and popped as the
scanner crosses `<`, `{{` and `{%`. This is what lets one grammar handle HTML with
Jinja embedded in both element bodies and attribute values.

`CssLexer.g4` is flat.

### Parsers

`TemplateParser.g4` uses semantic predicates (`{ !nextIsEndFor() }?`) to decide
where a Jinja block body ends without ambiguity, and a full precedence cascade for
expressions — `condExpr → orExpr → andExpr → notExpr → comparison → filterExpr →
additive → multiplicative → unary → postfix → primary`.

### Node hierarchy

Everything descends from the abstract `AstNode`, which stores the node name, the
source line, and the children. Each subclass overrides one method, `describe()`,
and all three printers read it.

```
AstNode  (abstract — nodeName, line, children)
├── Python family      ProgramNode, ImportNode, AssignNode, FunctionNode,
│                      RouteNode, DecoratorNode, IfNode, ReturnNode, BlockNode,
│                      BinaryOpNode, UnaryOpNode, CallNode, AttributeNode,
│                      SubscriptNode, ListNode, DictNode, PairNode, GeneratorNode,
│                      StringNode, NumberNode, BoolNode, NoneNode, IdentifierNode
├── TemplateNode (abstract)
│   └── TemplateItemNode (abstract)
│       ├── HtmlNode  (abstract) ── ElementNode, TextNode
│       └── JinjaNode (abstract) ── BlockNode, ForNode, IfNode, WithNode,
│                                   PrintNode, ExtendsNode
├── ExprNode (abstract)  NameExpr, AttrExpr, IndexExpr, SliceExpr, CallExpr,
│                        FilterExpr, BinaryExpr, UnaryExpr, CondExpr, ListExpr,
│                        LiteralExpr
└── CssNode (abstract)   CssFileNode, CssRuleNode, CssDeclNode
```

### Printing

Three printers, all driven by the same `describe()` override:

- `pretty()` — the whole tree as a box-drawing diagram
- `printTree()` — the whole tree as an indented class listing
- `printNode()` — one node and its immediate children (`--nodes`)

Symbol tables print via `SymbolTablePython.format()` and `SymbolTable.print()`.

### The data generator

`DataGenerator` is the bridge between the two trees. For every
`render_template('page.html', key=value)` it resolves each context value against
the module's top-level data and attaches the resolved Python node to the matching
template's tree as a `BoundDataNode`. After this pass, printing the template AST
shows the actual product list from `app.py` sitting inside the Jinja tree that
renders it.

### Semantic analysis

Twelve checks, collected rather than thrown so one run reports everything.

| Code | Check |
|---|---|
| SEM01 | Undefined name in the Python code |
| SEM02 | Duplicate function definition |
| SEM03 | Duplicate route URL |
| SEM04 | Route URL parameters do not match the view function's parameters |
| SEM05 | `render_template` names a template that does not exist |
| SEM06 | Function called with the wrong number of arguments |
| SEM07 | Template uses a variable its route never passes |
| SEM08 | `{% extends %}` target does not exist |
| SEM09 | `{% block %}` is not declared in the parent template |
| SEM10 | Unknown Jinja filter |
| SEM11 | Route passes context the template never uses *(warning)* |
| SEM12 | Template is never rendered and never extended *(warning)* |

`Tests/errors/` is a fixture set built to trigger every one of them.

### Code generation

`CodeGenerator` walks the trees back to source, writing a Flask project laid out
the way Flask expects:

```
generated/
├── app.py
├── templates/   base.html, products.html, product_detail.html,
│                add_product.html, delete_product.html
└── static/      style.css
```

Because the AST does not record parentheses, both emitters re-derive them from a
precedence table, so `x = 1 - (2 - 3)` round-trips correctly.

## Web interfaces

Four views, with navigation between them:

| Route | View |
|---|---|
| `/products` | product list |
| `/product/<int:product_id>` | product details |
| `/add-product` | add a product |
| `/delete-product/<int:product_id>` | delete confirmation |

## Layout

```
src/antlr/     grammars and the parsers ANTLR generates from them
src/AST/       node classes: python/, template/, template/expr/, css/
src/Visitor/   parse tree ──▶ AST
src/Symbol/    symbol tables and scopes
src/Semantic/  semantic analysis
src/Generator/ the Python ──▶ Jinja data bridge
src/CodeGen/   emitters
src/app/       driver and error collector
Tests/         input fixtures; Tests/errors/ triggers every semantic check
lib/           the ANTLR jar
```
