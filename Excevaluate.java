
import java.util.Scanner;
import java.util.InputMismatchException; 


public class Excevaluate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer to calculate its factorial: ");

        try {
            int number = scanner.nextInt();

            if (number < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed.");
            }

            long factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is: " + factorial);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Input is not a valid integer.");
        }

        scanner.close();
    }

    private static long calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            if (factorial > Integer.MAX_VALUE) {
                throw new ArithmeticException("Factorial exceeds Integer.MAX_VALUE");
            }
        }
        return factorial;
    }
}

