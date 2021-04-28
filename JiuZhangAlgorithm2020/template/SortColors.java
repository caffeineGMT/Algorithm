/**
 * LeetCode 75
 * 
 * https://leetcode.com/problems/sort-colors/
 * 
 * tutorial: https://www.youtube.com/watch?v=J9DgvL6L1nk
 * 
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int l = 0;
        while (l <= nums.length - 1 && nums[l] == 0)
            l++;
        int r = nums.length - 1;
        while (r >= 0 && nums[r] == 2)
            r--;

        int cur = l;
        int temp;

        while (cur <= r) {
            if (nums[cur] == 0) {
                temp = nums[l];
                nums[l] = nums[cur];
                nums[cur] = temp;
                l++;
                cur++;
            }

            else if (nums[cur] == 2) {
                temp = nums[cur];
                nums[cur] = nums[r];
                nums[r] = temp;
                r--;
            } else
                cur++;
        }
    }
}
