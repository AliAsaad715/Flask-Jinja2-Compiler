package AST;

public class FloatDeclaration extends Declaration {
    float value;

    public FloatDeclaration(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Float Value = " + this.value;
    }
}
