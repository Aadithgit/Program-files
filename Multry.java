public class Multry {
    public static void main(String[] args) {
        try {
            
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[4]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());

            try {
                
                int result = divideByZero();
                System.out.println("Result: " + result);
            } catch (ArithmeticException ex) {
                System.out.println("ArithmeticException caught: " + ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("Generic Exception caught: " + ex.getMessage());
        }

        System.out.println("Program continues after exception handling.");
    }

    public static int divideByZero() {
        int numerator = 10;
        int denominator = 0;
        return numerator / denominator; 
    }
}
