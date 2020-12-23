import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> counter = new HashMap<>();
        int len = s.length();
        int sum = 0;
        boolean usedSingle = false;

        for (int i = 0; i < len; i++) {
            if (!counter.containsKey(s.charAt(i))) {
                counter.put(s.charAt(i), 1);
                continue;
            }
            int count = counter.get(s.charAt(i));
            counter.put(s.charAt(i), count + 1);
        }

        for (char key : counter.keySet()) {
            if (counter.get(key) % 2 == 0) {
                sum += counter.get(key);
                continue;
            }
            if (counter.get(key) == 1 && !usedSingle) {
                sum++;
                usedSingle = true;
                continue;
            }
            if (counter.get(key) % 2 == 1 && counter.get(key) > 1) {
                sum += counter.get(key) - 1;
                if (!usedSingle) {
                    sum++;
                }
                continue;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        var test = new Solution();
        var r = test.longestPalindrome("bananas");
        System.out.println(r);
    }
}