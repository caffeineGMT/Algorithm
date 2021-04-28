/**
 * LintCode 75
 * 
 * https://www.lintcode.com/problem/find-peak-element/description
 * 
 * 分析： 先想到打擂台，O（n）复杂度，考官肯定不允许。然后我们发现本题不能用ooxx模型，即没有一个条件可以明确分类左右两边。
 * 我们可以回归二分法本质，即左边满足条件去左边，右边满足条件去右边，即使不是同一个条件标准。注意本题要求的是any，找到即可以。如果题目问的是求所有，那么不可能在比
 * O（n）的时间内算出，因为我们可以构造出12121212这样的模型，也就是局部峰有n/2个
 */
public class FindPeakElement {
    public int findPeak(int[] A) {
        if (A == null || A.length == 0)
            throw new IllegalArgumentException();

        int l = 1;
        int r = A.length - 2;

        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (A[m] < A[m + 1])
                l = m;
            else if (A[m] < A[m - 1])
                r = m;
            else
                return m;
        }

        if (A[l] > A[r])
            return l;
        else
            return r;
    }
}
