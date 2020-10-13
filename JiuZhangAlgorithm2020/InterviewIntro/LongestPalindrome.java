
/**
 * LintCode 627
 * 
 * https://www.lintcode.com/problem/longest-palindrome/description?_from=ladder&&fromId=161
 */

import java.util.HashMap;
import java.util.Map.Entry;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        if (s == null)
            return 0;

        int oddAccu = 0;
        int evenAccu = 0;
        boolean flag = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        for (Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
            if (entry.getValue() % 2 == 0)
                evenAccu += entry.getValue();
            else {
                flag = true;
                oddAccu += (entry.getValue() - 1);
            }
        }

        if (flag)
            oddAccu += 1;
        return oddAccu + evenAccu;
    }

    public static void main(String[] args) {
        var test = "abccccdd";
        longestPalindrome(test);

    }
}
