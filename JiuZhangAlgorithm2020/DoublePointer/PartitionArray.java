/**
 * LintCode 31
 * 
 * https://www.lintcode.com/problem/partition-array/description?_from=ladder&&fromId=161
 * 
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            while (l <= r && nums[l] < k)
                l++;
            while (l <= r && nums[r] >= k)
                r--;
            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }

        return l;
    }

}
