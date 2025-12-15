package AST;

public class ObjectValue extends Value {
    String key;
    Value value;

    public ObjectValue(Value value, String key) {
        this.value = value;
        this.key = key;
    }

    @Override
    public String toString() {
        return "ObjectValue{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
