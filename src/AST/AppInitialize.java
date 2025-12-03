package AST;


public class AppInitialize extends Declaration {
    String variable;
    Object value;

    public AppInitialize(String variable, Object value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public String toString() {
        return "AppInitialize{" +
                "variable='" + variable + '\'' +
                ", value=" + value +
                '}';
    }
}
