import java.util.HashMap;
import java.util.Map;

public class HashTableDemo {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Mary");
        map.put(2, "Bob");
        map.put(3, "John");
        map.put(null, null);
        var value = map.get(3);
        map.remove(3);
        map.containsKey(2);// O(1)
        map.containsValue("Mary");// O(n)
        System.out.println(value);
        System.out.println(map);
        for (var item : map.keySet()) {
            System.out.println(map.get(item));
        }
        for (var item : map.entrySet()) {
            System.out.println(item.getKey());
            System.out.println(item.getValue());
            System.out.println(item);
        }
    }

}