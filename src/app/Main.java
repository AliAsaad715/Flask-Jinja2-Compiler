package app;

import AST.css.CssFileNode;
import AST.python.AstNode;
import AST.python.ProgramNode;
import AST.template.TemplateFileNode;
import Semantic.FlaskModel;
import Semantic.SemanticAnalyzer;
import Semantic.SemanticError;
import Generator.DataGenerator;
import CodeGen.CodeGenerator;
import Visitor.CssAstBuilder;
import Visitor.PythonVisitor;
import Visitor.TemplateAstBuilder;
import Visitor.TemplateSymbolCollector;
import antlr.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Compiler driver.
 *
 * <p>Runs the full pipeline over a Flask project: lexing and parsing for all four
 * languages, AST construction, symbol tables, the data generator that links the
 * Python tree to the Jinja tree, semantic analysis, and code generation.
 */
public class Main {

    private static final String[] DEFAULT_SOURCES = {
            "Tests/app_py.txt",
            "Tests/base_html.txt",
            "Tests/products_html.txt",
            "Tests/product_detail_html.txt",
            "Tests/add_product_html.txt",
            "Tests/delete_product_html.txt",
            "Tests/style_css.txt",
    };

    /** Where the generated, runnable Flask project is written. */
    private static final String OUTPUT_DIR = "generated";

    private enum Kind { PYTHON, TEMPLATE, CSS }

    /** One parsed source file. */
    private static class Unit {
        String path;
        String logicalName;
        Kind kind;
        AstNode ast;
        String symbolTable;
        ErrorCollector errors;
    }

