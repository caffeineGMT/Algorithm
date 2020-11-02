<!-- markdownlint-disable MD025-->

# Note

This is a repo recording notes based on JiuZhang Algorithm Series.

# Chapter 1: FB 面试官揭秘算法面试速成技巧 - 怎样做到 Bug Free 和刷 100 题等于别人刷 300 题

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_1._FB面试官揭秘面试速成技巧_-_怎样做到_Bug_Free_和刷100题刷300题.pdf)

# Chapter 2: 真实面试案例分析（上）与面试评分标准

- 字符串查找——Robin Karp 算法
- greedy algorithm:
  - not worth the time to study it
  - Dijkstra
- frequently used string function:
  - String demo = "Hello,world!";
  - int length = demo.length();
  - boolean equals = demo.equals("Hello,world");
  - boolean contains = demo.contains("word");
  - String replace = demo.replace("Hello,", "Yeah@");
  - char little = demo.charAt(5);
  - String trim = demo.trim();
  - String concat = demo.concat("Great!");
  - char[] charArray = demo.toCharArray();
  - String upperCase = demo.toUpperCase();
  - String lowerCase = demo.toLowerCase();
- string-related knowledge:

  - example:

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

  - `==` is testing if 2 items are the same instance of String class, not the content of these 2 items.
  - `equals` is testing if 2 items are the same instance first, if not, testing if they have the same content
  - `StringBuilder` is testing if 2 items are the same instance. In the case above, first "hel" is the instance of String class, second "hel" is the instance of StringBuilder class
  - if memory already has this string, it wont create new string. See case below.

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

# Chapter 3: 真实面试案例分析（下）与 80%求职者会踩坑的基础知识

# Chapter 4: 复杂度理论与双指针算法入门

## theory

- time complexity: priority
- space complexity: sub-priority
- coding complexity: can use built-in functions tho it might hurt time complexity a bit, but need to negotiate with interviewer
- thinking complexity: easy to follow in thinking

## time complexity

- P: polynomial
- NP: Nondeterministic polynomial

- other:
  - [Harmonic Series complexity](https://stackoverflow.com/questions/25905118/finding-big-o-of-the-harmonic-series): 1+1/2+1/3+...+1/n O(lgn)
  - O(n+m) == O(max(n,m))

# Chapter 5: 必须熟练掌握的两个排序算法

| feature   | quick sort                   | merge sort |
| --------- | ---------------------------- | ---------- |
| time      | average: O(nlgn) worst: O(n) | O(nlgn)    |
| space     | O(1)                         | O(n)       |
| stability | \*not stable                 | stable     |

# Chapter 6: 时间复杂度为 O(logN)的高频算法——二分法

- time complexity:

  | Big O   | use case                                                                           |
  | ------- | ---------------------------------------------------------------------------------- |
  | O(1)    | bit operation, constant calc                                                       |
  | O(lgn)  | binary search, binary lifting，exponentiation by squaring，Euclidean algorithm     |
  | O(n)    | enumeration, double pointer，monotone stack，KMP, Rabin Karp, Manacher's Algorithm |
  | O(nlgn) | quick sort, heap sort, merge sort                                                  |
  | O(n^2)  | enumeration, dynamic programming, Dijkstra                                         |
  | O(n^3)  | enumeration, dynamic programming, Floyd                                            |
  | O(2^n)  | combination                                                                        |

- stack space vs heap space:
  - what will be stored in stack space when calling a function?: function itself, parameter passed in, return value, local var in function
  - Java Object: `int[] arr = new int[10];` arr is actually a variable which takes small memory to record a reference/address. If arr is in local func, it will be destroyed when function finishes. But `new int[10]` is saved in heap, it wont be destroyed right away.

# Chapter 7: 一个不会出现死循环的通用二分法模板

- [template](../JiuZhangAlgorithm2020/week2/BinarySearchTemplate.java)

# Chapter 8: 高频算法之王——双指针算法之相向双指针

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_8._高频算法之王双指针算法之相向双指针.pdf)

# Chapter 9: 简约而不简单——二分法学习的四重境界

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_9._简约而不简单二分法的四重境界.pdf)

