# Amazon OA

## Transaction Logs

A startup that builds a chat app wants to identify highly social users. All the chat data is in a large log file with three values on each line - the sender ID, receipient ID, and the number of messages. Given a `threshold` number, find the number of users that appear at least as many times as this threshold.

**For example:**

```text
USERA USERB 14
USERA USERC 94
USERB USERB 3
 ...
```

**Note:** On the third line, a user sents a message to himself.

**Inputs**

`logs` = a list of lines where each line is a string

`threshold` = a number

**Output:**

Return a list of sorted user IDs. If the same user appears in the same line, only count them once.

#### Example:

**Input:**

logs:

```text
345366 899212 45
029323 382391 23
382391 345366 15
029323 382391 77
345366 382391 23
029323 345366 13
382391 382391 23
...
```

threshold: `3`

**Output: \[029323, 345366, 382391\]**

**Explanation:**

There are three users that have appear more than `3` times:

`345366` appears 4 times.

`382391` appears 5 times.

`029323` appears 3 times.  


Solution1:  time: O\(nlgn\). space: O\(n\)

```java
public static List<String> getUserIds(List<String> logs, int threshold) {
    Map<String, Integer> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    for (String log: logs) {
        String[] tokens = log.split("\\s+");
        String a = tokens[0];
        String b = tokens[1];
        if (!map.containsKey(a)) {
            map.put(a, 1);
        } else {
            map.put(a, map.get(a) + 1);
        }
        if (!map.containsKey(b)) {
            map.put(b, 1);
        } else if (map.containsKey(b) && !a.equals(b)) {
            map.put(b, map.get(b) + 1);
        }
    }

    for (String key: map.keySet()) {
        if (map.get(key) >= threshold) {
            result.add(key);
        }
    }

    Collections.sort(result, (String a, String b) -> {
        return a.compareTo(b);
    });

    return result;
}
```

Solution2:

```java
public static List<String> getUserIds(List<String> logs, int threshold) {
    Map<String, Integer> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    for (String log: logs) {
        String[] tokens = log.split("\\s+");
        String a = tokens[0];
        String b = tokens[1];
        map.put(a, map.getOrDefault(a, 0) + 1);
        if (!a.equals(b)) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
    }

    for (String key: map.keySet()) {
        if (map.get(key) >= threshold) {
            result.add(key);
        }
    }

    Collections.sort(result, (String a, String b) -> {
        return a.compareTo(b);
    });

    return result;
}
```

## Optimizing Box Weights

Given a multiset \(set that allows for multiple instances of same value\), partition it into two multisets `A` and `B` such that the sum of `A` is greater than that of `B`. Return `A`. If more than one such `A`s exists, return the one with minimal size.

#### Examples

**Example 1:**

**Input:**

`nums = [4, 5, 2, 3, 1, 2]`

**Output:**

`[4, 5]`

**Explanation:**

We can divide the numbers into two subsets `A = [4, 5]` and `B = [1, 2, 2, 3]`. The sum of A is 9 which is greater than the sum of B which is 8. There are other ways to divide but `A = [4, 5]` is of minimal size of 2.

Solution1: time: O\(nlgn\). space: O\(n\). 

* thoughts: 
  * there might be an issue with this approach. this assume we must put at least 1 item in set. what if we have case like \[4, 4\]? can we make 1 set having \[4, 4\] and the other as \[\]?
  * if so, we need to check if the last sum is == prefix\[0\]

```java
public static List<Integer> optimizingBoxWeights(List<Integer> arr) {
    if (arr == null || arr.size() == 0) {
        return new ArrayList<Integer>();
    }

    Collections.sort(arr);

    int size = arr.size();
    int[] prefix = new int[size];
    prefix[0] = arr.get(0);

    for (int i = 1; i < size; i++) {
        prefix[i] = prefix[i - 1] + arr.get(i);
    }

    int sum = 0;
    List<Integer> result = new ArrayList<>();
    for (int i = size - 1; i >= 1; i--) {
        sum += arr.get(i);
        result.add(arr.get(i));
        if (sum > prefix[i - 1]) {
            break;
        }
    }

    Collections.reverse(result);

    return result;
}
```

Solution2: 

If we sort the array, the subset A with maximal total weight is the shortest trailing subarray with sum greater than half of the total sum, e.g. for the example above,

```text
sorted(arr) = [1, 2, 2, 3, 4, 5]
sum(arr) / 2 = 17 / 2 = 8.5
A = [4, 5]
sum(A) = 9
```

Now, we can just sort the array and extract the subarray and call it a day, but there is a more efficient approach. Notice that we don't need the whole array in sorted order — we only need to extract the largest elements in descending order, which seems like a perfect opportunity for a [priority queue](https://algo.monster/problems/heap_intro).

Therefore, we put all the values into a heap through heapify \(note: inserting one by one would defeat the purpose, as that would take `O(n log n)` time which is on the same magnitude as sorting\). We then pop one element at a time into a separate array, until the sum of the removed elements is larger than half the total sum. The removed elements are in descending order, so we reverse the result array before returning.

For input of size `n` and output of size `m`, this approach takes `O(n + m log n)` as opposed to `O(n log n)` by sorting, which is faster in all cases and especially so if the output size is small.

```java
public static List<Integer> optimizingBoxWeights(List<Integer> arr) {
    if (arr == null || arr.size() == 0) {
        return new ArrayList<Integer>();
    }

    PriorityQueue<Integer> q = new PriorityQueue<>((Integer a, Integer b) -> {
        return b - a;
    });
    q.addAll(arr);

    int sum = 0;
    for (int i = 0; i < arr.size(); i++) {
        sum += arr.get(i);
    }
    int average = sum / 2;

    List<Integer> result = new ArrayList<>();
    int curSum = 0;

    while (curSum <= average) {
        int num = q.poll();
        curSum += num;
        result.add(num);
    }

    Collections.reverse(result);

    return result;


}
```

