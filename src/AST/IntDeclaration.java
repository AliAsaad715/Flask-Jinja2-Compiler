package AST;

public class IntDeclaration extends Declaration {
    int value;

    public IntDeclaration(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Int Value = " + this.value;
    }
}