# Chapter 10: 队列知识点从易到难

- Queue: using LinkedList and ArrayList

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

- Set:
  - no duplicate value
  - can have null value
  - no order

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

- map:
  - key is not duplicated, value can be
  - allow key and value to be null
  - no order

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

- interface:
  - interface cannot have variable, we can only declare constant in interface.
  - one class can implement multiple interfaces
- abstract class:
  - very similar to interface, provide declaration but not implementation
  - one class can only extends one (abstract) class

# Chapter 11: 宽度优先搜索与图论入门

- 3 bfs method: single queue, double queue, dummy node
- way to describe a graph
  - adjacency matrix:
    [
    [1,0,0,1],
    [0,1,1,0],
    [0,1,1,0],
    [1,0,0,1]
    ]
    例如上图表示 0 号点和 3 号点有连边。1 号点和 2 号点有连边。
    当然，每个点和自己也是默认有连边的。
    图中的 0 表示不连通，1 表示连通。
    我们也可以用一个更具体的整数值来表示连边的长度。
    邻接矩阵我们可以直接用一个二维数组表示，如
    int[][] matrix;
    这种数据结构因为耗费 O(n^2) 的空间，所以在稀疏图上浪费很大，因此并不常用。
  - adjacency list:
    [
    [1],
    [0,2,3],
    [1],
    [1]
    ]
    这个图表示 0 和 1 之间有连边，1 和 2 之间有连边，1 和 3 之间有连边。即每个点上存储自己有哪些邻居（有哪些连通的点）。
    这种方式下，空间耗费和边数成正比，可以记做 O(m)，m 代表边数。m 最坏情况下虽然也是 O(n^2)，但是邻接表的存储方式大部分情况下会比邻接矩阵更省空间。
    可以用自定义的类来实现邻接表
    Java:
    class DirectedGraphNode {
    int label;
    List neighbors;
    ...
    }
    也可以使用 HashMap 和 HashSet 搭配的方式来存储邻接表
    Map<T, Set> = new HashMap<Integer, HashSet>();

# Chapter 12: 用递归实现遍历法和分治法

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_12._用递归实现遍历法和分治法.pdf)

# Chapter 13: 使用非递归实现二叉树的遍历

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_13._使用非递归实现二叉树的遍历.pdf)

# Chapter 14: 性价比之王——宽度优先搜索

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_14._性价比之王宽度优先搜索.pdf)

# Chapter 15: 解决 99%二叉树问题的算法——分治法

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_15._解决99二叉树问题的算法分治法1.pdf)

# Chapter 16: 组合类 DFS

- 在非二叉树上的深度优先搜索（Depth-first Search）中，90%的问题，不是求组合（Combination）就是求排列（Permutation）。特别是组合类的深度优先搜索的问题特别的多。而排列组合类的搜索问题，本质上是一个“隐式图”的搜索问题。一个问题如果没有明确的告诉你什么是点，什么是边，但是又需要你进行搜索的话，那就是一个隐式图搜索问题了。所以对于这类问题，我们首先要分析清楚什么是点什么是边。

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter16.pptx)

# Chapter 17: 排列类 DFS

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_15._解决99二叉树问题的算法分治法1.pdf)

# Chapter 18: 哈希表的原理

- HashMap 和 HashSet 的区别:
  首先得看 java 最基本的两种数据结构：数组和链表的区别：
  数组易于快速读取（通过 for 循环），不便存储（数组长度有限制）；链表易于存储，不易于快速读取。
  哈希表的出现是为了解决链表访问不快速的弱点，哈希表也称散列表。
  HashSet 是通过 HashMap 来实现的，HashMap 的输入参数有 Key、Value 两个组成，在实现 HashSet 的时候，保持 HashMap 的 Value 为常量，相当于在 HashMap 中只对 Key 对象进行处理。
  HashMap 的底层是一个数组结构，数组中的每一项对应了一个链表，这种结构称“链表散列”的数据结构，即数组和链表的结合体；也叫散列表、哈希表。
  想要了解 HashMap 和 HashSet 这样两个不同存储结构的区别，就得熟知他们的存储过程

