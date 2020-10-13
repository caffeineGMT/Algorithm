/**
 * LeetCode 680
 * 
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {
    private class Pair {
        private int left;
        private int right;

        private Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;

        Pair p = findDiff(s, 0, s.length() - 1);
        if (p.left >= p.right)
            return true;

        return isPalindrome(s, p.left + 1, p.right) || isPalindrome(s, p.left, p.right - 1);
    }

    private Pair findDiff(String s, int l, int r) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }

        return new Pair(l, r);
    }

    private boolean isPalindrome(String s, int l, int r) {
        Pair p = findDiff(s, l, r);
        return p.left >= p.right;
    }
}
