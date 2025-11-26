package AST;

public class FloatValue extends Value {
    float value;

    public FloatValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Float Value = " + this.value;
    }
}
