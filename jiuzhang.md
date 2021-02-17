# JiuZhang

## Note

This is a repo recording notes based on JiuZhang Algorithm Series.

## Chapter 1: FB 面试官揭秘算法面试速成技巧 - 怎样做到 Bug Free 和刷 100 题等于别人刷 300 题

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_1._FB面试官揭秘面试速成技巧_-_怎样做到_Bug_Free_和刷100题刷300题.pdf)

## Chapter 2: 真实面试案例分析（上）与面试评分标准

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_2._真实面试案例分析上.pdf)
* 字符串查找——Robin Karp 算法
* greedy algorithm:
  * not worth the time to study it
  * Dijkstra
* frequently used string function:
  * String demo = "Hello,world!";
  * int length = demo.length\(\);
  * boolean equals = demo.equals\("Hello,world"\);
  * boolean contains = demo.contains\("word"\);
  * String replace = demo.replace\("Hello,", "Yeah@"\);
  * char little = demo.charAt\(5\);
  * String trim = demo.trim\(\);
  * String concat = demo.concat\("Great!"\);
  * char\[\] charArray = demo.toCharArray\(\);
  * String upperCase = demo.toUpperCase\(\);
  * String lowerCase = demo.toLowerCase\(\);
* string-related knowledge:
  * example:

    ```java
      public class StringTest {
      public static void main(String[] args) {
          String H = "hello";
          String H_1 = H;
          String H_2 = "hel";
          String H_3 = H_2 + "lo";
          String H_4 = H_2.concat("lo");

          System.out.println(H);            // hello
          System.out.println(H_1);          // hello
          System.out.println(H_2);          // hel
          System.out.println(H_3);          // hello
          System.out.println(H_4);          // hello

          //== test
          System.out.println(H == H_1);     // true
          System.out.println(H == H_3);     // false
          System.out.println(H == H_4);     // false
          System.out.println(H_3 == H_4);   // false

          //equals test
          System.out.println(H.equals(H_1));   // true
          System.out.println(H.equals(H_3));   // true
          System.out.println(H.equals(H_4));   // true
          System.out.println(H_3.equals(H_4)); // true

          //StringBuilder test
          StringBuilder helloBuilder = new StringBuilder("hel");
          System.out.println(helloBuilder.equals(H_2));    // false
        }
    }
    ```

  * `==` is testing if 2 items are the same instance of String class, not the value of these 2 items.
  * `equals` is testing if 2 items are the same instance first, if not, testing if they have the same content
  * `StringBuilder` is testing if 2 items are the same instance. In the case above, first "hel" is the instance of String class, second "hel" is the instance of StringBuilder class
  * if memory already has this string, it wont create new string. See case below.

    ```java
    public class Hello {
    public static void main(String argv[]) {
        String sa = "abc";
        String sb = "abc";
        if (sa == sb) {
        System.out.println("Yes");
        } else {
        System.out.println("No");
        }
      }
    }
    // result is yes
    ```

## Chapter 3: 真实面试案例分析（下）与 80%求职者会踩坑的基础知识

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_3._真实面试案例分析下与_80_求职者都会采坑的基础知识.pdf)
* [substring/subarray vs subsequence](https://www.geeksforgeeks.org/subarraysubstring-vs-subsequence-and-programs-to-generate-them/)
  * A `subbarray` is a contiguous part of array. An array that is inside another array. For example, consider the array \[1, 2, 3, 4\], There are 10 non-empty sub-arrays. The subbarays are \(1\), \(2\), \(3\), \(4\), \(1,2\), \(2,3\), \(3,4\), \(1,2,3\), \(2,3,4\) and \(1,2,3,4\). In general, for an array/string of size n, there are n\*\(n+1\)/2 non-empty subarrays/subsrings.
  * A `subsequence` is a sequence that can be derived from another sequence by zero or more elements, without changing the order of the remaining elements. For the same example, there are 15 sub-sequences. They are \(1\), \(2\), \(3\), \(4\), \(1,2\), \(1,3\),\(1,4\), \(2,3\), \(2,4\), \(3,4\), \(1,2,3\), \(1,2,4\), \(1,3,4\), \(2,3,4\), \(1,2,3,4\). More generally, we can say that for a sequence of size n, we can have \(2n-1\) non-empty sub-sequences in total.

## Chapter 4: 复杂度理论与双指针算法入门

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_4._复杂度理论与双指针算法入门.pdf)
* other:
  * [Harmonic Series complexity](https://stackoverflow.com/questions/25905118/finding-big-o-of-the-harmonic-series): 1+1/2+1/3+...+1/n O\(lgn\)
  * O\(n+m\) == O\(max\(n,m\)\)

## Chapter 5: 必须熟练掌握的两个排序算法

| feature | quick sort | merge sort |
| :--- | :--- | :--- |
| time | average: O\(nlgn\) worst: O\(n^2\) | O\(nlgn\) |
| space | O\(1\) | O\(n\) |
| stability | \*not stable | stable |

* [regarding quick-sort stability](https://stackoverflow.com/questions/13498213/quicksort-algorithm-stability)

## Chapter 6: 时间复杂度为 O\(logN\)的高频算法——二分法

* time complexity:

  | Big O | use case |
  | :--- | :--- |
  | O\(1\) | bit operation, constant calc |
  | O\(lgn\) | binary search, binary lifting，exponentiation by squaring，Euclidean algorithm |
  | O\(n\) | enumeration, double pointer，monotone stack，KMP, Rabin Karp, Manacher's Algorithm |
  | O\(nlgn\) | quick sort, heap sort, merge sort |
  | O\(n^2\) | enumeration, dynamic programming, Dijkstra |
  | O\(n^3\) | enumeration, dynamic programming, Floyd |
  | O\(2^n\) | combination |

* stack space vs heap space:
  * what will be stored in stack space when calling a function?: function itself, parameter passed in, return value, local var in function
  * Java Object: `int[] arr = new int[10];` arr is actually a variable which takes small memory to record a reference/address. If arr is in local func, it will be destroyed when function finishes. But `new int[10]` is saved in heap, it wont be destroyed right away.

## Chapter 7: 一个不会出现死循环的通用二分法模板

* see leetcode

## Chapter 8: 高频算法之王——双指针算法之相向双指针

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_8._高频算法之王双指针算法之相向双指针.pdf)

## Chapter 9: 简约而不简单——二分法学习的四重境界

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_9._简约而不简单二分法的四重境界.pdf)

## Chapter 10: 队列知识点从易到难

