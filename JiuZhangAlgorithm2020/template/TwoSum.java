import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * LeetCode 1
 * 
 * https://leetcode.com/problems/two-sum/
 */

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int[] r = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                r[1] = i;
                r[0] = map.get(target - numbers[i]);
                return r;
            }
            map.put(numbers[i], i);
        }
        return r;
    }

    // solution 2:
    // public int[] twoSum(int[] nums, int target) {
    // Map<Integer, Integer> map = new HashMap<>();
    // for (int i = 0; i < nums.length; i++) {
    // map.put(nums[i], i);
    // }
    // for (int i = 0; i < nums.length; i++) {
    // int complement = target - nums[i];
    // if (map.containsKey(complement) && map.get(complement) != i) {
    // return new int[] { i, map.get(complement) };
    // }
    // }
    // throw new IllegalArgumentException("No two sum solution");
    // }

    // solution 3: sort first and then turn into TwoSumII question using 2 pointers

    public static void main(String[] args) {
        var test = new int[] { 2, 7, 11, 15 };
        var r = twoSum(test, 9);
        System.out.println(Arrays.toString(r));
    }
}
