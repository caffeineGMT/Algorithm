<!-- markdownlint-disable MD025-->

# Note

This is a repo recording notes for method and implementation of frequently used built-in Java class.

# Package

- java.util.\*
- java.lang.\*

# Array

- [documentation](https://docs.oracle.com/javase/specs/jls/se7/html/jls-10.html)
- `public final field length`
  - contains the number of components of the array. length may be positive or zero.

# Stack

The Stack class represents a last-in-first-out (LIFO) stack of objects. It extends class Vector with five operations that allow a vector to be treated as a stack. The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, a method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it is from the top.
When a stack is first created, it contains no items.

A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, which should be used in preference to this class. For example:

`Deque<Integer> stack = new ArrayDeque<Integer>();`

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Stack.html)
- `public boolean isEmpty()`
  - Tests if this stack is empty.
- `public E peek()`
  - Looks at the object at the top of this stack without removing it from the stack.
- `public E push​(E item)`
  - Pushes an item onto the top of this stack.
- `public E pop()`
  - Removes the object at the top of this stack and returns that object as the value of this function.

# Queue

A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue implementations; in most implementations, insert operations cannot fail.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html)

# Deque

A linear collection that supports element insertion and removal at both ends. The name deque is short for "double ended queue" and is usually pronounced "deck". Most Deque implementations place no fixed limits on the number of elements they may contain, but this interface supports capacity-restricted deques as well as those with no fixed size limit.

This interface defines methods to access the elements at both ends of the deque. Methods are provided to insert, remove, and examine the element. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Deque implementations; in most implementations, insert operations cannot fail.

This interface extends the Queue interface. When a deque is used as a queue, FIFO (First-In-First-Out) behavior results. Elements are added at the end of the deque and removed from the beginning.

Deques can also be used as LIFO (Last-In-First-Out) stacks. This interface should be used in preference to the legacy Stack class. When a deque is used as a stack, elements are pushed and popped from the beginning of the deque.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html)

# ArrayDeque

Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions; they grow as necessary to support usage. Null elements are prohibited. This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
Most ArrayDeque operations run in amortized constant time. Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), and the bulk operations, all of which run in linear time.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayDeque.html)
- `public int size()`
  - Returns the number of elements in this deque.
- `public boolean isEmpty()`
  - Returns true if this deque contains no elements.
- `public E peek()`
  - Retrieves, but does not remove, the head of the queue represented by this deque, or returns null if this deque is empty.
- `public boolean offer​(E e)`
  - Inserts the specified element at the end of this deque.
- `public E poll()`
  - Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
- `public void push​(E e)`
  - Pushes an element onto the stack represented by this deque.
- `public E pop()`
  - Pops an element from the stack represented by this deque.

# List

An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.

Unlike sets, lists typically allow duplicate elements. More formally, lists typically allow pairs of elements e1 and e2 such that e1.equals(e2), and they typically allow multiple null elements if they allow null elements at all. It is not inconceivable that someone might wish to implement a list that prohibits duplicates, by throwing runtime exceptions when the user attempts to insert them, but we expect this usage to be rare.

The List interface provides four methods for positional (indexed) access to list elements. Lists (like Java arrays) are zero based. Note that these operations may execute in time proportional to the index value for some implementations (the LinkedList class, for example). Thus, iterating over the elements in a list is typically preferable to indexing through it if the caller does not know the implementation.

The List interface provides two methods to search for a specified object. From a performance standpoint, these methods should be used with caution. In many implementations they will perform costly linear searches.

The List interface provides two methods to efficiently insert and remove multiple elements at an arbitrary point in the list.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html)

# ArrayList

Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally to store the list.

The size, isEmpty, get, set, iterator, and listIterator operations run in constant time. The add operation runs in amortized constant time, that is, adding n elements requires O(n) time. All of the other operations run in linear time (roughly speaking). The constant factor is low compared to that for the LinkedList implementation.

