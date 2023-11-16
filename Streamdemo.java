
import java.util.Arrays;
import java.util.List;

public class Streamdemo {
    public static void main(String[] args) {
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        
        int result = numbers.stream()
                .filter(n -> n % 2 == 0)        
                .map(n -> n * n)               
                .reduce(0,(c,e)->c+e);       

        System.out.println("Result: " + result);
    }
}
