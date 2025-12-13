package AST;

public class StringValue extends Value {
    String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StringValue{" +
                "value=" + value +
                '}';
    }
}