* Queue: using LinkedList and ArrayList

  ```java
  class Node {
    public int val;
    public Node next;
    public Node(int _val) {
        val = _val;
        next = null;
    }
  }
  public class MyQueue {
      public Node head, tail;

      public MyQueue() {
          head = tail = null;
          // do initialize if necessary
      }

      public void enqueue(int item) {
          if (head == null) {
              tail = new Node(item);
              head = tail;
          } else {
              tail.next = new Node(item);
              tail = tail.next;
          }
      }

      public int dequeue() {
          if (head != null) {
              int item = head.val;
              head = head.next;
              return item;
          }
          return -1;
      }
  }
  ```

```java
/**
 * 在循环队列中，除了用一组地址连续的存储单元依次存储从队首到队尾的元素外，还需要附设两个整型变量 head 和 tail 分别指示队首和队尾的位置。我们可以将循环队列视作一个类，通过成员变量数组来表示一组地址连续的存储单元，再定义两个成员变量 head 和 tail，将循环队列的基本操作定义成类的方法，循环效果则用“模”运算实现，以此来实现循环队列。每当 tail 到达末尾的时候，将 tail 对 MAXSIZE 取模，使其回到队首。但是如果这样我们会发现一个问题，队列为空和队列已满的条件都成了 tail == head。为了避免这种无法判断的情况，我们规定当循环队列只剩一个空位的时候，就认为队列已满。这样队列已满的条件就成了 (tail + 1) % MAXSIZE == head。
 */
public class MyQueue {
  public int head, tail;
  public int SIZE = 4;
  public int[] queue = new int[SIZE];

  public MyQueue() {
      head = tail = 0;
      // do initialize if necessary
  }
  //压入一个元素
  public void enqueue(int item) {
      // 队列已满
      if ((tail + 1) % SIZE == head){
          return ;
      }

      queue[tail++] = item;
      tail %= SIZE;
  }
  //弹出一个元素
public int dequeue() {
      // 队列为空
      if (head == tail){
          return -1;
      }

      int item = queue[head++];
      head %= SIZE;
      return item;

  }
}
```

* Set:
  * no duplicate value
  * can have null value
  * no order

```java
Set<String> set = new HashSet<>();
for (int i = 1; i < 6; i ++) {
    set.add(i + "");
}
set.add("1"); //不会重复写入数据
set.add(null);//可以写入空数据
Iterator<String> iter = set.iterator();
while (iter.hasNext()) {
    system.out.print(iter.next() + " ");//数据无序
}// 输出(无序)为 3 4 1 5 null 2
```

* map:
  * key is not duplicated, value can be
  * allow key and value to be null
  * no order

```java
public class Solution {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        for (int i = 5; i > 0; i --) {
            map.put(i + "", i + "");
        }
        map.put("1","1");//key无重复
        map.put("11","1");//value可以重复
        map.put(null, null);//可以为空
        for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
            String key = (String)i.next();
            String value = map.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }
    }
}
//输出
/*
key = 11, value = 1
key = null, value = null
key = 1, value = 1
key = 2, value = 2
key = 3, value = 3
key = 4, value = 4
key = 5, value = 5
*/
//输出顺序与输入顺序无关
```

* interface:
  * interface cannot have variable, we can only declare constant in interface.
  * one class can implement multiple interfaces
* abstract class:
  * very similar to interface, provide declaration but not implementation
  * one class can only extends one \(abstract\) class

## Chapter 11: 宽度优先搜索与图论入门

* 3 bfs method: single queue, double queue, dummy node
* way to describe a graph
  * adjacency matrix:

    \[

    \[1,0,0,1\],

    \[0,1,1,0\],

    \[0,1,1,0\],

    \[1,0,0,1\]

    \]

    例如上图表示 0 号点和 3 号点有连边。1 号点和 2 号点有连边。

    当然，每个点和自己也是默认有连边的。

    图中的 0 表示不连通，1 表示连通。

    我们也可以用一个更具体的整数值来表示连边的长度。

    邻接矩阵我们可以直接用一个二维数组表示，如

    int\[\]\[\] matrix;

    这种数据结构因为耗费 O\(n^2\) 的空间，所以在稀疏图上浪费很大，因此并不常用。

  * adjacency list:

    \[

    \[1\],

    \[0,2,3\],

    \[1\],

    \[1\]

    \]

    这个图表示 0 和 1 之间有连边，1 和 2 之间有连边，1 和 3 之间有连边。即每个点上存储自己有哪些邻居（有哪些连通的点）。

    这种方式下，空间耗费和边数成正比，可以记做 O\(m\)，m 代表边数。m 最坏情况下虽然也是 O\(n^2\)，但是邻接表的存储方式大部分情况下会比邻接矩阵更省空间。

    可以用自定义的类来实现邻接表

    Java:

    class DirectedGraphNode {

    int label;

    List neighbors;

    ...

    }

    也可以使用 HashMap 和 HashSet 搭配的方式来存储邻接表

    Map = new HashMap\(\);

## Chapter 12: 用递归实现遍历法和分治法

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_12._用递归实现遍历法和分治法.pdf)

## Chapter 13: 使用非递归实现二叉树的遍历

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_13._使用非递归实现二叉树的遍历.pdf)

## Chapter 14: 性价比之王——宽度优先搜索

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_14._性价比之王宽度优先搜索.pdf)

## Chapter 15: 解决 99%二叉树问题的算法——分治法

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_15._解决99二叉树问题的算法分治法1.pdf)

## Chapter 16: 组合类 DFS

* 在非二叉树上的深度优先搜索（Depth-first Search）中，90%的问题，不是求组合（Combination）就是求排列（Permutation）。特别是组合类的深度优先搜索的问题特别的多。而排列组合类的搜索问题，本质上是一个“隐式图”的搜索问题。一个问题如果没有明确的告诉你什么是点，什么是边，但是又需要你进行搜索的话，那就是一个隐式图搜索问题了。所以对于这类问题，我们首先要分析清楚什么是点什么是边。
* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter16.pptx)

## Chapter 17: 排列类 DFS

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_15._解决99二叉树问题的算法分治法1.pdf)

## Chapter 18: 哈希表的原理

