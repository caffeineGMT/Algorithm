# ByteDance VO

* [x] Product of the Last K Numbers \(last prefixProduct / prefixProduct, if 0, get a new list\)
* [x] Number of Atoms \(basic calculator, stack&lt;map&gt;\)
* [x] Minimum Remove to Make Valid Parentheses \(froward scan, stack, backward scan\) 
* [x] Minimize Malware Spread \(uf\)
* [x] Similar String Groups \(uf\)
* [ ] Find Two Non-overlapping Sub-arrays Each With Target Sum         
* [x] Random Pick with Weight \(prefix + binary search\)                
* [ ] Restore The Array
* [x] Walls and Gates \(bfs\)
* [ ] Palindrome Pairs
* [x] Word Break II 
* [x] Pacific Atlantic Water Flow
* [ ] String Transforms Into Another String  
* [x] Custom Sort String \(bucket sort\) 
* [x] Decode String  \(maintain str, stack\)
* [x] Kth Largest Element in an Array \(minheap, quick select\)
* [ ] heap
* [ ] hashmap



1.

{% embed url="https://www.1point3acres.com/bbs/thread-762483-1-1.html" %}



2. 

{% embed url="https://www.1point3acres.com/bbs/interview/%E5%AD%97%E8%8A%82%E8%B7%B3%E5%8A%A8-software-engineer-629094.html" %}

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
        while (i < nodes.length) {
            int smallest = i;
            if (2 * i + 1 < nodes.length && nodes[2 * i + 1].val < nodes[smallest].val) {
                smallest = 2 * i + 1;
            }
            if (2 * i + 2 < nodes.length && nodes[2 * i + 2].val < nodes[smallest].val) {
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





