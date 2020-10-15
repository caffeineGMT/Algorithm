<!-- markdownlint-disable MD025-->

# Algorithm Note

This is a repo recording any important note or thought when learning Algorithm. Most of the note/solution will be based on JiuZhang Algorithm Series.

# Chapter 1: intro

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_1._FB面试官揭秘面试速成技巧_-_怎样做到_Bug_Free_和刷100题刷300题.pdf)

# Chapter 2: interview case analysis

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

# Chapter 3: interview case analysis

# Chapter 4: complexity

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

# Chapter 5: 2 sort algorithm

| feature   | quick sort                   | merge sort |
| --------- | ---------------------------- | ---------- |
| time      | average: O(nlgn) worst: O(n) | O(nlgn)    |
| space     | O(1)                         | O(n)       |
| stability | \*not stable                 | stable     |

# Chapter 6: bisection/dichotomy algorithm

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

# Chapter 7: bisection/dichotomy algorithm template

- [template](../JiuZhangAlgorithm2020/week2/BinarySearchTemplate.java)

# Chapter 8: two pointers

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_8._高频算法之王双指针算法之相向双指针.pdf)

# Chapter 9: bisection/dichotomy algorithm

- see [slide](../JiuZhangAlgorithm2020/CoursePDF/Chapter_9._简约而不简单二分法的四重境界.pdf)

# Chapter 10: queue

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
