<!-- markdownlint-disable MD025-->

# Algorithm Note

This is a repo recording any important note or thought when learning Algorithm. Most of the note/solution will be based on MOOC course "Code with Mosh" Algorithm Series.

# Searching Algorithm

- binary search: 
  | operation | recursive | iterative |
  | --------- | --------- | --------- |
  | time      | O(lgn)    | O(lgn)    |
  | space     | O(lgn)    | O(1)      |

- ternary search: slower than binary search
  | operation | recursive | iterative |
  | --------- | --------- | --------- |
  | time      | O(lg3 n)  | O(lg3 n)  |
  | space     | O(lg3 n)  | O(1)      |

- jump search:
- exponential search:

# Sorting Algorithm

- bubble sort: 
  | operation  | best | worst  |
  | ---------- | ---- | ------ |
  | iteration  | O(n) | O(n)   |
  | shift item | O(1) | O(n)   |
  | total      | O(n) | O(n^2) |
- selection sort:
  | operation  | best   | worst  |
  | ---------- | ------ | ------ |
  | iteration  | O(n)   | O(n)   |
  | shift item | O(n)   | O(n)   |
  | total      | O(n^2) | O(n^2) |
- insertion sort: 
  | operation  | best | worst  |
  | ---------- | ---- | ------ |
  | iteration  | O(n) | O(n)   |
  | shift item | O(1) | O(n)   |
  | total      | O(n) | O(n^2) |
- quick sort: 
  | operation              | best    | worst  |
  | ---------------------- | ------- | ------ |
  | work in each partition | O(n)    | O(n)   |
  | partition times        | O(lgn)  | O(n)   |
  | total                  | O(nlgn) | O(n^2) |
  | space                  | O(lgn)  | O(n)   |
- counting sort: 
  | operation        |                                                          |
  | ---------------- | -------------------------------------------------------- |
  | populating count | O(n)                                                     |
  | iterate count    | O(k)                                                     |
  | total            | O(n)                                                     |
  | space            | O(k) (k is the maximum value in the domain of the array) |
  - when to use: 
    - allocating extra space is not a issue
    - values are positive integers
    - most of the value in the range are present
- bucket sort: 
  | operation      | best                           | worst  |
  | -------------- | ------------------------------ | ------ |
  | distribution   | O(n)                           | O(n)   |
  | iterate bucket | O(k)                           | O(k)   |
  | sorting        | O(1)                           | O(n^2) |
  | total          | O(n+k)                         | O(n^2) |
  | space          | O(n+k) (k is number of bucket) | O(n+k) |

# Undirected Graph

-

# Graph

- app: network connection, social media, path finding
- basic concept:
  - vertex: V/n
  - edge: E/m
  - incident edges: immediate edges connecting to a node
  - degree of node: how many incident node
  - adjacent node/vertices
  - path: sequence of vertices connect by edges
  - cycle: path with a common start and end
  - simple graph: no self loop or multi-edges
  - directed graph
  - undirected graph
- edges numbers:
  - min edges for a graph:
    - not connected:0
    - connected: n-1
  - max edges for a graph:
    - simple: n\*(n-1)
    - not simple:infinity
  - sum of degree in a graph: 2m (because every inbound edge will have a corresponding outbound edge)
- edge list(simple graph):one hash table maintain node, one hash table maintain edges

| operation                         | time complexity                                            |
| --------------------------------- | ---------------------------------------------------------- |
| space                             | O(n+m)(n node in hash table & total m edges in hash table) |
| insertVertex(K key)               | O(1)(hash table lookup)                                    |
| removeVertex(Vertex v)            | O(m)(hash table lookup, walk thru every edge)              |
| areAdjacent(Vertex v1, Vertex v2) | O(m)(walk thru every edge)                                 |
| incidentEdges(Vertex)             | O(m)(hash table lookup, walk thru every edge)              |
| addEdge                           | O(1)(hash table lookup)                                    |
| removeEdge                        | O(1)(hash table lookup)                                    |

- adjacency matrix(simple graph):one hash table maintain node, one 2D array maintain edges

