/**
 * LintCode 183
 * 
 * https://www.lintcode.com/problem/wood-cut/description?_from=ladder&&fromId=161
 * 
 * 分析：本质上还是二分
 */
public class WoodCut {
    public int woodCut(int[] L, int k) {
        int l = 1;
        int max = 0;
        for (int item : L) {
            max = Math.max(max, item);
        }
        int r = max;

        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (count(m, L) >= k)
                l = m;
            else
                r = m;
        }

        if (count(r, L) >= k)
            return r;
        else if (count(l, L) >= k)
            return l;
        else
            return 0;
    }

    private int count(int length, int[] L) {
        int sum = 0;

        for (int item : L) {
            sum += item / length;
        }

        return sum;
    }
}
