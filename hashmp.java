
import java.util.HashMap;
import java.util.Map;

public class hashmp {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("John", "Doe");
        map1.put("Alice", "Smith");

        Map<String, String> map2 = new HashMap<>();
        map2.put("Mary", "Johnson");
        map2.put("Bob", "Brown");

        Map<String, String> mergedMap = new HashMap<>(map1);
        mergedMap.putAll(map2);

        String searchKey = "Alice";
        String value = caseInsensitiveSearch(mergedMap, searchKey);

        if (value != null) {
            System.out.println("Value for key '" + searchKey + "' is: " + value);
        } else {
            System.out.println("Key '" + searchKey + "' not found.");
        }
    }

    public static String caseInsensitiveSearch(Map<String, String> map, String key) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(key)) {
                return entry.getValue();
            }
        }
        return null;
    }
}

