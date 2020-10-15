//Given an array of integers, count the number of unique pairs of integers that have difference k.
//Input: [1, 7, 5, 9, 2, 12, 3] K=2 
//Output: 4 We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9).
//Note that we only want the number of these pairs, not the pairs themselves.

import java.util.HashSet;
import java.util.Set;

public class CountPairsWithDiff {
    public static int countPairsWithDiff(int[] numbers, int difference) {
        Set<Integer> set = new HashSet<>();
        var count = 0;

        for (var num : numbers)
            set.add(num);

        for (var num : numbers) {
            var target = num + difference;
            if (set.contains(target))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        var numbers = new int[] { 1, 7, 5, 9, 2, 12, 3 };
        var result = countPairsWithDiff(numbers, 15);
        System.out.println(result);
    }
}