* HashMap 和 HashSet 的区别: 首先得看 java 最基本的两种数据结构：数组和链表的区别： 数组易于快速读取（通过 for 循环），不便存储（数组长度有限制）；链表易于存储，不易于快速读取。 哈希表的出现是为了解决链表访问不快速的弱点，哈希表也称散列表。 HashSet 是通过 HashMap 来实现的，HashMap 的输入参数有 Key、Value 两个组成，在实现 HashSet 的时候，保持 HashMap 的 Value 为常量，相当于在 HashMap 中只对 Key 对象进行处理。 HashMap 的底层是一个数组结构，数组中的每一项对应了一个链表，这种结构称“链表散列”的数据结构，即数组和链表的结合体；也叫散列表、哈希表。 想要了解 HashMap 和 HashSet 这样两个不同存储结构的区别，就得熟知他们的存储过程
* HashMap 存储对象的过程 1、对 HashMap 的 Key 调用 hashCode\(\)方法，返回 int 值，即对应的 hashCode； 2、把此 hashCode 作为哈希表的索引，查找哈希表的相应位置，若当前位置内容为 NULL，则把 HashMap 的 Key、Value 包装成 Entry 数组，放入当前位置； 3、若当前位置内容不为空，则继续查找当前索引处存放的链表，利用 equals 方法，找到 Key 相同的 Entry 数组，则用当前 Value 去替换旧的 Value； 4、若未找到与当前 Key 值相同的对象，则把当前位置的链表后移（Entry 数组持有一个指向下一个元素的引用），把新的 Entry 数组放到链表表头；
* HashSet 存储对象的过程 往 HashSet 添加元素的时候，HashSet 会先调用元素的 hashCode 方法得到元素的哈希值 ，然后通过元素 的哈希值经过移位等运算，就可以算出该元素在哈希表中 的存储位置。 情况 1： 如果算出元素存储的位置目前没有任何元素存储，那么该元素可以直接存储到该位置上。 情况 2： 如果算出该元素的存储位置目前已经存在有其他的元素了，那么会调用该元素的 equals 方法与该位置的元素再比较一次，如果 equals 返回的是 true，那么该元素与这个位置上的元素就视为重复元素，不允许添加，如果 equals 方法返回的是 false，那么该元素运行添加。
* 哈希表（Java 中的 HashSet / HashMap，C++ 中的 unordered\_map，Python 中的 dict）是面试中非常常见的数据结构。它的主要考点有两个： 1.是否会灵活的使用哈希表解决问题 2.是否熟练掌握哈希表的基本原理
* HashSet 实现了 Set 接口，其内部不允许出现重复的值，如果我们将一个对象存入 HashSet，必须重写 equals\(\)和 hashCode\(\)方法，这样才能确保集合中不存在同一个元素。HashSet 的内部是无序的，因此不能使用 hashset.get\(index\) 来获取元素。HashMap 实现了 Map 接口，其内容是键值对的映射（key-&gt;value），不允许出现相同的键（key）。在查询的时候会根据给出的键来查询对应的值。我们可以认为，HashSet 和 HashMap 增查操作的时间复杂度都是常数级的。
* 工程中 open hashing 比 close hashing 用的多
* rehashing

## Chapter 19: 堆的基本原理

* 堆是一棵满足如下性质的二叉树：

  1、父节点的键值总是不大于它的孩子节点的键值（小顶堆）。

  2、父节点的键值总是不小于它的孩子节点的键值（大顶堆）。

  由于堆是一棵形态规则的二叉树，因此堆的父节点和孩子节点存在如下关系（根节点编号为 0）：

  设父节点的编号为 i, 则其左孩子节点的编号为 2i+1, 右孩子节点的编号为 2i+2

  设孩子节点的编号为 i, 则其父节点的编号为\(i-1\)/2

  由于上面的性质，父节点一定比他的儿节点小（大），所以整个树的树根的值一定是最小（最大）的，那么我们就能在 O\(1\)的时间内，获得整个堆的极值。

* 优先队列是一种抽象的数据类型，它和堆的关系类似于，List 和数组、链表的关系一样；我们常常使用堆来实现优先队列，因此很多时候堆和优先队列都很相似，它们只是概念上的区分。
* 优先队列的应用场景十分的广泛，常见的应用有：

  Dijkstra’s algorithm（单源最短路问题中需要在邻接表中找到某一点的最短邻接边，这可以将复杂度降低。）

  Huffman coding（贪心算法的一个典型例子，采用优先队列构建最优的前缀编码树\(prefixEncodeTree\)）

  Prim’s algorithm for minimum spanning tree

  在 java，python 中都已经有封装了的 Priority Queue\(Heaps\)

  优先队列是一个至少能够提供插入（Insert）和删除最小（DeleteMin）这两种操作的数据结构。对应于队列的操作，Insert 相当于 Enqueue，DeleteMin 相当于 Dequeue。

  用堆实现优先的过程中，需要注意最大堆只能对应最大优先队列，最小堆则是对应最小优先队列

* siftup and siftdown:

  给定一个数组 A\[\]，我们的目的是要将 A\[\] 堆化，也就是让 A\[\]满足以下要求：

  A\[i \* 2 + 1\] &gt;= A\[i\]

  A\[i \* 2 + 2\] &gt;= A\[i\]

