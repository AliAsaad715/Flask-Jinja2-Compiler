package AST;

public class Parameter {
    String name;

    public Parameter(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "name=" + name +
                '}';
    }
}
