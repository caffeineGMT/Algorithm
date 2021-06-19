# Microsoft OA

see pdf

{% file src=".gitbook/assets/microsoft\_oa.pdf" caption="OA summary" %}

Count Good Nodes in Binary Tree

```java
int count = 0;

public int goodNodes(TreeNode root) {
    if (root == null) {
        return 0;
    }

    dfs(root, Integer.MIN_VALUE);

    return count;
}

private void dfs(TreeNode root, int max) {
    if (root == null) {
        return;
    }

    if (root.val >= max) {
        count++;
        max = root.val;
    }

    dfs(root.left, max);
    dfs(root.right, max);
}
```