    public static void main(String[] args) {
        // The sources carry Arabic product names; without this the Windows console
        // codepage turns every non-ASCII character into a question mark.
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        boolean listNodes = false;
        List<String> given = new ArrayList<>();
        for (String a : args) {
            if ("--nodes".equals(a)) listNodes = true;
            else given.add(a);
        }
        List<String> paths = given.isEmpty() ? Arrays.asList(DEFAULT_SOURCES) : given;

        List<Unit> units = new ArrayList<>();
        int syntaxErrors = 0;

        // ---------------------------------------------------------- 1. front end
        System.out.println("=== 1. LEXICAL & SYNTAX ANALYSIS ===\n");
        for (String path : paths) {
            Unit u = parse(path);
            if (u == null) continue;
            units.add(u);
            syntaxErrors += u.errors.count();

            System.out.printf("  %-34s %-9s %s%n", u.path, u.kind,
                    u.errors.hasErrors() ? u.errors.count() + " error(s)" : "ok");
            for (String m : u.errors.getMessages()) {
                System.out.println("      " + m);
            }
        }
        System.out.println("\n  " + units.size() + " file(s), " + syntaxErrors + " syntax error(s)");

        // -------------------------------------------------- gather the two trees
        ProgramNode program = null;
        String pythonSource = "app.py";
        Map<String, TemplateFileNode> templates = new LinkedHashMap<>();
        Map<String, TemplateSymbolCollector> collectors = new LinkedHashMap<>();
        Map<String, String> templatePaths = new LinkedHashMap<>();

        for (Unit u : units) {
            if (u.kind == Kind.PYTHON && u.ast instanceof ProgramNode) {
                program = (ProgramNode) u.ast;
                pythonSource = u.path;
            } else if (u.kind == Kind.TEMPLATE && u.ast instanceof TemplateFileNode) {
                templates.put(u.logicalName, (TemplateFileNode) u.ast);
                templatePaths.put(u.logicalName, u.path);
                TemplateSymbolCollector c = new TemplateSymbolCollector();
                u.symbolTable = c.collect((TemplateFileNode) u.ast).print();
                collectors.put(u.logicalName, c);
            }
        }

        // ------------------------------------------------------- 2. the generator
        FlaskModel model = FlaskModel.from(program);

        System.out.println("\n=== 2. GENERATOR — passing data from the Python tree into the Jinja tree ===\n");
        DataGenerator generator = new DataGenerator(model);
        int transferred = generator.generate(templates);
        if (generator.getTransferLog().isEmpty()) {
            System.out.println("  (no context data to transfer)");
        } else {
            System.out.printf("  %-22s %-12s    %s%n", "TEMPLATE", "VARIABLE", "SOURCE");
            for (String line : generator.getTransferLog()) System.out.println("  " + line);
        }
        System.out.println("\n  " + transferred + " value(s) transferred into "
                + templates.size() + " template tree(s)");

        // ------------------------------------------------- 3. semantic analysis
        System.out.println("\n=== 3. SEMANTIC ANALYSIS ===\n");
        SemanticAnalyzer analyzer = new SemanticAnalyzer(model, pythonSource);
        for (Map.Entry<String, TemplateFileNode> e : templates.entrySet()) {
            TemplateSymbolCollector c = collectors.get(e.getKey());
            analyzer.addTemplate(e.getKey(), templatePaths.get(e.getKey()), e.getValue(),
                    c == null ? Map.of() : c.getContextVariables());
        }

        List<SemanticError> semantic = analyzer.analyze(program);
        long hard = semantic.stream().filter(SemanticError::isError).count();

        if (semantic.isEmpty()) {
            System.out.println("  No semantic errors found.");
        } else {
            for (SemanticError e : semantic) System.out.println("  " + e);
        }
        System.out.println("\n  " + hard + " error(s), " + (semantic.size() - hard) + " warning(s)");

        // ------------------------------------------------------------- 4. trees
        System.out.println("\n=== 4. ABSTRACT SYNTAX TREES ===");
        for (Unit u : units) {
            if (u.ast == null) continue;
            System.out.println("\n--- " + u.path + " (" + u.kind + ") ---");
            System.out.println(u.ast.pretty());
            if (u.symbolTable != null) {
                System.out.println("--- symbol table: " + u.path + " ---");
                System.out.println(u.symbolTable);
            }
        }

        // -------------------------------------------------------- 5. code generation
        System.out.println("=== 5. CODE GENERATION ===\n");
        if (hard > 0) {
            System.out.println("  Skipped: fix the " + hard + " semantic error(s) first.\n");
        } else {
            try {
                CodeGenerator codegen = new CodeGenerator(Path.of(OUTPUT_DIR));
                if (program != null) codegen.generatePythonApp(program);
                for (Map.Entry<String, TemplateFileNode> e : templates.entrySet()) {
                    codegen.generateTemplate(e.getKey(), e.getValue());
                }
                for (Unit u : units) {
                    if (u.kind == Kind.CSS && u.ast instanceof CssFileNode) {
                        codegen.generateStylesheet(u.logicalName, (CssFileNode) u.ast);
                    }
                }
                for (String f : codegen.getGeneratedFiles()) {
                    System.out.println("  wrote  " + Path.of(f).toAbsolutePath().normalize());
                }
                System.out.println("\n  " + codegen.getGeneratedFiles().size()
                        + " file(s) written to " + Path.of(OUTPUT_DIR).toAbsolutePath().normalize());
                System.out.println("  Run it with:  cd " + OUTPUT_DIR + " && python app.py\n");
            } catch (Exception e) {
                System.out.println("  Code generation failed: " + e.getMessage() + "\n");
            }
        }

        // Requirement 7 also asks for a per-node printer, not only a whole-tree one.
        if (listNodes) {
            System.out.println("=== 5. NODE-BY-NODE LISTING ===\n");
            for (Unit u : units) {
                if (u.ast == null) continue;
                System.out.println("--- " + u.path + " ---");
                printEveryNode(u.ast);
                System.out.println();
            }
        }

        System.out.println("=== SUMMARY ===");
        System.out.println("  syntax errors   : " + syntaxErrors);
        System.out.println("  semantic errors : " + hard);
        System.out.println("  data transferred: " + transferred + " value(s)");
    }

    /** Prints every node in the tree with its immediate children. */
    private static void printEveryNode(AstNode node) {
        if (node == null) return;
        System.out.println(node.printNode());
        for (AstNode c : node.getChildren()) printEveryNode(c);
    }

    // ------------------------------------------------------------------ parsing

    private static Unit parse(String path) {
        String text;
        try {
            text = Files.readString(Path.of(path));
        } catch (Exception e) {
            System.out.printf("  %-34s %-9s cannot read: %s%n", path, "-", e.getMessage());
            return null;
        }

        Unit u = new Unit();
        u.path = path;
        u.kind = classify(path, text);
        u.logicalName = logicalName(path);
        u.errors = new ErrorCollector(path);

        try {
            switch (u.kind) {
                case PYTHON:   parsePython(text, u); break;
                case TEMPLATE: u.ast = parseTemplate(text, u.errors); break;
                case CSS:      u.ast = parseCss(text, u.errors); break;
            }
        } catch (RuntimeException e) {
            // A lexer that throws (for example on inconsistent indentation) must not
            // take down the whole run — record it and carry on with the other files.
            u.errors.syntaxError(null, null, 0, 0, e.getMessage(), null);
        }
        return u;
    }