method1: 对于每个元素 A\[i\]，比较 A\[i\]和它的父亲结点的大小，如果小于父亲结点，则与父亲结点交换。交换后再和新的父亲比较，重复上述操作，直至该点的值大于父亲。时间复杂度分析：对于每个元素都要遍历一遍，这部分是 O\(n\).每处理一个元素时，最多需要向根部方向交换 logn 次。因此总的时间复杂度是 O\(nlogn\) \[proof\]\([https://en.wikipedia.org/wiki/Heap\_\(data\_structure\)](https://en.wikipedia.org/wiki/Heap_%28data_structure%29)\)

```java
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    private void siftup(int[] A, int k) {
        while (k != 0) {
            int father = (k - 1) / 2;
            if (A[k] > A[father]) {
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;

            k = father;
        }
    }

    public void heapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }
}
```

method2: 算法思路： 初始选择最接近叶子的一个父结点，与其两个儿子中较小的一个比较，若大于儿子，则与儿子交换。 交换后再与新的儿子比较并交换，直至没有儿子。 再选择较浅深度的父亲结点，重复上述步骤。 时间复杂度分析 这个版本的算法，乍一看也是 O\(nlogn\)， 但是我们仔细分析一下，算法从第 n/2 个数开始，倒过来进行 siftdown。也就是说，相当于从 heap 的倒数第二层开始进行 siftdown 操作，倒数第二层的节点大约有 n/4 个， 这 n/4 个数，最多 siftdown 1 次就到底了，所以这一层的时间复杂度耗费是 O\(n/4\)，然后倒数第三层差不多 n/8 个点，最多 siftdown 2 次就到底了。所以这里的耗费是 O\(n/8\*2\), 倒数第 4 层是 O\(n/16\*3\)，倒数第 5 层是 O\(n/32\*4\) ... 因此累加所有的时间复杂度耗费为： T\(n\) = O\(n/4\) + O\(n/8\*2\) + O\(n/16\*3\) ... 然后我们用 2T - T 得到： 2\*T\(n\) = O\(n/2\) + O\(n/4\*2\) + O\(n/8\*3\) + O\(n/16\*4\) ... T\(n\) = O\(n/4\) + O\(n/8\*2\) + O\(n/16\*3\) ... 2\*T\(n\) - T\(n\) = O\(n/2\) +O \(n/4\) + O\(n/8\) + ... = O\(n/2 + n/4 + n/8 + ... \) = O\(n\) 因此得到 T\(n\) = 2\*T\(n\) - T\(n\) = O\(n\)

```java
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    private void siftdown(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;   // A[i] 的左儿子下标。
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2])
                son = k * 2 + 2;     // 选择两个儿子中较小的。
            if (A[son] >= A[k])
                break;

            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }

    public void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }
}
```

* 堆排序 运用堆的性质，我们可以得到一种常用的、稳定的、高效的排序算法————堆排序。堆排序的时间复杂度为 O\(n\*log\(n\)\)，空间复杂度为 O\(1\)，堆排序的思想是：对于含有 n 个元素的无序数组 nums, 构建一个堆\(这里是小顶堆\)heap，然后执行 extractMin 得到最小的元素，这样执行 n 次得到序列就是排序好的序列。 如果是降序排列则是小顶堆；否则利用大顶堆。

  Trick 由于 extractMin 执行完毕后，最后一个元素 last 已经被移动到了 root，因此可以将 extractMin 返回的元素放置于最后，这样可以得到 sort in place 的堆排序算法。 当然，如果不使用前面定义的 heap，则可以手动写堆排序，由于堆排序设计到建堆和 extractMin， 两个操作都公共依赖于 siftDown 函数，因此我们只需要实现 siftDown 即可。\(trick:由于建堆操作可以采用 siftUp 或者 siftDown，而 extractMin 是需要 siftDown 操作，因此取公共部分，则采用 siftDown 建堆\)。

```java
//升序堆排序
public class Solution {
    private void siftdown(int[] A, int left, int right) {
        int k = left;
        while (k * 2 + 1 <= right) {
            int son = k * 2 + 1;
            if (son + 1 <= right && A[son] < A[son + 1]) {
                son = k * 2 + 2;
            }
            if (A[son] <= A[k]) {
                break;
            }
            int tmp = A[son];
            A[son] = A[k];
            A[k] = tmp;
            k = son;
        }
    }

    public void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftdown(A, i, A.length - 1);
        }
    }

    void sortIntegers(int[] A) {
        heapify(A);
        for (int i = A.length - 1; i > 0; i--) {
            int tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;
            siftdown(A, 0, i - 1);
        }
    }
}
```

## Chapter 20: 刷人利器深度优先搜索

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_20._刷人利器深度优先搜索.pdf)

## Chapter 21: 高频数据结构哈希表与堆

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_21._高频数据结构哈希表与堆.pdf)

## Chapter 22: 从搜索到动规记忆化搜索入门

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_22._从搜索到动规记忆化搜索入门.pdf)

## Chapter 23: 动态规划入门与动规四要素

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_23._动态规划入门与动规四要素.pdf)

## Chapter 24: 动态规划使用场景与题型分类

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_24._动态规划使用场景与题型分类.pdf)

## Chapter 25: 背包型动态规划入门

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_25._背包型动态规划入门1.pdf)

## Chapter 26: 让面试官眼前一亮的算法——记忆化搜索

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_26.%20让面试官眼前一亮的算法——记忆化搜索.pdf)

## Chapter 27: 让面试官眼前一亮的算法——记忆化搜索

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_27.%20最难的算法——动态规划.pdf)

## Chapter 28: 双指针算法之同向双指针（上）

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_28._双指针算法之同向双指针上.pdf)

## Chapter 29:双指针算法之同向双指针（下）

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_29._双指针算法之同向双指针下.pdf)

## Chapter 30:二分法实战练习精讲

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_30._二分法实战练习精讲.pdf)

## Chapter 31:时间复杂度低于_On_的算法

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_31._时间复杂度低于_On_的算法.pdf)
* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_31._时间复杂度低于_On_的算法2.pdf)
* 辗转相除法

  算法介绍

  辗转相除法， 又名欧几里德算法， 是求最大公约数的一种方法。它的具体做法是：用较大的数除以较小的数，再用除数除以出现的余数（第一余数），再用第一余数除以出现的余数（第二余数），如此反复，直到最后余数是 0 为止。如果是求两个数的最大公约数，那么最后的除数就是这两个数的最大公约数。

代码 Java:

public int gcd\(int big, int small\) { if \(small != 0\) { return gcd\(small, big % small\); } else { return big; } }

两个排序数组的中位数 题目描述 在两个排序数组中，求他们合并到一起之后的中位数 时间复杂度要求：O\(log\(n+m\)\)，其中 n, m 分别为两个数组的长度

解法 基于 FindKth 的算法。整体思想类似于 median of unsorted array 可以用 find kth from unsorted array 的解题思路。 基于二分的方法。二分 median 的值，然后再用二分法看一下两个数组里有多少个数小于这个二分出来的值。

算法描述 先将找中点问题转换为找第 k 小的问题，这里直接令 k = \(n + m\) / 2。那么目标是在 logk = log\(\(n+m\)/2\) = log\(n+m\) 的时间内找到 A 和 B 数组中从小到大第 k 个。 比较 A 数组的第 k/2 小和 B 数组的第 k/2 小的数。谁小，就扔掉谁的前 k/2 个数。 将目标寻找第 k 小修改为寻找第 \(k-k/2\) 小 回到第 2 步继续做，直到 k == 1 或者 A 数组 B 数组里已经没有数了。 F.A.Q Q: 如何 O\(1\) 时间移除数组的前 k/2 个数？

A: 给两个数组一个起始位置的标记参数（相当于一个 offset，偏移位），把这个起始位置 + k/2 就可以了。

Q: 不是让我们找中点么？怎么变成了找第 k 小？

A: 找第 k 小如果能在 log\(k\) 的时间内解决，那么找中点就可以在 log\( \(n+m\)/2 \) 的时间内解决。

Q.如何证明谁的第 k/2 个数比较小就扔掉谁的前 k/2 个数这个理论？

A: 直观的，我们看一个例子

A=\[1,3,5,7\] B=\[2,4,6,8\] 假如我们要找第 4 小。也就是 k = 4。算法会去比较两个数组中第 2 小的数。也就是 A\[1\]=3 和 B\[1\]=4 这两个数的大小。然后会发现，3 比较小，然后就决定扔掉 A 的前 k/2 = 2 个数。也就是，接下来，需要去找

A=\[5,7\] B=\[2,4,6,8\] 中的第 k-k/2=2 小的数。这里我们扔掉了 \[1,3\]，扔掉的这些数中，一定不会包含我们要找的第 4 小的数——4。因为从位置上，他们在 A 和 B 合并到一起之后，都会排在 4 的前面。

