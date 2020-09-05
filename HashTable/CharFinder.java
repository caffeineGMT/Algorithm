import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstNonRepeatChar(String string) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = string.toCharArray();
        for (var ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (char ch : chars)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatChar(String string) {
        // solution 1: using hashtable(this will return the first repeated char after
        // reading the whole str,the result is different from solution 2)
        // Map<Character, Integer> map = new HashMap<>();
        // var chars = string.toCharArray();
        // for (char ch : chars) {
        // var count = map.containsKey(ch) ? map.get(ch) : 0;
        // map.put(ch, count + 1);
        // }
        // for (char ch : chars)
        // if (map.get(ch) != 1)
        // return ch;
        // return Character.MIN_VALUE;
        // solution 2: using hashset (this will return the first repeated char when
        // reading the str one char by one char, the result is different from solution
        // 1)
        Set<Character> set = new HashSet<>();
        for (char ch : string.toCharArray()) {
            if (set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public Map<Character, Integer> numberOfOccurrence(String string) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : string.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else
                map.put(ch, map.get(ch) + 1);

        }
        return map;
    }

    public static void main(String[] args) {
        var test = new CharFinder();
        System.out.println(test.findFirstNonRepeatChar("a green apple"));
        System.out.println(test.numberOfOccurrence("a green apple"));
        System.out.println(test.findFirstRepeatChar("a green apple"));
    }
}