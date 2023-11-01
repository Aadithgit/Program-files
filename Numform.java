
public class Numform {
    public static void main(String[] args) {
        String numericString = "abc"; 

        try {
            int intValue = Integer.parseInt(numericString);
            System.out.println("Parsed integer value: " + intValue);

            double doubleValue = Double.parseDouble(numericString);
            System.out.println("Parsed double value: " + doubleValue);
        } catch (NumberFormatException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

