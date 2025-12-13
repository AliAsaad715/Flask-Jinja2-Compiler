package AST;

public class IntValue extends Value {
    int value;

    public IntValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntValue{" +
                "value=" + value +
                '}';
    }
}
