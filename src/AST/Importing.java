package AST;

import java.util.ArrayList;

public class Importing {
    String packageName;
    ArrayList<String> objects;

    public Importing(String packageName) {
        this.packageName = packageName;
        this.objects = new ArrayList<>();
    }

    public void addObject(String object) {
        this.objects.add(object);
    }

    @Override
    public String toString() {
        return "From " + this.packageName + " import " + objects;
    }
}