Each ArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list. It is always at least as large as the list size. As elements are added to an ArrayList, its capacity grows automatically. The details of the growth policy are not specified beyond the fact that adding an element has constant amortized time cost.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
- `public int size()`
  - Returns the number of elements in this list.
  - doesn't have capacity field
- `public boolean isEmpty()`
  - Returns true if this list contains no elements.
- `public boolean add​(E e)`
  - Appends the specified element to the end of this list.
- `public E get(int index)`
  - Returns the element at the specified position in this list.
- `public E set(int index, E element)`
  - Replaces the element at the specified position in this list with the specified element.
- `public E remove(int index)`
  - Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
  - if remove the last item, there wont be any shift, it is O(1). If remove the first item, it is O(n)
- `public boolean isEmpty()`
  - Returns true if this list contains no elements.

# LinkedList

Doubly-linked list implementation of the List and Deque interfaces. Implements all optional list operations, and permits all elements (including null).

All of the operations perform as could be expected for a doubly-linked list. Operations that index into the list will traverse the list from the beginning or the end, whichever is closer to the specified index.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html)
- `public int size()`
  - Returns the number of elements in this list.
- `public boolean isEmpty()`
  - Returns true if this collection contains no elements.
- `public E peek()`
  - Retrieves, but does not remove, the head (first element) of this list.
- `public boolean offer​(E e)`
  - Adds the specified element as the tail (last element) of this list.
- `public E poll()`
  - Retrieves and removes the head (first element) of this list.
- `public void push​(E e)`
  - Pushes an element onto the stack represented by this list. In other words, inserts the element at the front of this list.
- `public E pop()`
  - Pops an element from the stack represented by this list. In other words, removes and returns the first element of this list.
- `public E get​(int index)`
  - Returns the element at the specified position in this list.
  - O(n) worst case
- `public E set​(int index, E element)`
  - Replaces the element at the specified position in this list with the specified element.
  - O(n) worst case

# Set

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html)

# HashSet

This class implements the Set interface, backed by a hash table (actually a HashMap instance). It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. This class permits the null element.

This class offers constant time performance for the basic operations (add, remove, contains and size), assuming the hash function disperses the elements properly among the buckets. Iterating over this set requires time proportional to the sum of the HashSet instance's size (the number of elements) plus the "capacity" of the backing HashMap instance (the number of buckets). Thus, it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html)
- `public int size()`
  - Returns the number of elements in this set (its cardinality).
- `public boolean isEmpty()`
  - Returns true if this set contains no elements.
- `public boolean contains​(Object o)`
  - Returns true if this set contains the specified element. More formally, returns true if and only if this set contains an element e such that Objects.equals(o, e).
- `public boolean add​(E e)`
  - Adds the specified element to this set if it is not already present. More formally, adds the specified element e to this set if this set contains no element e2 such that Objects.equals(e, e2). If this set already contains the element, the call leaves the set unchanged and returns false.
- `public boolean remove​(Object o)`
  - Removes the specified element from this set if it is present. More formally, removes an element e such that Objects.equals(o, e), if this set contains such an element. Returns true if this set contained the element (or equivalently, if this set changed as a result of the call). (This set will not contain the element once the call returns.)

# Map

# HashMap

Hash table based implementation of the Map interface. This implementation provides all of the optional map operations, and permits null values and the null key. This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will remain constant over time.

This implementation provides constant-time performance for the basic operations (get and put), assuming the hash function disperses the elements properly among the buckets. Iteration over collection views requires time proportional to the "capacity" of the HashMap instance (the number of buckets) plus its size (the number of key-value mappings). Thus, it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important.

An instance of HashMap has two parameters that affect its performance: initial capacity and load factor. The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created. The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is rehashed (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.

As a general rule, the default load factor (.75) offers a good tradeoff between time and space costs. Higher values decrease the space overhead but increase the lookup cost (reflected in most of the operations of the HashMap class, including get and put). The expected number of entries in the map and its load factor should be taken into account when setting its initial capacity, so as to minimize the number of rehash operations. If the initial capacity is greater than the maximum number of entries divided by the load factor, no rehash operations will ever occur.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html)
- `public V put​(K key, V value)`
  - Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced.
