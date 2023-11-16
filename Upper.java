import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Upper {
    public static void main(String[] args) {
        
        List<String> stringList = Arrays.asList("Apple", "Banana", "Orange", "Avocado", "Grapes");

        
        List<String> filteredAndUppercaseList = stringList.stream()
                .filter(s -> s.charAt(0)=='A')
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        
        System.out.println("Filtered list " + filteredAndUppercaseList);
    }
}
