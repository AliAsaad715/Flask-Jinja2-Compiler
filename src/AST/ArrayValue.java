package AST;

import java.util.ArrayList;

public class ArrayValue extends Value {
    ArrayList<Value> elements;

    public ArrayValue(ArrayList<Value> elements) {
        this.elements = elements;
    }

    public void addElement(Value element) {
        this.elements.add(element);
    }

    @Override
    public String toString() {
        return "ArrayValue{" +
                "elements=" + elements +
                '}';
    }
}