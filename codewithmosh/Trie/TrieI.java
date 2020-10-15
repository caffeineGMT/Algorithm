// implement with array. waste a lot of memory space
public class TrieI {
    private class Node {
        char value;
        Node[] children;
        boolean isEndOfWord;

        private Node(char value) {
            this.value = value;
            this.children = new Node[26];
            this.isEndOfWord = false;
        }
    }

    private Node root;

    public TrieI() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        if (word == null)
            return;

        Node cur = root;

        for (var ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new Node(ch);
            cur = cur.children[index];
        }

        cur.isEndOfWord = true;
    }

    public static void main(String[] args) {
        var tries = new TrieI();
        tries.insert("te");
        System.out.println(tries.root.children['t' - 'a'].children['e' - 'a'].isEndOfWord);
    }
}
