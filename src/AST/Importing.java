package AST;

import java.util.ArrayList;

class Importing {
    String packageName;
    ArrayList<String> objects;

    public Importing(ArrayList<String> objects, String packageName) {
        this.objects = objects;
        this.packageName = packageName;
    }

    public void addObject(String object) {
        this.objects.add(object);
    }

    @Override
    public String toString() {
        return "From " + this.packageName + " import " + objects;
    }
}