抽象的证明一下：

我们需要回顾一下 Merge Two Sorted Arrays 这道题目。算法的做法是，每一次比较两个数组中比较小的数，然后谁小，谁先被拿出来，放到最后的合并结果中。那么假设 A 和 B 中 A\[k/2 - 1\] &lt;= B\[k/2 - 1\]（反之同理）。我们会决定扔掉 A\[0..k/2-1\]，因为这些数在 A 与 B 做简单的 Merge 的过程中，会优先于目标第 k 个数现出来。为什么？因为既然 A\[k/2-1\] &lt;= B\[k/2-1\]，那么当我们用最简单的 Merge Two Sorted Arrays 的算法一个个从 A 和 B 里拿数出来的时候，当 A\[k/2 - 1\] 出来的时候，B\[k/2 - 1\] 一定还没有被拿出来，那么此时 A 里出来了 k/2 个数，B 里出来的数一定不够 k/2 个（因为第 k/2 个数都还没出来），所以加起来总共出来的数肯定不够 k 个，所以第 k 小的数一定还留在 AB 数组中。

因此我们证明了：扔掉较小的一部分的前 k/2 个数，不会扔掉要找的第 k 小的数。

基于二分的算法 算法描述 我们需要先确定二分的上下界限，由于两个数组 A, B 均有序，所以下界为 min\(A\[0\], B\[0\]\)，上界为 max\(A\[A.length - 1\], B\[B.length - 1\]\). 判断当前上下界限下的 mid\(mid = \(start + end\) / 2\) 是否为我们需要的答案；这里我们可以分别对两个数组进行二分来找到两个数组中小于等于当前 mid 的数的个数 cnt1 与 cnt2，sum = cnt1 + cnt2 即为 A 跟 B 合并后小于等于当前 mid 的数的个数. 如果 sum &lt; k，即中位数肯定不是 mid，应该大于 mid，更新 start 为 mid，否则更新 end 为 mid，之后再重复第二步 当不满足 start + 1 &lt; end 这个条件退出二分循环时，再分别判断一下 start 跟 end ，最终返回符合要求的那个数即可 算法详解 如果对该算法有点疑问，我们下面来详细讲解一下：

这一题如果用二分法来做，其实就是一个二分答案的过程 首先我们已经得到了上下界限，那么答案必定是在这个上下界限中的，需要实现的就是从这个歌上下界限中找出答案 我们每次取的 mid，其实就是我们每次在假设答案为 mid，二分的过程就是不断的推翻这个假设，然后再假设新的答案 需要满足的条件为： 上面算法描述中的 sum 需要等于 k，这里的 k = \(A.length + B.length\) / 2. 如果 sum &lt; k，很明显当前的 mid 偏小，需要增大，否则就说明当前的 mid 偏大，需要缩小. 最终在 start 与 end 相邻的时候退出循环，判断 start 跟 end 哪个符合条件即可得到最终结果

分解质因数 以 sqrt{n} 为时间复杂度的算法并不多见，最具代表性的就是分解质因数了。

具体步骤 记 up = sqrt{n}，作为质因数 k 的上界, 初始化 k=2。 当 k &lt;= up 且 n 不为 1 时，执行步骤 3，否则执行步骤 4。 当 n 被 k 整除时，不断整除并覆盖 n，同时结果中记录 k，直到 n 不能整出 k 为止。之后 k 自增，执行步骤 2。 当 n 不为 1 时，把 n 也加入结果当中，算法结束。 几点解释 不需要判定 k 是否为质数，如果 k 不为质数，且能整出 n 时，n 早被 k 的因数所除。故能整除 n 的 k 必是质数。 为何引入 up？为了优化性能。当 k 大于 up 时，k 已不可能整除 n，除非 k 是 n 自身。也即为何步骤 4 判断 n 是否为 1，n 不为 1 时必是比 up 大的质数。 步骤 2 中，也判定 n 是否为 1，这也是为了性能，当 n 已为 1 时，可早停。 代码

```java
public List<Integer> primeFactorization(int n) {
    List<Integer> result = new ArrayList<>();
    int up = (int) Math.sqrt(n);

    for (int k = 2; k <= up && n > 1; ++k) {
        while (n % k == 0) {
            n /= k;
            result.add(k);
        }
    }

    if (n > 1) {
        result.add(n);
    }

    return result;
}
```

复杂度分析 最坏时间复杂度 O\(sqrt \(n\) \)。当 n 为质数时，取到其最坏时间复杂度。 空间复杂度 O\(log\(n\)\), 当 n 质因数很多时，需要空间大，但总不会多于 O\(log\(n\)\)个 延伸 质因数分解有一种更快的算法，叫做 Pollard Rho 快速因数分解。该算法时间复杂度为 O\(n^{1/4}\)，其理解起来稍有难度，有兴趣的同学可以进行自学

## Chapter 32:使用宽度优先搜索找所有方案

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_32._使用宽度优先搜索找所有方案.pdf)

## Chapter 33: 双向宽度优先搜索算法

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_33.__双向宽度优先搜索.pdf)

## Chapter 34: 后序遍历非递归与 Morris 算法

在第 13 章的学习中，我们掌握了如何使用非递归形式获得二叉树的前序、中序遍历。而在这节课中，我们将继续使用非递归形式求出二叉树的后序遍历。然后我们将学习另外一类遍历二叉树的算法——Morris 算法。

本章关键字：前序遍历（Preorder Traversal），中序遍历（Inorder Traversal），后序遍历（Postorder Traversal）。

与前序、中序的非递归方式相同，二叉树的非递归后序遍历也需要借助栈来完成，遍历顺序为左、右、根。

大致思路如下： 1、如果根节点非空，将根节点加入到栈中。 2、如果栈不空，取栈顶元素（暂时不弹出）， a.如果（左子树已访问过或者左子树为空），且（右子树已访问过或右子树为空），则弹出栈顶节点，将其值加入数组， b.如果左子树不为空，且未访问过，则将左子节点加入栈中，并标左子树已访问过。 c.如果右子树不为空，且未访问过，则将右子节点加入栈中，并标右子树已访问过。 3、重复第二步，直到栈空。

```java
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null; // previously traversed node
    TreeNode curr = root;
    if (root == null) {
        return result;
    }

    stack.push(root);
    while (!stack.empty()) {
        curr = stack.peek();
        if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
            if (curr.left != null) {
                stack.push(curr.left);
            } else if (curr.right != null) {
                stack.push(curr.right);
            }
        } else if (curr.left == prev) { // traverse up the tree from the left
            if (curr.right != null) {
                stack.push(curr.right);
            }
        } else { // traverse up the tree from the right
            result.add(curr.val);
            stack.pop();
        }
        prev = curr;
    }
    return result;
}
```

