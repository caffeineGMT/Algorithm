import java.util.Arrays;

/**
 * LeetCode 167
 * 
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        var result = new int[2];
        if (numbers == null)
            return result;

        var l = 0;
        var r = numbers.length - 1;
        while (l < r) {
            var sum = numbers[l] + numbers[r];
            if (sum < target)
                l++;
            if (sum > target)
                r--;
            if (sum == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var t = new int[] { 1, 3, 5, 9 };
        var r = twoSum(t, 8);
        System.out.println(Arrays.toString(r));
    }

}
