<!-- markdownlint-disable MD025-->

# Algorithm Note

This is a repo recording any important note or thought when learning Algorithm. Most of the note/solution will be based on MOOC course "Code with Mosh" Algorithm Series.

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

# Tries

# Heaps

- requirement:
  - complete tree:
  - heap property
- type:max heap, min heap,binary heap
- app:heapSort;shortest path;priority queue;finding Kth smallest/largest value

# AVL Tree

# Tree

good binary search tree:
| insert | lookup | delete |
| -------- | -------- | -------- |
| O(log n) | O(log n) | O(log n) |

bad tree:
| insert | lookup | delete |
| -------- | -------- | -------- |
| O(log n) | O(log n) | O(log n) |

- app: representing hierarchical data, databases, autocompletion, compilers, compression
- BST cannot have duplicated value inside true, the child is either smaller or larger than parent node, cannot be equal.
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