什么是 Morris 算法 与递归和使用栈空间遍历的思想不同，Morris 算法使用二叉树中的叶节点的 right 指针来保存后面将要访问的节点的信息，当这个 right 指针使用完成之后，再将它置为 null，但是在访问过程中有些节点会访问两次，所以与递归的空间换时间的思路不同，Morris 则是使用时间换空间的思想。

节点定义 Java:

class TreeNode{ int val; TreeNode left; TreeNode right; pubic TreeNode\(int val\) { this.val = val; this.left = this.right = null; } }

用 Morris 算法进行中序遍历\(Inorder Traversal\) 思路 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。 重复 1、2 两步直到当前节点为空。 上图为每一步迭代的结果（从左至右，从上到下），cur 代表当前节点，深色节点表示该节点已输出。

```text
public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        TreeNode cur = null;

        while (root != null) {
            if (root.left != null) {
                cur = root.left;
                while (cur.right != null && cur.right != root) {
                    cur = cur.right;
                }

                if (cur.right == root) {
                    nums.add(root.val);
                    cur.right = null;
                    root = root.right;
                } else {
                    cur.right = root;
                    root = root.left;
                }
            } else {
                nums.add(root.val);
                root = root.right;
            }
        }

        return nums;
    }

}
```

用 Morris 算法实现先序遍历\(Preorder Traversal\) 思路 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。输出当前节点（与中序遍历唯一一点不同）。当前节点更新为当前节点的左孩子。 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。当前节点更新为当前节点的右孩子。 重复 1、2 两步直到当前节点为空。

```text
public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // morris traversal
        List<Integer> nums = new ArrayList<>();
        TreeNode cur = null;
        while (root != null) {
            if (root.left != null) {
                cur = root.left;
                // find the predecessor of root node
                while (cur.right != null && cur.right != root) {
                    cur = cur.right;
                }
                if (cur.right == root) {
                    cur.right = null;
                    root = root.right;
                } else {
                    nums.add(root.val);
                    cur.right = root;
                    root = root.left;
                }
            } else {
                nums.add(root.val);
                root = root.right;
            }
        }
        return nums;
    }
}
```

用 Morris 算法实现后序遍历\(Postorder Traversal\) 思路 后序遍历其实可以看作是和前序遍历左右对称的，此处，我们同样可以利用这个性质，基于前序遍历的算法，可以很快得到后序遍历的结果。我们只需要将前序遍历中所有的左孩子和右孩子进行交换就可以了。

```text
public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        TreeNode cur = null;
        while (root != null) {
            if (root.right != null) {
                cur = root.right;
                while (cur.left != null && cur.left != root) {
                    cur = cur.left;
                }
                if (cur.left == root) {
                    cur.left = null;
                    root = root.left;
                } else {
                    nums.add(root.val);
                    cur.left = root;
                    root = root.right;
                }
            } else {
                nums.add(root.val);
                root = root.left;
            }
        }
        Collections.reverse(nums);
        return nums;
    }
}
```

## Chapter 35:二叉查找树的增删查改

* BST 的增删查改

  什么是二叉搜索树\(Binary Search Tree\)

  二叉搜索树可以是一棵空树或者是一棵满足下列条件的二叉树:

  如果它的左子树不空，则左子树上所有节点值均小于它的根节点值。

  如果它的右子树不空，则右子树上所有节点值均大于它的根节点值。

  它的左右子树均为二叉搜索树\(BST\)。

  严格定义下 BST 中是没有值相等的节点的\(No duplicate nodes\)。

  根据上述特性，我们可以得到一个结论：BST 中序遍历得到的序列是升序的。

  BST 基本操作——增删改查\(CRUD\)

  对于树节点的定义如下：

```text
class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  pubic TreeNode(int val) {
  this.val = val;
  this.left = this.right = null;
  }
}
```

* 基本操作之查找\(Retrieve\)

  思路: 查找值为 val 的节点，如果 val 小于根节点则在左子树中查找，反之在右子树中查找

```text
public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }// 未找到值为val的节点
    if (val < root.val) {
      return searchBST(root.left, val);//val小于根节点值，在左子树中查找
    } else if (val > root.val) {
      return searchBST(root.right, val);//val大于根节点值，在右子树中查找
    } else {
      return root;//找到了
    }
}
```

* 基本操作之修改\(Update\)

  思路: 修改仅仅需要在查找到需要修改的节点之后，更新这个节点的值就可以了

```text
public void updateBST(TreeNode root, int target, int val) {
  if (root == null) {
  return;
  }// 未找到 target 节点
  if (target < root.val) {
  updateBST(root.left, target, val);//target 小于根节点值，在左子树中查找
  } else if (target > root.val) {
  updateBST(root.right, target, val);//target 大于根节点值，在右子树中查找
  } else { //找到了
  root.val = val;
  }
}
```

* 基本操作之增加\(Create\)

  思路: 根节点为空，则待添加的节点为根节点

  如果待添加的节点值小于根节点，则在左子树中添加

  如果待添加的节点值大于根节点，则在右子树中添加

  我们统一在树的叶子节点\(Leaf Node\)后添加

```text
public TreeNode insertNode(TreeNode root, TreeNode node) {
  if (root == null) {
  return node;
  }
  if (root.val > node.val) {
  root.left = insertNode(root.left, node);
  } else {
  root.right = insertNode(root.right, node);
  }
  return root;
}
```

