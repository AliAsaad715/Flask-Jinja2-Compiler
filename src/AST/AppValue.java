package AST;

public class AppValue extends Value {
    String appName;

    public AppValue(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "AppValue{" +
                "appName='" + appName + '\'' +
                '}';
    }
}