- HashMap 存储对象的过程
  1、对 HashMap 的 Key 调用 hashCode()方法，返回 int 值，即对应的 hashCode；
  2、把此 hashCode 作为哈希表的索引，查找哈希表的相应位置，若当前位置内容为 NULL，则把 HashMap 的 Key、Value 包装成 Entry 数组，放入当前位置；
  3、若当前位置内容不为空，则继续查找当前索引处存放的链表，利用 equals 方法，找到 Key 相同的 Entry 数组，则用当前 Value 去替换旧的 Value；
  4、若未找到与当前 Key 值相同的对象，则把当前位置的链表后移（Entry 数组持有一个指向下一个元素的引用），把新的 Entry 数组放到链表表头；

- HashSet 存储对象的过程
  往 HashSet 添加元素的时候，HashSet 会先调用元素的 hashCode 方法得到元素的哈希值 ，然后通过元素 的哈希值经过移位等运算，就可以算出该元素在哈希表中 的存储位置。
  情况 1： 如果算出元素存储的位置目前没有任何元素存储，那么该元素可以直接存储到该位置上。
  情况 2： 如果算出该元素的存储位置目前已经存在有其他的元素了，那么会调用该元素的 equals 方法与该位置的元素再比较一次，如果 equals 返回的是 true，那么该元素与这个位置上的元素就视为重复元素，不允许添加，如果 equals 方法返回的是 false，那么该元素运行添加。

- 哈希表（Java 中的 HashSet / HashMap，C++ 中的 unordered_map，Python 中的 dict）是面试中非常常见的数据结构。它的主要考点有两个： 1.是否会灵活的使用哈希表解决问题 2.是否熟练掌握哈希表的基本原理

- HashSet 实现了 Set 接口，其内部不允许出现重复的值，如果我们将一个对象存入 HashSet，必须重写 equals()和 hashCode()方法，这样才能确保集合中不存在同一个元素。HashSet 的内部是无序的，因此不能使用 hashset.get(index) 来获取元素。HashMap 实现了 Map 接口，其内容是键值对的映射（key->value），不允许出现相同的键（key）。在查询的时候会根据给出的键来查询对应的值。我们可以认为，HashSet 和 HashMap 增查操作的时间复杂度都是常数级的。

- 工程中 open hashing 比 close hashing 用的多

- rehashing

# Chapter 19: 堆的基本原理

- 堆是一棵满足如下性质的二叉树：
  1、父节点的键值总是不大于它的孩子节点的键值（小顶堆）。
  2、父节点的键值总是不小于它的孩子节点的键值（大顶堆）。
  由于堆是一棵形态规则的二叉树，因此堆的父节点和孩子节点存在如下关系（根节点编号为 0）：
  设父节点的编号为 i, 则其左孩子节点的编号为 2i+1, 右孩子节点的编号为 2i+2
  设孩子节点的编号为 i, 则其父节点的编号为(i-1)/2
  由于上面的性质，父节点一定比他的儿节点小（大），所以整个树的树根的值一定是最小（最大）的，那么我们就能在 O(1)的时间内，获得整个堆的极值。
- 优先队列是一种抽象的数据类型，它和堆的关系类似于，List 和数组、链表的关系一样；我们常常使用堆来实现优先队列，因此很多时候堆和优先队列都很相似，它们只是概念上的区分。
- 优先队列的应用场景十分的广泛，常见的应用有：
  Dijkstra’s algorithm（单源最短路问题中需要在邻接表中找到某一点的最短邻接边，这可以将复杂度降低。）
  Huffman coding（贪心算法的一个典型例子，采用优先队列构建最优的前缀编码树(prefixEncodeTree)）
  Prim’s algorithm for minimum spanning tree
  在 java，python 中都已经有封装了的 Priority Queue(Heaps)
  优先队列是一个至少能够提供插入（Insert）和删除最小（DeleteMin）这两种操作的数据结构。对应于队列的操作，Insert 相当于 Enqueue，DeleteMin 相当于 Dequeue。
  用堆实现优先的过程中，需要注意最大堆只能对应最大优先队列，最小堆则是对应最小优先队列
