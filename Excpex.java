
public class Excpex {

    public static void main(String[] args) {
        try {
            throwMethod();
        } catch (Exception e) {
            System.out.println("Caught an exception using throw: " + e.getMessage());
        }

        try {
            throwsMethod();
        } catch (Exception e) {
            System.out.println("Caught an exception using throws: " + e.getMessage());
        }
    }

    
    public static void throwMethod() {
        System.out.println("Inside throwMethod");
        throw new RuntimeException("Exception thrown using throw");
    }

    
    public static void throwsMethod() throws Exception {
        System.out.println("Inside throwsMethod");
        throw new RuntimeException("Exception thrown inside throwsMethod");
    }
}