    private static void parsePython(String text, Unit u) {
        CharStream input = CharStreams.fromString(text);

        PythonLexer lexer = new PythonLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(u.errors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        PythonParser parser = new PythonParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(u.errors);

        ParseTree tree = parser.program();
        PythonVisitor visitor = new PythonVisitor(tokens);
        u.ast = visitor.visit(tree);
        u.symbolTable = visitor.getSymbolTable().format();
    }

    private static AstNode parseTemplate(String text, ErrorCollector errors) {
        TemplateLexer lexer = new TemplateLexer(CharStreams.fromString(text));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errors);

        TemplateParser parser = new TemplateParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(errors);

        return new TemplateAstBuilder().visit(parser.template());
    }

    private static AstNode parseCss(String text, ErrorCollector errors) {
        CssLexer lexer = new CssLexer(CharStreams.fromString(text));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errors);

        CssParser parser = new CssParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(errors);

        return new CssAstBuilder().visit(parser.stylesheet());
    }

    // ------------------------------------------------------- file classification

    /**
     * Decides which language a file is written in.
     *
     * <p>Extension first, then a content probe. An earlier version returned CSS for
     * any path merely containing the letters "css", so a template named
     * css_layout.html was sent to the CSS parser.
     */
    private static Kind classify(String path, String text) {
        String name = Path.of(path).getFileName().toString().toLowerCase();

        if (name.endsWith(".py") || name.endsWith("_py.txt")) return Kind.PYTHON;
        if (name.endsWith(".css") || name.endsWith("_css.txt")) return Kind.CSS;
        if (name.endsWith(".html") || name.endsWith(".htm")
                || name.endsWith(".jinja") || name.endsWith("_html.txt")) return Kind.TEMPLATE;

        return sniff(text);
    }

    /**
     * Guesses the language of a file whose name gives nothing away, by scoring
     * markers that are characteristic of each language rather than single
     * characters. Testing only for '&lt;' used to send `if x &lt;= 2:` to the template
     * parser.
     */
    private static Kind sniff(String text) {
        int python = 0, template = 0, css = 0;

        if (text.contains("{%")) template += 3;
        if (text.contains("{{")) template += 3;
        if (TAG_PATTERN.matcher(text).find()) template += 2;
        if (text.contains("<!DOCTYPE") || text.contains("<!doctype")) template += 3;

        if (text.contains("def ")) python += 3;
        if (text.contains("import ")) python += 2;
        if (text.contains("return ")) python += 2;
        if (text.contains("@app.")) python += 3;
        if (text.contains("__name__")) python += 2;

        if (CSS_RULE_PATTERN.matcher(text).find()) css += 3;

        if (template >= python && template >= css && template > 0) return Kind.TEMPLATE;
        if (css > python && css > 0) return Kind.CSS;
        return Kind.PYTHON;
    }

    /** An HTML-looking tag such as &lt;div ...&gt; or &lt;/div&gt;. */
    private static final java.util.regex.Pattern TAG_PATTERN =
            java.util.regex.Pattern.compile("</?[a-zA-Z][a-zA-Z0-9]*[\\s/>]");

    /** A CSS rule: a selector, a brace, then `property: value`. */
    private static final java.util.regex.Pattern CSS_RULE_PATTERN =
            java.util.regex.Pattern.compile("[.#]?[-\\w]+\\s*\\{[^}]*[-\\w]+\\s*:[^}]+}", java.util.regex.Pattern.DOTALL);

    /**
     * The name the project refers to a file by. The fixtures are stored as
     * products_html.txt but the application renders 'products.html', so the two
     * halves need a shared name to be linked.
     */
    private static String logicalName(String path) {
        String name = Path.of(path).getFileName().toString();
        if (name.toLowerCase().endsWith(".txt")) {
            name = name.substring(0, name.length() - 4);
            int underscore = name.lastIndexOf('_');
            if (underscore > 0) {
                name = name.substring(0, underscore) + "." + name.substring(underscore + 1);
            }
        }
        return name;
    }
}
