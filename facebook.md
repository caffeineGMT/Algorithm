# Facebook Phone

Coded

* [x] Toeplitz Matrix
* [x] Minimum Remove to Make Valid Parentheses 
* [x] Merge Sorted Array
* [x] Implement Trie \(Prefix Tree\)   
* [x] Find First and Last Position of Element in Sorted Array
* [x] Kth Smallest Element in a BST
* [x] LRU Cache
* [x] Add Strings
* [x] K Closest Points to Origin 
* [x] Binary Search Tree Iterator
* [x] Minimum Cost For Tickets
* [x] All Nodes Distance K in Binary Tree
* [x] Pow\(x, n\) \(decimal\)
* [x] Trapping Rain Water 
* [x] merge k sorted array \([https://www.lintcode.com/problem/486/](https://www.lintcode.com/problem/486/)\)
* [x] Diameter of Binary Tree
* [x] Subarray Sum Equals K
* [x] LCA I II III
* [ ] Dot Product of Two Sparse Vectors \(binary search?\)
* [x] Compare strings stored in two Linked Lists
* [x] Palindrome Permutation
* [x] Merge k Sorted Lists
* [x] Remove Invalid Parentheses
* [x] Serialize and Deserialize Binary Tree
* [x] Expression Add Operators 
* [x] Integer to English Words
* [ ] Sliding Window Maximum
* [x] Find Minimum in Rotated Sorted Array I, II
* [x] Word Break II
* [x] Word Break
* [x] Word Ladder
* [x] Word Ladder II
* [x] Longest Valid Parentheses
* [x] Longest Substring with At Most K Distinct Characters
* [ ] Longest Increasing Path in a Matrix
* [x] Longest Palindromic Substring
* [x] String Compression 
* [x] Leftmost Column with at Least a One
* [x] Minimum Knight Moves 
* [x] Two City Scheduling
* [x] Max Consecutive Ones I, II, III
* [x] Vertical Order Traversal of a Binary Tree 
* [x] Interval List Intersections 
* [x] Squares of a Sorted Array 
* [x] Check Completeness of a Binary Tree
* [x] Verifying an Alien Dictionary 
* [x] Range Sum of BST
* [x] Minimum Add to Make Parentheses Valid
* [x] Is Graph Bipartite
* [x] Valid Palindrom I
* [x] Valid Palindrome II
* [x] Average of Levels in Binary Tree 
* [x] Friend Circles \(number of provinces\)
* [x] Single Element in a Sorted Array
* [x] Random Pick with Weight
* [x] Diagonal Traverse
* [x] Validate IP Address
* [x] Find All Anagrams in a String
* [x] Valid Word Abbreviation
* [x] Kth Smallest Element in a Sorted Matrix
* [x] Design Tic-Tac-Toe 
* [x] Nested List Weight Sum
* [x] Largest BST Subtree 
* [ ] Coin Change 
* [x] First Bad Version
* [x] Basic Calculator II
* [x] Kth Largest Element in an Array
* [x] Design Add and Search Words Data Structure
* [x] Course Schedule II
* [x] Number of Islands
* [x] Missing Ranges
* [x] Min Stack 
* [ ] Copy List with Random Pointer
* [x] Single Number
* [x] Binary Tree Maximum Path Sum
* [x] Flatten Binary Tree to Linked List
* [x] Validate Binary Search Tree
* [ ] Reverse Linked List II
* [x] Sqrt\(x\) \(need to watch out int overflow\)
* [x] Add Binary
* [x] Insert Interval
* [x] Merge Intervals
* [x] Combination Sum II
* [x] Combination Sum
* [x] Divide Two Integers
* [x] Search in Rotated Sorted Array I, II
* [x] Product of Array Except Self
* [x] Binary Tree Right Side View
* [ ] Remove All Adjacent Duplicates In String 
* [x] Convert Binary Search Tree to Sorted Doubly Linked List
* [x] Convert Sorted Array to Binary Search Tree
* [x] Convert Sorted List to Binary Search Tree
* [x] Max Area of Island
* [ ] Making A Large Island
* [x] Backspace String Compare
* [x] Intersection of Three Sorted Arrays
* [x] Maximum Swap
* [x] Construct Binary Tree from String
* [x] Top K Frequent Elements
* [x] Valid Number

Task

* [ ] Palindrome Linked List
* [ ] Count and Say
* [ ] Swim in Rising Water 
* [ ] Strobogrammatic Number 
* [ ] Distinct Subsequences II
* [ ] Is Subsequence
* [ ] Shortest Subarray to be Removed to Make Array Sorted
* [ ] Maximum Difference Between Node and Ancestor 
* [ ] Lowest Common Ancestor of Deepest Leaves
* [ ] Complete Binary Tree Inserter
* [ ] Goat Latin 
* [ ] Surrounded Regions
* [ ] Binary Subarrays With Sum 
* [ ] Longest Continuous Increasing Subsequence
* [ ] Regular Expression Matching
* [ ] Read N Characters Given Read4 II - Call multiple times
* [ ] Remove Element
* [ ] Task Scheduler

 

```java
Welcome to Facebook!

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you would like to use for your interview,
simply choose it from the dropdown in the top bar.

Enjoy your interview!
  
  Hello World
  
Question Statement
Input: ((( Output: 3
Input: ()) Output: 1
Input: (()) Output: 0
Input: )( Output: 2

The first input is missing 3 closing parentheses, so the output should be 3. 
The second input is missing an opening parentheses at the beginning, so the output is 1. 
The third input is perfectly balanced, so the output is 0. 
The last input is unbalanced despite having equal number of each parentheses, so the output is 2.
         
public int count(String str) {
  if (str == null || str.length() == 0) return 0;
  
  int l = 0, r = 0;
  
  for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (ch == '(') {
      l++;
    } else if (ch == ')' && l > 0) {
      l--;
    } else {
      r++;
    }
  }
  
  return l + r;
}
         
Area of a large island

Find the maximum area of an island when you are allowed to flip one 0 to 1.

Input:
[[1, 0],
 [0, 1],
 [1, 1]]
Output: 5
Reason: Change 0 at (0, 1) to 1 and we get an island with area = 5

Input:
[[1, 1, 1],
 [1, 1, 1]]
Output: 6
Explanation: There are no 0's and one island with area = 6

public int maxArea(int[][] matrix) {
  if (matrix == null) return 0;
  
  // O(m * n)
  UnionFind uf = new UnionFind();
  int m = matrix.length, n = matrix[0].length;
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (matrix[i][j] == 0) continue;
      // O(1) for union find add
      uf.add(i * n + j);
    }
  }
  
  int[] dx = { -1, 1, 0, 0 };
  int[] dy = { 0, 0, -1, 1 };
  
  // O(m * n)
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (matrix[i][j] == 0) continue;
      for (int k = 0; k < 4; k++) {
        int nx = i + dx[k], ny = j + dy[k];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == 0) continue;
        uf.union(i * n + j, nx * n + ny);
      }
    }
  }
  
  int max = 0;
  
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (matrix[i][j] == 1) continue;
      
      int area = 1;
      Set<Integer> set = new HashSet<>();
      for (int k = 0; k < 4; k++) {
        int nx = i + dx[k], ny = j + dy[k];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == 0) continue;
        int p = uf.find(nx * n + ny);
        if (set.contains(p)) continue;
        area += uf.sizeMap.get(p);
        set.add(p);
      }
      
      max = Math.max(max, area);
    }
  }
  
  if (max == 0) return m * n;
  
  return max;
  
  // O(m * n) 
}  
```

