/**
 * LintCode 13
 * 
 * https://www.lintcode.com/problem/implement-strstr/description?_from=ladder&&fromId=161
 */

public class strStr {
    public static int strStr(String source, String target) {
        if (source == null || target.equals(""))
            return 0;

        // `source.length() - target.length()` + 1 or not? Answer: we could use specific
        // case to test it, in this case, we could ask what if source and target has
        // equal length
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            boolean notEqual = false;

            for (int j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    notEqual = true;
                    break;
                }
            }

            if (!notEqual)
                return i;
        }
        return -1;
    }
}
