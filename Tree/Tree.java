import java.util.ArrayList;

public class Tree {
    private Node root;

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

    public Tree() {
        root = null;
    }

    public void insert(int value) {
        var node = new Node(value);
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
        var current = start;
        if (target < current.value) {
            if (current.left == null)
                return false;
            return find(target, current.left);
        } else if (target > current.value) {
            if (current.right == null)
                return false;
            return find(target, current.right);
        } else {
            return true;
        }
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

    public static void main(String[] args) {
        var test = new Tree();
        test.insert(10);
        test.insert(20);
        test.insert(8);
        test.insert(12);
        test.insert(9);
        test.traversalLevelOrder();

        // test.find(20);
        // System.out.println(test.find(13));
    }

}