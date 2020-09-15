// implement with hashtable. save a lot of memory space

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieII {

    private class Node {
        private char value;
        private HashMap<Character, Node> children;
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root;

    public TrieII() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        var cur = root;
        for (var ch : word.toCharArray()) {
            if (!cur.hasChild(ch))
                return false;
            cur = cur.getChild(ch);
        }

        return cur.isEndOfWord;
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        System.out.println(node.value);
        for (var child : node.getChildren())
            preOrderTraversal(child);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        for (var child : node.getChildren())
            postOrderTraversal(child);
        System.out.println(node.value);
    }

    public void remove(String word) {
        if (word == null || word == "")
            return;

        remove(word, 0, root.getChild(word.charAt(0)));
    }

    private void remove(String word, int curIndex, Node curNode) {
        if (curIndex == word.length() - 1) {
            curNode.isEndOfWord = false;
            return;
        }

        int nextIndex = curIndex + 1;
        var nextChar = word.charAt(nextIndex);
        Node nextChild = curNode.getChild(nextChar);

        if (nextChild == null)
            return;

        remove(word, nextIndex, nextChild);

        if (!nextChild.hasChildren() && !nextChild.isEndOfWord)
            curNode.removeChild(nextChar);
    }

    public static void main(String[] args) {
        var tries = new TrieII();
        tries.insert("can");
        tries.insert("cany");
        tries.remove("cany");
        System.out.println(tries.root.getChild('c').getChild('a').getChild('n').isEndOfWord);
        // tries.preOrderTraversal();
    }

}