| operation                         | time complexity                                     |
| --------------------------------- | --------------------------------------------------- |
| space                             | O(n^2)(n node in hash table & n by n 2D matrix)     |
| insertVertex(K key)               | O(n^2)(need to copy the whole matrix)               |
| removeVertex(Vertex v)            | O(n^2)(need to shrink the whole matrix)             |
| areAdjacent(Vertex v1, Vertex v2) | O(1)(hash table lookup)                             |
| incidentEdges(Vertex)             | O(n)(hash table look up & walk down one row/column) |
| addEdge                           | O(1)(hash table lookup,turn 0 to 1)                 |
| removeEdge                        | O(1)(hash table lookup,turn 1 to 0)                 |

- adjacency list(simple graph):one hash table maintain node, one array of linked list maintain edges

| operation                         | time complexity                                          |
| --------------------------------- | -------------------------------------------------------- |
| space                             | O(n+m)(n node in hash table & m edges in linked list)    |
| insertVertex(K key)               | O(1)(hash table lookup)                                  |
| removeVertex(Vertex v)            | O(deg(V))(hash table lookup, link lookup, relink)        |
| areAdjacent(Vertex v1, Vertex v2) | O(min(deg(V1),deg(V2)))(hash table lookup, link lookup)  |
| incidentEdges(Vertex)             | O(deg(V))(hash table lookup, link lookup)                |
| addEdge                           | O(deg(V))(hash table lookup, check duplicates, add link) |
| removeEdge                        | O(deg(V))(hash table lookup, link lookup)                |

- for dense graph, try to use adjacency matrix, otherwise use adjacency list
- topological sort: 
  - definition: a topological sort or topological ordering of a directed graph is a linear ordering of its vertices such that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering. For instance, the vertices of the graph may represent tasks to be performed, and the edges may represent constraints that one task must be performed before another; in this application, a topological ordering is just a valid sequence for the tasks.
  - app: dependency check; prerequisite course; ranking
  - directed acyclic graph
  - O(n) runtime complexity

# Tries

| operation | time complexity |
| --------- | --------------- |
| lookup    | O(L)            |
| insert    | O(L)            |
| delete    | O(L)            |

- app: auto-completion
- tries concept:
  - tries is not binary tree. It can have multiple children
  - for word search/insertion/deletion, it need to do `L` operation, where `L` stands for the number of characters in the word.
  - tries' root node is empty

# Heaps

| insert(bubble up) | delete (bubble down ) | find max/min | heapify | heap sort (create then delete) |
| ----------------- | --------------------- | ------------ | ------- | ------------------------------ |
| O(log n)          | O(log n)              | O(1)         | O(n)    | nlgn+nlgn -> O(nlgn)           |

- requirement:
  - complete tree: 2 children for each node, and has to be on the same level until last level, and at last level all nodes being pushed to the left
  - heap property: parent node is smaller than children node (min-heap)/parent node is bigger than children node (max-heap)
- type:max heap, min heap,binary heap
- app:heapSort;shortest path;priority queue;finding Kth smallest/largest value
- implementation notes:
  - implementation data structure: array
  - insert: add item in order in array, when there is an item not following the heap property, we should bubble up this item, which is swapping this item with its parent until it follows heap property
  - delete: when deleting the root node, we need to do bubble down operation, which is bringing the last node to the vacant position, and bubble down the node at that new location until we satisfy heap property
  - find max/min: the root node value is the max/min
  - parent/children index formula: 
    - leftIndex=parentIndex*2+1
    - rightIndex=parentIndex*2+2
    - parentIndex=(childIndex-1)/2

# AVL Tree

# Tree

good binary search tree:

| insert   | lookup   | delete   |
| -------- | -------- | -------- |
| O(log n) | O(log n) | O(log n) |

bad tree:

| insert   | lookup   | delete   |
| -------- | -------- | -------- |
| O(log n) | O(log n) | O(log n) |

