package AST;

import java.util.ArrayList;

public class Program {
    ArrayList<Importing> imports;
    ArrayList<Declaration> declarations;
    ArrayList<Route> routes;

    public Program() {
        this.imports = new ArrayList<>();
        this.declarations = new ArrayList<>();
        this.routes = new ArrayList<>();
    }

    public void addImport(Importing importing) {
        this.imports.add(importing);
    }
    public void addDeclaration(Declaration declaration) {
        this.declarations.add(declaration);
    }

    public void addRoute(Route route) {
        this.routes.add(route);
    }

    @Override
    public String toString() {
        return "Program{" +
                "imports=" + imports +
                "\n, declarations=" + declarations +
                "\n, routes=" + routes +
                '}';
    }
}
