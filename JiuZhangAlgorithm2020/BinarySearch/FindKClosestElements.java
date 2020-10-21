/**
 * LintCode 460
 * 
 * https://www.lintcode.com/problem/find-k-closest-elements/description?_from=ladder&&fromId=161
 * 
 * analysis: 1.首先使用二分法把数组分成两个部分，一个部分满足 >= target， 另一部分小于
 * target。算法采用二分法九章模版，这部分算法非常类似first position of target这个题的变形。
 * 
 * 2.这时候我们其实已经找到了target应该在该数组的哪个位置以及相邻的两个树。
 * 普通情况是相邻两数一左一右，我们只要把这维护两个背向指针，分别指向这两数，然后按序列插入即可， 算法过程非常类似merge sort的merge过程。
 */
public class FindKClosestElements {

    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0)
            return new int[0];

        int r = findUpperClosest(A, target);
        int l = r - 1;

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(l, r, target, A)) {
                ans[i] = A[l];
                l--;
            } else {
                ans[i] = A[r];
                r++;
            }
        }

        return ans;
    }

    private int findUpperClosest(int[] A, int target) {
        // find the first number >= target in A
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target)
                end = mid;
            else
                start = mid;

        }
        if (A[start] >= target)
            return start;
        if (A[end] >= target)
            return end;

        // cannot find
        return A.length;
    }

    private boolean isLeftCloser(int l, int r, int target, int[] A) {
        if (l < 0)
            return false;
        if (r >= A.length)
            return true;

        return target - A[l] <= A[r] - target;
    }

    public static void main(String[] args) {
        var test = new FindKClosestElements();
        var A = new int[] { 1, 4, 6, 10, 20 };
        var target = 21;
        var k = 4;
        var ans = test.findUpperClosest(A, target);
        System.out.println(ans);
    }
}
