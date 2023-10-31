public class Mulfin {

    public static void main(String[] args) {
        try {
            outerMethod();
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }

    public static void outerMethod() {
        System.out.println("Entering outerMethod");
        try {
            middleMethod();
        } finally {
            System.out.println("Exiting outerMethod's finally block");
        }
        System.out.println("Exiting outerMethod");
    }

    public static void middleMethod() {
        System.out.println("Entering middleMethod");
        innerMethod();
        System.out.println("Exiting middleMethod");
    }

    public static void innerMethod() {
        System.out.println("Entering innerMethod");
        int result = 10 / 0; 
        System.out.println("Exiting innerMethod");
    }
}
