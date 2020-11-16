import java.util.*;

class Solution {
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        var test = new Solution();
        int r = test.kthLargestElement2(new int[] { 4, 3, 5, 1 }, 3);
        System.out.println(r);
    }
}