- `public V get​(Object key)`
  - Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key. More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this method returns v; otherwise it returns null. (There can be at most one such mapping.) A return value of null does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly maps the key to null. The containsKey operation may be used to distinguish these two cases.
- `public boolean containsKey​(Object key)`
  - Returns true if this map contains a mapping for the specified key.
- `public Set<K> keySet()`
  - Returns a Set view of the keys contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation), the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll, and clear operations. It does not support the add or addAll operations.
- `public Set<Map.Entry<K,​V>> entrySet()`

  - Returns a Set view of the mappings contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation, or through the setValue operation on a map entry returned by the iterator) the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll and clear operations. It does not support the add or addAll operations.
  - [document for entry](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.Entry.html)

- `public V remove(Object key)`
  Removes the mapping for the specified key from this map if present.

# TreeNode

# PriorityQueue

# Arrays - java.util.Arrays

This class contains various methods for manipulating arrays (such as sorting and searching). This class also contains a static factory that allows arrays to be viewed as lists.
The methods in this class all throw a NullPointerException, if the specified array reference is null, except where noted.

The documentation for the methods contained in this class includes brief descriptions of the implementations. Such descriptions should be regarded as implementation notes, rather than parts of the specification. Implementors should feel free to substitute other algorithms, so long as the specification itself is adhered to. (For example, the algorithm used by sort(Object[]) does not have to be a MergeSort, but it does have to be stable.)

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html)
- `public static void sort​(int[] a)`
  - Sorts the specified array into ascending numerical order.
  - Implementation note: The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts to degrade to quadratic performance, and is typically faster than traditional (one-pivot) Quicksort implementations.

# String

The String class represents character strings. All string literals in Java programs, such as "abc", are implemented as instances of this class.

Strings are constant; their values cannot be changed after they are created. String buffers support mutable strings. Because String objects are immutable they can be shared.

- [documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)
- `public int length()`
  - Returns the length of this string. The length is equal to the number of Unicode code units in the string.
- `public char charAt​(int index)`
  - Returns the char value at the specified index. An index ranges from 0 to length() - 1. The first char value of the sequence is at index 0, the next at index 1, and so on, as for array indexing.
- `public static String valueOf(int i)`
  - Returns the string representation of the int argument
- `public String concat​(String str)`
  - Concatenates the specified string to the end of this string.
    If the length of the argument string is 0, then this String object is returned. Otherwise, a String object is returned that represents a character sequence that is the concatenation of the character sequence represented by this String object and the character sequence represented by the argument string.
  - returned String object is a new String, it won't change the old immutable String
- `public String replace​(CharSequence target, CharSequence replacement)`
  - Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence. The replacement proceeds from the beginning of the string to the end, for example, replacing "aa" with "b" in the string "aaa" will result in "ba" rather than "ab".
  - returned String object is a new String, it won't change the old immutable String
- `public boolean contains​(CharSequence s)`
  - Returns true if and only if this string contains the specified sequence of char values.
- `public String toUpperCase()`
  - Converts all of the characters in this String to upper case using the rules of the default locale.
- `public String toLowerCase()`
  - Converts all of the characters in this String to lower case using the rules of the default locale.
- `public char[] toCharArray()`
  - Converts this string to a new character array.
- `public String substring​(int beginIndex, int endIndex)`
  - Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
  - beginIndex - the beginning index, inclusive.
  - endIndex - the ending index, exclusive.
