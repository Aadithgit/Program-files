import java.util.Scanner;

public class Expt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

            
            int sum = num1 + num2;
            int difference = num1 - num2;
            int product = num1 * num2;

            
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed");
            }

            int division = num1 / num2;

           
            System.out.println("Sum: " + sum);
            System.out.println("Difference: " + difference);
            System.out.println("Product: " + product);
            System.out.println("Division: " + division);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } 
            
        
    }
}
