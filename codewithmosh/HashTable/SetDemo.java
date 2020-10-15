import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] numbers = { 1, 2, 4, 3, 2, 3, 5 };
        for (var item : numbers)
            set.add(item);
        System.out.println(set);
    }

}