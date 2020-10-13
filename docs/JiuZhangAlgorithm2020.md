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
| stability | not stable                   | stable     |

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
