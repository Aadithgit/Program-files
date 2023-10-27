import java.util.HashSet;
import java.util.Set;

public class Same {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : array1) {
			set1.add(num);
        }

        for (int num : array2) {
            set2.add(num);
        }

        set1.retainAll(set2); 

        int sumOfSquares = 0;
        for (int num : set1) {
            sumOfSquares += num * num;
        }

        System.out.println("Common Elements: " + set1);
        System.out.println("Sum of Squares of Common Elements: " + sumOfSquares);
    }
}
