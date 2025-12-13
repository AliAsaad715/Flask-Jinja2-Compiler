package AST;

public class Declaration {
    String name;
    Value value;

    public Declaration(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Declaration{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
