# ByteDance VO

* [x] Product of the Last K Numbers \(last prefixProduct / prefixProduct, if 0, get a new list\)
* [x] Number of Atoms \(basic calculator, stack&lt;map&gt;\)
* [x] Minimum Remove to Make Valid Parentheses \(froward scan, stack, backward scan\) 
* [x] Minimize Malware Spread \(uf\)
* [x] Similar String Groups \(uf\)        
* [x] Random Pick with Weight \(prefix + binary search\)                
* [x] Walls and Gates \(bfs\)
* [x] Word Break II 
* [x] Pacific Atlantic Water Flow  
* [x] Custom Sort String \(bucket sort\) 
* [x] Decode String  \(maintain str, stack\)
* [x] Kth Largest Element in an Array \(minheap, quick select\)
* [x] design heap
* [x] design hashmap \(findPrev, always start from dummy\)
* [x] reverse pairs \(merge sort, count first, same as count number smaller than self\)
* [x] nearest city \([from Amazon OA](https://app.gitbook.com/@guomaitao/s/datastructure-and-algorithm/~/drafts/-Mc5LQbCX59MUfdz7t1S/amazon-oa#nearest-cities)\)
* [x] Convert Binary Search Tree to Sorted Doubly Linked List \(in-order dc\)
* [x] Bulls and Cows \(1-pass hashmap\)

minheap

{% embed url="https://aaronice.gitbook.io/lintcode/data\_structure/heapify" %}

[https://www.jiuzhang.com/problem/heapify/](https://www.jiuzhang.com/problem/heapify/)

```java
public class Solution {
    class Node {
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] nodes = new Node[20];
    private int size;

    public void insert(int key, int val) {
        if (isFull())
            throw new IllegalArgumentException();
        nodes[size++] = new Node(key, val);
        bubbleUp();
    }

    public int remove(){
        if (isEmpty()) 
            throw new IllegalArgumentException();
        int ret = nodes[0].val;
        nodes[0] = nodes[size - 1];
        size--;

        bubbleDown();

        return ret;
    }

    private void bubbleUp() {
        int i = size - 1;
        while (i > 0 && nodes[i].key < nodes[(i - 1) / 2].key) {
            swap(nodes, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void bubbleDown() {
        int i = 0;
        while (i < nodes.length) {
            int smallest = i;
            if (2 * i + 1 < nodes.length && nodes[2 * i + 1].key < nodes[smallest].key) {
                smallest = 2 * i + 1;
            }
            if (2 * i + 2 < nodes.length && nodes[2 * i + 2].key < nodes[smallest].key) {
                smallest = 2 * i + 2;
            }
            if (smallest == i) {
                break;
            }
            swap(nodes, smallest, i);
            i = smallest;
        }
    }

    private void swap(Node[] arr, int a, int b) {
        Node temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private boolean isFull() {
        return size == nodes.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void heapify(Node[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            siftDown(arr);
        }
    }

    private void siftDown(Node[] arr) {
        int i = 0;
        while (i < arr.length) {
            int smallest = i;
            if (2 * i + 1 < arr.length && nodes[2 * i + 1].val < arr[smallest].val) {
                smallest = 2 * i + 1;
            }
            if (2 * i + 2 < arr.length && nodes[2 * i + 2].val < arr[smallest].val) {
                smallest = 2 * i + 2;
            }
            if (smallest == i) {
                break;
            }
            swap(arr, smallest, i);
            i = smallest;
        }
    }
}
```