- `public String trim()`
  Returns a string whose value is this string, with all leading and trailing space removed, where space is defined as any character whose codepoint is less than or equal to 'U+0020' (the space character).If this String object represents an empty character sequence, or the first and last characters of character sequence represented by this String object both have codes that are not space (as defined above), then a reference to this String object is returned. Otherwise, if all characters in this string are space (as defined above), then a String object representing an empty string is returned.Otherwise, let k be the index of the first character in the string whose code is not a space (as defined above) and let m be the index of the last character in the string whose code is not a space (as defined above). A String object is returned, representing the substring of this string that begins with the character at index k and ends with the character at index m-that is, the result of this.substring(k, m + 1).
- `public boolean equals​(Object anObject)`
  - Compares this string to the specified object. The result is true if and only if the argument is not null and is a String object that represents the same sequence of characters as this object.
  - testing if 2 items are the same instance first, if not, testing if they have the same content
  - `==` will only test if 2 items are the same instance, which is comparing the memory address
- `public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)`
  Returns a new String composed of copies of the CharSequence elements joined together with a copy of the specified delimiter.
- `public static String valueOf(int i)`
  - Returns the string representation of the int argument.
  - "" + int = String

# StringBuilder

- `public boolean equals​(Object obj)`
  - For any non-null reference value x, x.equals(null) should return false.
    The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).
  - `==` is the same as `equals`
- `public StringBuilder append(String str)`
  Appends the specified string to this character sequence.
  The characters of the String argument are appended, in order, increasing the length of this sequence by the length of the argument. If str is null, then the four characters "null" are appended.
  Let n be the length of this character sequence just prior to execution of the append method. Then the character at index k in the new character sequence is equal to the character at index k in the old character sequence, if k is less than n; otherwise, it is equal to the character at index k-n in the argument str.

- `public StringBuilder append(char c)`
  Appends the string representation of the char argument to this sequence.
  The argument is appended to the contents of this sequence. The length of this sequence increases by 1.The overall effect is exactly as if the argument were converted to a string by the method String.valueOf(char), and the character in that string were then appended to this character sequence.

- `public String toString()`
  Returns a string representing the data in this sequence. A new String object is allocated and initialized to contain the character sequence currently represented by this object. This String is then returned. Subsequent changes to this sequence do not affect the contents of the String.

# Integer

- [documentation](https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html)
- `public static int parseInt(String s)`
  Parses the string argument as a signed decimal integer. The characters in the string must all be decimal digits, except that the first character may be an ASCII minus sign '-' ('\u002D') to indicate a negative value or an ASCII plus sign '+' ('\u002B') to indicate a positive value. The resulting integer value is returned, exactly as if the argument and the radix 10 were given as arguments to the parseInt(java.lang.String, int) method.
- `public static final int MAX_VALUE`
  A constant holding the maximum value an int can have, 2^31-1.
- `public static final int MIN_VALUE`
  A constant holding the minimum value an int can have, -231.

# Character

- [documentation](https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html)
- `public static char toLowerCase(char ch)`
  Converts the character argument to lowercase using case mapping information from the UnicodeData file.
  Note that Character.isLowerCase(Character.toLowerCase(ch)) does not always return true for some ranges of characters, particularly those that are symbols or ideographs.
- `public static boolean isDigit(char ch)`
  Determines if the specified character is a digit.
- `public static boolean isLetter(char ch)`
  Determines if the specified character is a letter.

# Collections

- [documentation](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html)
- `public static void reverse(List<?> list)`
  Reverses the order of the elements in the specified list.
  This method runs in linear time.

# Math

- [documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#max-int-int-)
- `public static int max(int a, int b)`
  Returns the greater of two int values. That is, the result is the argument closer to the value of Integer.MAX_VALUE. If the arguments have the same value, the result is that same value.
- `public static int min(int a, int b)`
  Returns the smaller of two int values. That is, the result the argument closer to the value of Integer.MIN_VALUE. If the arguments have the same value, the result is that same value.

# Object

- `public boolean equals​(Object obj)`
  - For any non-null reference value x, x.equals(null) should return false.
    The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).
  - `==` is the same as `equals`
