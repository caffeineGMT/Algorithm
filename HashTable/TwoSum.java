// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// Input: [2, 7, 11, 15] - target = 9
// Output: [0, 1] (because 2 + 7 = 9)
// Assume that each input has exactly one solution, and you may not use the same element twice.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        // solution 1:

        if (numbers.length == 0)
            throw new IllegalStateException();

        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            map.put(numbers[index], index);
        }

        for (int num : numbers) {
            var delta = target - num;
            if (map.containsKey(delta))
                return new int[] { map.get(num), map.get(delta) };
        }

        return null;

        // better solution: only iterate array once along the way

        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < numbers.length; i++) {
        // int complement = target - numbers[i];
        // if (map.containsKey(complement)) {
        // return new int[] { map.get(complement), i };
        // }
        // map.put(numbers[i], i);
        // }

        // return null;
    }

    public static void main(String[] args) {
        var numbers = new int[] { 2, 7, 11, 15 };
        var result = twoSum(numbers, 26);
        System.out.println(Arrays.toString(result));
    }
}
