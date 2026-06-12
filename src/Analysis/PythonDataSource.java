package Analysis;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PythonDataSource {
    private final String name;
    private final int line;
    private final String shape;
    private int itemCount;
    private final Map<String, Set<String>> fields = new LinkedHashMap<>();

    public PythonDataSource(String name, int line, String shape) {
        this.name = name;
        this.line = line;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }

    public String getShape() {
        return shape;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void addField(String fieldName, String typeName) {
        if (fieldName == null || fieldName.isBlank()) return;
        fields.computeIfAbsent(fieldName, k -> new LinkedHashSet<>())
                .add(typeName == null || typeName.isBlank() ? "unknown" : typeName);
    }

    public Set<String> getFieldNames() {
        return Collections.unmodifiableSet(fields.keySet());
    }

    public Map<String, Set<String>> getFields() {
        Map<String, Set<String>> copy = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : fields.entrySet()) {
            copy.put(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
        }
        return Collections.unmodifiableMap(copy);
    }
}
