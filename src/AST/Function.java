package AST;

import java.util.ArrayList;

public class Function {
    String name;
    ArrayList<Parameter> parameters;
    Value returnValue;

    public Function(String name, Value returnValue) {
        this.name = name;
        this.parameters = new ArrayList<>();
        this.returnValue = returnValue;
    }

    public void addParameter(Parameter parameter) {
        this.parameters.add(parameter);
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                ", returnValue=" + returnValue +
                '}';
    }
}
