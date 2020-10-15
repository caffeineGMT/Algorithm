import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        private Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public HashTable() {
        entries = new LinkedList[5];
    }

    public void put(int key, String value) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var bucket = entries[index];
        for (var entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        entries[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        if (entries[index] == null)
            return null;
        for (var entry : entries[index]) {
            if (entry.key == key)
                return entry.value;
        }
        return null;
    }

    public String remove(int key) {
        var index = hash(key);
        if (entries[index] == null)
            return null;
        for (var entry : entries[index]) {
            if (entry.key == key) {
                var temp = entry.value;
                entries[index].remove(entry);
                return temp;
            }
        }
        return null;
    }

    private int hash(int key) {
        return key % entries.length;
    }

    public static void main(String[] args) {
        var test = new HashTable();
        test.put(1, "a");
        test.put(2, "b");
        test.put(6, "extra");
        test.put(6, "extra+");
        System.out.println(test.remove(1));

    }
}
