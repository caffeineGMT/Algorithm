/**
 * LeetCode 57
 * 
 * https://www.lintcode.com/problem/3sum/description
 */

public class TreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);

        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < numbers.length - 1; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1])
                continue;

            findTwoSum(numbers, i, result);
        }

        return result;
    }

    private void findTwoSum(int[] nums, int index, List<List<Integer>> result) {
        int l = index + 1;
        int r = nums.length - 1;
        int target = -nums[index];

        while (l < r) {
            int twoSum = nums[l] + nums[r];
            if (twoSum < target)
                l++;
            else if (twoSum > target)
                r--;
            else {
                List<Integer> triple = new ArrayList();
                triple.add(nums[index]);
                triple.add(nums[l]);
                triple.add(nums[r]);
                result.add(triple);
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1])
                    l++;
            }
        }
    }
}
