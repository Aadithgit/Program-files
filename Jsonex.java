import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Jsonex {
    public static void main(String[] args) {
        String filePath = "Myfile.json"; // Replace with your JSON file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            String jsonString = jsonContent.toString();

            if (isValidJson(jsonString)) {
                System.out.println("Parsed JSON:");
                System.out.println(jsonString);
            } else {
                System.err.println("Error parsing JSON: Invalid JSON format");
            }

        } catch (IOException e) {
            System.err.println("Error reading the JSON file: " + e.getMessage());
        }
    }

    // Check if the provided JSON string is valid
    public static boolean isValidJson(String jsonString) {
        Stack<Character> stack = new Stack<>();

        for (char c : jsonString.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '}' || c == ']') {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