* 基本操作之删除\(Delete\)

  思路:

  考虑待删除的节点为叶子节点，可以直接删除并修改父亲节点\(Parent Node\)的指针，需要区分待删节点是否为根节点

  考虑待删除的节点为单支节点\(只有一棵子树——左子树 or 右子树\)，与删除链表节点操作类似，同样的需要区分待删节点是否为根节点

  考虑待删节点有两棵子树，可以将待删节点与左子树中的最大节点进行交换，由于左子树中的最大节点一定为叶子节点，所以这时再删除待删的节点可以参考第一条

  详细的解释可以看 [http://www.algolist.net/Data\_structures/Binary\_search\_tree/Removal](http://www.algolist.net/Data_structures/Binary_search_tree/Removal)

```text
public TreeNode removeNode(TreeNode root, int value) {
    TreeNode dummy = new TreeNode(0);
    dummy.left = root;
    TreeNode parent = findNode(dummy, root, value);
    TreeNode node;
    if (parent.left != null && parent.left.val == value) {
        node = parent.left;
    } else if (parent.right != null && parent.right.val == value) {
        node = parent.right;
    } else {
        return dummy.left;
    }
    deleteNode(parent, node);
    return dummy.left;
}

private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
    if (node == null) {
        return parent;
    }
    if (node.val == value) {
        return parent;
    }
    if (value < node.val) {
        return findNode(node, node.left, value);
    } else {
        return findNode(node, node.right, value);
    }
}

private void deleteNode(TreeNode parent, TreeNode node) {
    if (node.right == null) {
        if (parent.left == node) {
            parent.left = node.left;
        } else {
            parent.right = node.left;
        }
    } else {
        TreeNode temp = node.right;
        TreeNode father = node;
        while (temp.left != null) {
            father = temp;
            temp = temp.left;
        }
        if (father.left == temp) {
            father.left = temp.right;
        } else {
            father.right = temp.right;
        }
        if (parent.left == node) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }
        temp.left = node.left;
        temp.right = node.right;
    }
}
```

## Chapter 36: 非递归的方式实现排列和组合类 DFS

本章关键字：Combination（组合），Permutations（排列），Binary（二进制）。

用非递归（Non-recursion / Iteration）的方式实现全子集问题，有两种方式：

进制转换（binary） 宽度优先搜索（Breadth-first Search） 基于进制转换的方法 思路就是使用一个 正整数的二进制表示 的第 i 位是 1 还是 0 来代表集合的第 i 个数取或者不取。因为从 0 到 2^n - 1 总共 2^n 个整数，正好对应集合的 2^n 个子集。 比如 {1，2，3} 的子集可以用 0 到 7 来表示。

0 -&gt; 000 -&gt; {} 1 -&gt; 001 -&gt; {3} 2 -&gt; 010 -&gt; {2} 3 -&gt; 011 -&gt; {2,3} 4 -&gt; 100 -&gt; {1} 5 -&gt; 101 -&gt; {1,3} 6 -&gt; 110 -&gt; {1,2} 7 -&gt; 111 -&gt; {1,2,3}

```java
class Solution {
/\*\*
_ @param S: A set of numbers.
_ @return: A list of lists. All valid subsets.
\*/
public List<List<Integer>> subsets(int[] nums) {
List<List<Integer>> result = new ArrayList<List<Integer>>();
int n = nums.length;
Arrays.sort(nums);
for (int i = 0; i < (1 << n); i++) {
List<Integer> subset = new ArrayList<Integer>();
for (int j = 0; j < n; j++) {
if ((i & (1 << j)) != 0) {
subset.add(nums[j]);
}
}
result.add(subset);
}

        return result;
    }

}
```

基于 BFS 的方法 在 BFS 那节课的讲解中，我们很少提到用 BFS 来解决找所有的方案的问题。事实上 BFS 也是可以用来做这件事情的。 用 BFS 来解决该问题时，层级关系如下：

第一层: \[\] 第二层: \[1\] \[2\] \[3\] 第三层: \[1, 2\] \[1, 3\], \[2, 3\] 第四层: \[1, 2, 3\] 每一层的节点都是上一层的节点拓展而来。

```java
public class Solution {

    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // List vs ArrayList （google）
        List<List<Integer>> results = new LinkedList<>();

        if (nums == null) {
            return results; // 空列表
        }

        Arrays.sort(nums);

        // BFS
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<Integer>());

        while (!queue.isEmpty()) {
            List<Integer> subset = queue.poll();
            results.add(subset);

            for (int i = 0; i < nums.length; i++) {
                if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                    List<Integer> nextSubset = new ArrayList<Integer>(subset);
                    nextSubset.add(nums[i]);
                    queue.offer(nextSubset);
                }
            }
        }

        return results;
    }
}
```

在学习全排列的解决方法之前，我们先来学习如何求 下一个排列。

问题：给定一个若干整数的排列，给出按整数大小进行字典序从小到大排序后的下一个排列。若没有下一个排列，则输出字典序最小的序列。 从末尾往左走，如果一直递增，例如 {...9,7,5} ，那么下一个排列一定会牵扯到左边更多的数，直到一个非递增数为止，例如 {...6,9,7,5} 。对于原数组的变化就只到 6 这里，和左侧其他数再无关系。6 这个位置会变成 6 右侧所有数中比 6 大的最小的数，而 6 会进入最后 3 个数中，且后 3 个数必是升序数组。 所以算法步骤如下：

从右往左遍历数组 nums，直到找到一个位置 i ，满足 nums\[i\] &gt; nums\[i - 1\] 或者 i 为 0 。 i 不为 0 时，用 j 再次从右到左遍历 nums ，寻找第一个 nums\[j\] &gt; nums\[i - 1\] 。而后交换 nums\[j\] 和 nums\[i - 1\] 。注意，满足要求的 j 一定存在！且交换后 nums\[i\] 及右侧数组仍为降序数组。 将 nums\[i\] 及右侧的数组翻转，使其升序。

可能会有同学有些疑问： Q：i 为 0 怎么办？ A：i 为 0 说明整个数组是降序的，直接翻转整个数组即可。

Q：有重复元素怎么办？ A：在遍历时只要严格满足 nums\[i\] &gt; nums\[i - 1\] 和 nums\[j\] &gt; nums\[i - 1\] 就不会有问题。

Q：元素过少是否要单独考虑？ A：当元素个数小于等于 1 个时，可以直接返回。

```java
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
    */
    // 用于交换nums[i]和nums[j]
    public void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 用于翻转nums[i]到nums[j]，包含两端的这一小段数组
    public void swapList(int[] nums, int i, int j) {
        while (i < j) {
            swapItem(nums, i, j);
            i ++;
            j --;
        }
    }
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if ( len <= 1) {
            return;
        }
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i --;
        }
        if (i != 0) {
            int j = len - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swapItem(nums, j, i-1);
        }
        swapList(nums, i, len - 1);
    }
}
```

在学习了 下一个排列 的算法之后，对于全排列问题，我们只需要不断调用这个算法的函数就可以啦。 一些可以做得更细致的地方： 为了确定何时结束，建议在迭代前，先对输入 nums 数组进行升序排序，迭代到降序时，就都找完了。有心的同学可能还记得在 nextPermutation 当中，当且仅当数组完全降序，那么从右往左遍历的指针 i 最终会指向 0 。所以可以为 nextPermutation 带上布尔返回值，当 i 为 0 时，返回 false，表示找完了。要注意，排序操作在这样一个 NP 问题中，消耗的时间几乎可以忽略。 当数组长度为 1 时，nextPermutation 会直接返回 false ；当数组长度为 0 时， nextPermutation 中 i 会成为 -1 ，所以返回 false 的条件可以再加上 i 为 -1 。 Java 中，如果输入类型是 int\[\] ，而输出类型是 List ，要注意，并没有太好的方法进行类型转换，这是由于 int 是基本类型。建议还是自行手动复制，实际工作中还可使用 guava 库。

```java
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        boolean next = true;  // next 为 true 时，表示可以继续迭代
        while (next)  {
            List<Integer> current = new ArrayList<>();  // 进行数组复制
            for (int num : nums) {
                current.add(num);
            }

            result.add(current);
            next = nextPermutation(nums);
        }
        return result;
    }
    // 用于交换nums[i]和nums[j]
    public void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 用于翻转nums[i]到nums[j]，包含两端的这一小段数组
    public void swapList(int[] nums, int i, int j) {
        while (i < j) {
            swapItem(nums, i, j);
            i ++;
            j --;
        }
    }
    public boolean nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = len - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swapItem(nums, j, i - 1);

        swapList(nums, i, len - 1);

        return true;
    }

}
```

最后我们来研究下如何求一个排列是第几个。

题目：给出一个不含重复数字的排列，求这些数字的所有排列按字典序排序后该排列的编号，编号从 1 开始。例如排列 \[1, 2, 4\] 是第 1 个排列。

算法描述 只需计算有多少个排列在当前排列 A 的前面即可。如何算呢?举个例子，\[3,7,4,9,1\]，在它前面的必然是某位置 i 对应元素比原数组小，而 i 左侧和原数组一样。也即 \[3,7,4,1,X\] ， \[3,7,1,X,X\] ， \[3,1 或 4,X,X,X\] ， \[1,X,X,X,X\] 。 而第 i 个元素，比原数组小的情况有多少种，其实就是 A\[i\] 右侧有多少元素比 A\[i\] 小，乘上 A\[i\] 右侧元素全排列数，即 A\[i\] 右侧元素数量的阶乘。 i 从右往左看，比当前 A\[i\] 小的右侧元素数量分别为 1,1,2,1，所以最终字典序在当前 A 之前的数量为 1×1!+1×2!+2×3!+1×4!=39 ，故当前 A 的字典序为 40。

具体步骤： 用 permutation 表示当前阶乘，初始化为 1,result 表示最终结果，初始化为 0 。由于最终结果可能巨大，所以用 long 类型。 i 从右往左遍历 A ，循环中计算 A\[i\] 右侧有多少元素比 A\[i\] 小，计为 smaller ，result += smaller  _permutation。之后 permutation_ = A.length - i ，为下次循环 i 左移一位后的排列数。 已算出多少字典序在 A 之前，返回 result + 1 。

```java
public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        long permutation = 1;
        long result = 0;
        for (int i = A.length - 2; i >= 0; --i) {
            int smaller = 0;
            for (int j = i + 1; j < A.length; ++j) {
                if (A[j] < A[i]) {
                    smaller++;
                }
            }
            result += smaller * permutation;
            permutation *= A.length - i;
        }
        return result + 1;
    }
}
```

常见 QA： Q：为了找寻每个元素右侧有多少元素比自己小，用了 O\(n^2\)的时间，能不能更快些？ A：可以做到 O\(nlogn\)，但是很复杂，这是另外一个问题了，可以使用 BST，归并排序或者线段树：[http://www.lintcode.com/zh-cn/problem/count-of-smaller-number-before-itself/](http://www.lintcode.com/zh-cn/problem/count-of-smaller-number-before-itself/) Q：元素有重复怎么办？ A：好问题！元素有重复，情况会复杂的多。因为这会影响 A\[i\] 右侧元素的排列数，此时的排列数计算方法为总元素数的阶乘，除以各元素值个数的阶乘，例如 \[1, 1, 1, 2, 2, 3\] ，排列数为 6! ÷ \(3! × 2! × 1!\) 。为了正确计算阶乘数，需要用哈系表记录 A\[i\] 及右侧的元素值个数，并考虑到 A\[i\] 与右侧比其小的元素 A\[k\] 交换后，要把 A\[k\] 的计数减一。用该哈系表计算正确的阶乘数。而且要注意，右侧比 A\[i\]小 的重复元素值只能计算一次，不要重复计算！

## Chapter 37:DFS 经典题精讲

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_37._DFS经典题精讲.pdf)

## Chapter 38:数据结构设计类问题

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_38._数据结构设计类问题.pdf)

