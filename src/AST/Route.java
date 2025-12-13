package AST;

public class Route {
    String method;
    String URL;
    Function function;

    public Route(String URL, Function function) {
        this.URL = URL;
        this.function = function;
    }

    @Override
    public String toString() {
        return "Route{" +
                "URL='" + URL + '\'' +
                ", function=" + function +
                '}';
    }
}
