public class AVLTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        private Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }

    private Node root;

    public void insert(int target) {
        root = insert(target, root);
    }

    private Node insert(int target, Node root) {
        // we need to return the node, because "root" is just a label. if we re-assign
        // start, we basically just re-assigned a label to a new object
        if (root == null)
            return new Node(target);

        if (target < root.value)
            root.left = insert(target, root.left);
        if (target > root.value)
            root.right = insert(target, root.right);

        setHeight(root);

        root = balance(root);

        return root;
    }

    private Node balance(Node root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) < 0)
                root.left = rotateLeft(root.left);
            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0)
                root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }

    private Node rotateLeft(Node root) {
        var newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        root.height = Math.max(height(root.left), height(root.right));
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right));

        return newRoot;
    }

    private Node rotateRight(Node root) {
        var newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        var test = new AVLTree();
        test.insert(5);
        test.insert(3);
        test.insert(6);
        test.insert(1);
        // test.findNode(test.root);
        // System.out.println(test.root.height);

    }
}