## Chapter 39: 外排序算法与数组合并类问题

* see [slide](../JiuZhangAlgorithm2020/CoursePDF/chapter%2039.pptx)
* 外排序算法（External Sorting） 外排序算法是指在内存不够的情况下，如何对存储在一个或者多个大文件中的数据进行排序的算法。外排序算法通常是解决一些大数据处理问题的第一个步骤，或者是面试官所会考察的算法基本功。外排序算法是海量数据处理算法中十分重要的一块。在学习这类大数据算法时，经常要考虑到内存、缓存、准确度等因素，这和我们之前见到的算法都略有差别。
* 外排序算法分为两个基本步骤：将大文件切分为若干个个小文件，并分别使用内存排好序, 使用 K 路归并算法（k-way merge）将若干个排好序的小文件合并到一个大文件中
  * 第一步：文件拆分 根据内存的大小，尽可能多的分批次的将数据 Load 到内存中，并使用系统自带的内存排序函数（或者自己写个快速排序算法），将其排好序，并输出到一个个小文件中。比如一个文件有 1T，内存有 1G，那么我们就这个大文件中的内容按照 1G 的大小，分批次的导入内存，排序之后输出得到 1024 个 1G 的小文件。
  * 第二步：K 路归并算法 K 路归并算法使用的是数据结构堆（Heap）来完成的，使用 Java 或者 C++ 的同学可以直接用语言自带的 PriorityQueue（C++中叫 priority\_queue）来代替。

    我们将 K 个文件中的第一个元素加入到堆里，假设数据是从小到大排序的话，那么这个堆是一个最小堆（Min Heap）。每次从堆中选出最小的元素，输出到目标结果文件中，然后如果这个元素来自第 x 个文件，则从第 x 个文件中继续读入一个新的数进来放到堆里，并重复上述操作，直到所有元素都被输出到目标结果文件中。

    Follow up: 一个个从文件中读入数据，一个个输出到目标文件中操作很慢，如何优化？

    如果我们每个文件只读入 1 个元素并放入堆里的话，总共只用到了 1024 个元素，这很小，没有充分的利用好内存。另外，单个读入和单个输出的方式也不是磁盘的高效使用方式。因此我们可以为输入和输出都分别加入一个缓冲（Buffer）。假如一个元素有 10 个字节大小的话，1024 个元素一共 10K，1G 的内存可以支持约 100K 组这样的数据，那么我们就为每个文件设置一个 100K 大小的 Buffer， 每次需要从某个文件中读数据，都将这个 Buffer 装满。当然 Buffer 中的数据都用完的时候，再批量的从文件中读入。输出同理，设置一个 Buffer 来避免单个输出带来的效率缓慢。

