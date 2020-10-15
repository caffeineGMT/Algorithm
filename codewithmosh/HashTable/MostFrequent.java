import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
    public static int mostFrequentElement(int[] arr) {
        if (arr.length == 0)
            throw new IllegalStateException();

        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            var value = map.get(item);
            if (value == null)
                value = 0;
            // value = map.getOrDefault(item, 0); //another way of taking care of edge case
            map.put(item, ++value);
        }

        var maxOccurrenceKey = arr[0];
        var maxOccurrenceValue = map.get(maxOccurrenceKey);
        for (var entry : map.entrySet()) {
            if (entry.getValue() > maxOccurrenceValue) {
                maxOccurrenceKey = entry.getKey();
                maxOccurrenceValue = entry.getValue();
            }
        }

        return maxOccurrenceKey;
    }

    public static void main(String[] args) {
        var arr = new int[] { 1, 3, 3, 4, 4, 4, 5, 5, 5, 5 };
        System.out.println(mostFrequentElement(arr));
    }

}