- siftup and siftdown:
  给定一个数组 A[]，我们的目的是要将 A[] 堆化，也就是让 A[]满足以下要求：
  A[i * 2 + 1] >= A[i]
  A[i * 2 + 2] >= A[i]

method1:
对于每个元素 A[i]，比较 A[i]和它的父亲结点的大小，如果小于父亲结点，则与父亲结点交换。交换后再和新的父亲比较，重复上述操作，直至该点的值大于父亲。时间复杂度分析：对于每个元素都要遍历一遍，这部分是 O(n).每处理一个元素时，最多需要向根部方向交换 logn 次。因此总的时间复杂度是 O(nlogn)
[proof](<https://en.wikipedia.org/wiki/Heap_(data_structure)>)

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

method2:
算法思路：
初始选择最接近叶子的一个父结点，与其两个儿子中较小的一个比较，若大于儿子，则与儿子交换。
交换后再与新的儿子比较并交换，直至没有儿子。
再选择较浅深度的父亲结点，重复上述步骤。
时间复杂度分析
这个版本的算法，乍一看也是 O(nlogn)， 但是我们仔细分析一下，算法从第 n/2 个数开始，倒过来进行 siftdown。也就是说，相当于从 heap 的倒数第二层开始进行 siftdown 操作，倒数第二层的节点大约有 n/4 个， 这 n/4 个数，最多 siftdown 1 次就到底了，所以这一层的时间复杂度耗费是 O(n/4)，然后倒数第三层差不多 n/8 个点，最多 siftdown 2 次就到底了。所以这里的耗费是 O(n/8\*2), 倒数第 4 层是 O(n/16\*3)，倒数第 5 层是 O(n/32\*4) ... 因此累加所有的时间复杂度耗费为：
T(n) = O(n/4) + O(n/8\*2) + O(n/16\*3) ...
然后我们用 2T - T 得到：
2\*T(n) = O(n/2) + O(n/4\*2) + O(n/8\*3) + O(n/16\*4) ...
T(n) = O(n/4) + O(n/8\*2) + O(n/16\*3) ...
2\*T(n) - T(n) = O(n/2) +O (n/4) + O(n/8) + ...
= O(n/2 + n/4 + n/8 + ... )
= O(n)
因此得到 T(n) = 2\*T(n) - T(n) = O(n)

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

- 堆排序
  运用堆的性质，我们可以得到一种常用的、稳定的、高效的排序算法————堆排序。堆排序的时间复杂度为 O(n\*log(n))，空间复杂度为 O(1)，堆排序的思想是：对于含有 n 个元素的无序数组 nums, 构建一个堆(这里是小顶堆)heap，然后执行 extractMin 得到最小的元素，这样执行 n 次得到序列就是排序好的序列。
  如果是降序排列则是小顶堆；否则利用大顶堆。

  Trick
  由于 extractMin 执行完毕后，最后一个元素 last 已经被移动到了 root，因此可以将 extractMin 返回的元素放置于最后，这样可以得到 sort in place 的堆排序算法。
  当然，如果不使用前面定义的 heap，则可以手动写堆排序，由于堆排序设计到建堆和 extractMin， 两个操作都公共依赖于 siftDown 函数，因此我们只需要实现 siftDown 即可。(trick:由于建堆操作可以采用 siftUp 或者 siftDown，而 extractMin 是需要 siftDown 操作，因此取公共部分，则采用 siftDown 建堆)。

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

# Chapter 20: 刷人利器深度优先搜索

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_20._刷人利器深度优先搜索.pdf)

# Chapter 21: 高频数据结构哈希表与堆

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_21._高频数据结构哈希表与堆.pdf)

# Chapter 22: 从搜索到动规记忆化搜索入门

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_22._从搜索到动规记忆化搜索入门.pdf)

# Chapter 23: 动态规划入门与动规四要素

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_23._动态规划入门与动规四要素.pdf)

# Chapter 24: 动态规划使用场景与题型分类

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_24._动态规划使用场景与题型分类.pdf)

# Chapter 25: 背包型动态规划入门

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_25._背包型动态规划入门1.pdf)

# Chapter 26: 让面试官眼前一亮的算法——记忆化搜索

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_26.%20让面试官眼前一亮的算法——记忆化搜索.pdf)
