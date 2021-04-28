/**
 * LintCode 382
 * 
 * https://www.lintcode.com/problem/triangle-count/description
 */

public class TriangleCount {
    public int triangleCount(int[] S) {
        Arrays.sort(S);

        int l = 0;
        int r = S.length - 1;
        int count = 0;

        for (int i = 0; i < S.length; i++) {
            l = 0;
            r = i - 1;

            while (l < r) {
                if (S[l] + S[r] > S[i]) {
                    count += r - l;
                    r--;
                } else
                    l++;
            }
        }

        return count;
    }
}
