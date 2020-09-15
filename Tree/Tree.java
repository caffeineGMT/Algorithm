import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        };
    }

    private Node root;
    private int size;

    public Tree() {
        root = null;
        size = 0;
    }

    public void insert(int value) {
        var node = new Node(value);
        size++;
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else if (value > current.value) {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }

    }

    private boolean find(int target, Node start) {
        // solution 1: recursion
        if (start == null)
            return false;

        var current = start;
        if (target < current.value)
            return find(target, current.left);
        else if (target > current.value)
            return find(target, current.right);
        else
            return true;
    }

    public boolean find(int target) {
        // solution 1: recursion
        return find(target, root);

        // solution 2: iteration
        // var current = root;
        // while (current != null) {
        // if (target < current.value) {
        // current = current.left;
        // } else if (target > current.value) {
        // current = current.right;
        // } else
        // return true;
        // }
        // return false;

    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.value);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node == null)
            return;

        traverseInOrder(node.left);
        System.out.println(node.value);
        traverseInOrder(node.right);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node node) {
        if (node == null)
            return;

        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.println(node.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public int min() {
        // this method is for BST, O(h)/O(log n)
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.value;
    }

    public int min(Node node) {
        // this method is for non-BST, O(n)
        if (node == null)
            throw new IllegalStateException();
        if (node.left == null && node.right != null)
            return min(node.right);
        if (node.right == null && node.left != null)
            return min(node.left);
        if (isLeaf(node))
            return node.value;
        var childMin = Math.min(min(node.left), min(node.right));
        return Math.min(node.value, childMin);
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;
        return equals(this.root, other.root);
    };

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;
        if (first.value == second.value && equals(first.left, second.left) && equals(first.right, second.right))
            return true;
        return false;
    }

    public boolean isBinarySearchTree() {
        // solution 1
        return isBinarySearchTree(root);
        // solution 2
        // return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node node) {
        if (node == null)
            return true;
        if (isLeaf(node))
            return true;
        if (node.left == null || node.right != null)
            if (node.right.value > node.value)
                return isBinarySearchTree(node.right);
        if (node.left != null && node.right == null)
            if (node.left.value < node.value)
                return isBinarySearchTree(node.right);
        if (node.left != null && node.right != null)
            if (node.left.value < node.value && node.right.value > node.value)
                return isBinarySearchTree(node.left) && isBinarySearchTree(node.right);
        return false;
    }

    private boolean isBinarySearchTree(Node node, int min, int max) {
        // solution 2: pre-order traversal
        if (node == null)
            return true;
        if (node.value < min || node.value > max)
            return false;
        return isBinarySearchTree(node.left, min, node.value - 1)
                && isBinarySearchTree(node.right, node.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node node, int distance, ArrayList<Integer> list) {
        if (node == null)
            return;
        if (distance == 0) {
            list.add(node.value);
            return;
        }

        distance--;
        getNodesAtDistance(node.left, distance, list);
        getNodesAtDistance(node.right, distance, list);

    }

    public void traversalLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            var list = getNodesAtDistance(i);
            for (var item : list)
                System.out.println(item);
        }
    }

    public int size() {
        return size;
    }

    public int countSize() {
        return countSize(root);
    }

    private int countSize(Node start) {
        if (start == null)
            return 0;

        var count = 1;
        count += countSize(start.left);
        count += countSize(start.right);

        return count;

        // solution2: checking leaf node
        // if (root == null)
        // return 0;

        // if (isLeaf(root))
        // return 1;

        // return 1 + size(root.left) + size(root.rightChild);

    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node start) {
        if (start == null)
            return 0;
        if (isLeaf(start))
            return 1;
        return countLeaves(start.left) + countLeaves(start.right);
    }

    public int max() {
        // using recursion
        return max(root);
    }

    private int max(Node start) {
        if (start == null)
            throw new IllegalStateException();
        if (start.right == null)
            return start.value;

        return max(start.right);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return contains(root.left, value) || contains(root.right, value);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node start, int first, int second) {
        if (start == null)
            return false;
        if (start.left == null || start.right == null)
            return false;
        if ((start.left.value == first && start.right.value == second)
                || (start.left.value == second && start.right.value == first))
            return true;

        return areSibling(start.left, first, second) || areSibling(start.right, first, second);

        // solution 2
        // if (start == null)
        // return false;

        // var areSibling = false; // flag, only condition below can change the flag.
        // Otherwise delegate the task to its children
        // if (root.left != null && root.right != null) {
        // areSibling = (root.left.value == first && root.right.value == second)
        // || (root.right.value == first && root.left.value == second);
        // }

        // return areSibling || areSibling(root.left, first, second) ||
        // areSibling(root.right, first, second);
    }

    // public List<Integer> getAncestors() {

    // }
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;

        var balanceFactor = height(root.left) - height(root.right);

        return Math.abs(balanceFactor) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }

    public List<Integer> getAncestors(int target) {
        var list = new ArrayList<Integer>();
        startIsAncestorOfTarget(root, target, list);
        return list;
    }

    private boolean startIsAncestorOfTarget(Node start, int target, List<Integer> list) {
        if (start == null)
            return false;
        if (start.value == target)
            return true;
        if (startIsAncestorOfTarget(start.left, target, list) || startIsAncestorOfTarget(start.right, target, list)) {
            list.add(start.value);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var test = new Tree();
        test.insert(10);
        test.insert(20);
        test.insert(8);
        test.insert(12);
        test.insert(9);
        test.insert(7);
        // test.traversalLevelOrder();

        // test.find(20);
        System.out.println(test.getAncestors(7));
    }

}