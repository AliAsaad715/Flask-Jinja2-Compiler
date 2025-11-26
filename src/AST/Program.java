package AST;

import java.util.ArrayList;

public class Program {
    ArrayList<Declaration> declarations;

    public Program() {
        this.declarations = new ArrayList<>();
    }

    public void addChild(Declaration declaration) {
        this.declarations.add(declaration);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Declaration declaration : this.declarations) {
            stringBuilder.append(declaration);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
