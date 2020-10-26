<!-- markdownlint-disable MD025-->

# Algorithm Note

This is a repo recording any important note or thought when learning Algorithm. Most of the note/solution will be based on JiuZhang Algorithm Series.

# Chapter 1: FB 面试官揭秘算法面试速成技巧 - 怎样做到 Bug Free 和刷 100 题等于别人刷 300 题

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_1._FB面试官揭秘面试速成技巧_-_怎样做到_Bug_Free_和刷100题刷300题.pdf)

# Chapter 2: 真实面试案例分析（上）与面试评分标准

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
