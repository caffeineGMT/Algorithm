/**
 * LeetCode 5
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/solution/
 * 
 * difference between sub-sequence and sub-string: sub-sequence is not
 * continuous.it has O(2^n) combo sub-string is continuous. it has O(n^2)
 */

public class LongestPalindromeSubstring {

    // solution 1: O(n^3)

    // public String longestPalindrome(String s) {
    // if (s == null)
    // return "";

    // for (int i = 0; i < s.length(); i++) {
    // int j = s.length() - 1;
    // while (j >= 0 && s.charAt(j) != s.charAt(i))
    // j--;
    // String substring = s.substring(i, j + 1);

    // if (isPalindrome(substring))
    // return substring;
    // }

    // return "";
    // }

    // private boolean isPalindrome(String str) {
    // int l = 0;
    // int r = str.length() - 1;

    // while (l < r) {
    // if (str.charAt(l) != str.charAt(r))
    // return false;

    // l++;
    // r--;
    // }

    // return true;
    // }

    // solution 2: O(n^2)
    public String longestPalindrome(String s) {
        if (s == null)
            return "";

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = getPalindromeFrom(s, i, i);
            if (longest.length() < oddPalindrome.length())
                longest = oddPalindrome;

            String evenPalindrome = getPalindromeFrom(s, i, i + 1);
            if (longest.length() < evenPalindrome.length())
                longest = evenPalindrome;
        }

        return longest;
    }

    private String getPalindromeFrom(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(l))
                break;
            l--;
            r++;
        }

        return s.substring(l + 1, r); // right index is exclusive
    }

    // solution 3: dp
    // public String longestPalindrome(String s) {
    // if (s == null || s.equals(""))
    // return "";

    // int n = s.length();
    // boolean[][] isPalindrome = new boolean[n][n];

    // int longest = 1;
    // int start = 0;
    // for (int i = 0; i < n; i++) {
    // isPalindrome[i][i] = true;
    // }
    // for (int i = 0; i < n - 1; i++) {
    // isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
    // if (isPalindrome[i][i + 1]) {
    // start = i;
    // longest = 2;
    // }
    // }

    // for (int i = n - 1; i >= 0; i--) {
    // for (int j = i + 2; j < n; j++) {
    // isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) ==
    // s.charAt(j);
    // if (isPalindrome[i][j] && j - i + 1 > longest) {
    // start = i;
    // longest = j - i + 1;
    // }
    // }
    // }

    // return s.substring(start, start + longest);
    // }
}