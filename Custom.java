import java.util.Scanner;
class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}


public class Custom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            
            if (username.matches(".*[^a-zA-Z0-9_].*")) {
                throw new InvalidUsernameException("Invalid username. Special characters are not allowed.");
            }

            System.out.println("Username is valid: " + username);
        } catch (InvalidUsernameException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
