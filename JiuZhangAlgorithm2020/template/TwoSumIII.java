import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * LeetCode 170
 * 
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 */

public class TwoSumIII {
    private Map<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        if (!map.containsKey(number))
            map.put(number, 1);
        else
            map.put(number, map.get(number) + 1);
    }

    public boolean find(int value) {
        for (var entry : map.entrySet()) {
            var delta = value - entry.getKey();
            if (delta == entry.getKey() && entry.getValue() > 1)
                return true;
            if (delta != entry.getKey() && map.containsKey(delta))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        var t = new TwoSumIII();
        t.add(0);
        t.add(0);
        System.out.println(t.find(0));

    }
}
