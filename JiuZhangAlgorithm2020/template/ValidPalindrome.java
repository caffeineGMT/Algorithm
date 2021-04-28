/**
 * LintCode 415
 * 
 * https://www.lintcode.com/problem/valid-palindrome/description
 */

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null)
            return false;

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
                r--;

            if (l < r && isEqual(s.charAt(l), s.charAt(r)))
                return false;
            l++;
            r--;
        }

        return true;
    }

    private boolean isValid(char a) {
        return Character.isLetter(a) || Character.isDigit(a);
    }

    private static boolean isEqual(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    public static void main(String[] args) {
        var test = "r a, cacar";
        System.out.println(isPalindrome(test));
    }
}