- app: representing hierarchical data, databases, autocompletion, compilers, compression
- BST cannot have duplicated value inside true, the child is either smaller or larger than parent node, cannot be equal.
- full binary tree: binary tree is a full binary tree if every node has 0 or 2 children. In a Full Binary Tree, number of leaf nodes is the number of internal nodes plus 1. L = I + 1, where L = Number of leaf nodes, I = Number of internal nodes with 2 children
- complete binary tree: binary tree is a complete binary tree if all the levels are completely filled except possibly the last level and the last level has all keys as left as possible
- perfect binary tree: a binary tree is a perfect binary tree in which all the internal nodes have two children and all leaf nodes are at the same level. A Perfect Binary Tree of height h (where height is the number of nodes on the path from the root to leaf) has (2^(h+1)) – 1 node.
- balanced binary tree: a binary tree is balanced if the height of the tree is O(Log n) where n is the number of nodes. For Example, the AVL tree maintains O(Log n) height by making sure that the difference between the heights of the left and right subtrees is almost 1. Red-Black trees maintain O(Log n) height by making sure that the number of Black nodes on every root to leaf paths is the same and there are no adjacent red nodes. Balanced Binary Search trees are performance-wise good as they provide O(log n) time for search, insert and delete.
- degenerate tree: a tree where every internal node has one child. Such trees are performance-wise same as linked list.
- traversal:
  - Breadth First
  - Depth First:
    - pre-order(root,left,right), walk thru parent first, then its leaf nodes
    - in-order(left,root,right): the traversal result is incremental/decremental
    - post-order(left,right,root): walk thru leaf node first, then its parent
- depth and height:
  - depth of node: calculating the number of edges for a node from top-down
  - height of sub tree: calculating the number of edges for a node from bottom-up

# Hash Table

| insert | lookup | delete |
| ------ | ------ | ------ |
| O(1)   | O(1)   | O(1)   |

- app: spell checker,dictionary, compiler, code editor
- worst case: O(n)
- collision: when 2 key are generating the same hashed value thru hash function
  - chaining: using linked list
  - open addressing:
    - linear probing: `(hash(key)+i)%sizeOfArray`. hash(key) will be a number. if the slot is not empty, we increment by 1, which is represented by i. In order to bound the boundary of (hash(key)+i), we introduce modular operator to bound it by the size of array, otherwise it might be out of index boundary of the array. This method can result in clustering.
    - quadratic probing:`(hash(key)+i^2)%sizeOfArray`. because we are doing big jumps in array, we might end up looping back to previous step and being trapped in an infinite loop.
    - double hashing:`(hash1(key)+i*hash2(key))%sizeOfArray`. `hash2(key)=prime-(key%prime)`. prime is a number smaller than size of array.Example: array size is 5, prime number is 3. hash1(11)=11%5=1.Let's say index at 1 has a collision. hash2(11)=3-(11%3)=1. hash(11)=(1+1\*1)%5=2. We should try if array at index 2 is available. If not, increment i by 1, so hash(11)=(1+2\*1)%5=3

# Queue

| enqueue | dequeue | peek | inEmpty | isFull |
| ------- | ------- | ---- | ------- | ------ |
| O(1)    | O(1)    | O(1) | O(1)    | O(1)   |

- app: printer,operating system, web servers, live support system

# Stack

| push | pop  | peek | isEmpty |
| ---- | ---- | ---- | ------- |
| O(1) | O(1) | O(1) | O(1)    |

- app: undo feature, syntax checking in compiler, evaluate math expression, build navigation(forward/back)
- can be implemented by array, arraylist or linked list internally

# Linked List

| lookup                 | insert                            | delete                  |
| ---------------------- | --------------------------------- | ----------------------- |
| index: O(n) value:O(n) | start:O(1) middle: O(n) end: O(1) | singly:O(n) doubly:O(1) |

- LinkedList from java.util package could be `LinkedList generic = new LinkedList();`. In this case, one node could host String, another node could host Integer
- type:
  - singly: O(n) on deleting the end item
  - doubly: O(1) on deleting the end item
  - circular: song playlist loop,

# Array

| lookup by index | lookup by value | insert | delete               |
| --------------- | --------------- | ------ | -------------------- |
| O(1)            | O(n)            | O(n)   | worst:O(n) best:O(1) |

- ArrayList: grow 50% everytime it's full. not synchronized, multi thread
- Vector: grow 100% everytime it's full. synchronize, single thread

# Big O notation

- runtime complexity: O(1),O(n),O(n^2),O(log n), O(2^n)
- space complexity: always look at additional space needs to be allocated, don't count size of the input
