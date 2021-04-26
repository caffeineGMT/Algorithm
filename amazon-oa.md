---
description: 'Resource: https://algo.monster/dashboard'
---

# Amazon OA

## 

## Minimum Cost to Connect All Nodes \(Minimum Spanning Tree I\)

Monster Airlines has a set of `n` destination cities and a list of flight paths connecting some of the cities together. Your job is to find the flight paths that would connect all of the cities together, but with minimum total travel distance.

#### Input

The input consists of three arguments:

`n` = the number of nodes \(ie. cities\). The cities are represented by numbers `1...n`.

`edges` = an array of flight paths, represented by pairs of numbers corresponding to the cities being connected.

`costs` = a list of distances in number triplets. The first two numbers represent the cities being connected, and the last number is the distance. For example, `[1,2,3]` would state that the distance between cities `1` and `2` is `3`. Due to certain constraints, not all cities can be connected, so if a triplet is not found in this list, it is not possible to connect them.

#### Examples

**Example 1:**

**Input: n = 6, edges = \[\[1, 4\], \[4, 5\], \[2, 3\]\], costs = \[\[1, 2, 5\], \[1, 3, 10\], \[1, 6, 2\], \[5, 6, 5\]\]**

**Output: 7**

**Explanation:**

The edges can be collected into interconnected groups of cities, ie. `[1, 4, 5]`, `[2, 3]`, and `[6]`. This helps identify what needs to be connected.

The cheapest path between the first and second group is `[1, 2]`. The cheapest path between the first and third group is `[1, 6]`, and there is no available path between the second and third group.

The cost of each path is `5` and `2` respectively, therefore the total cost is `5 + 2 = 7`.

**hint:** What’s the time complexity of your algorithm? Can you make the running time `O(E * log(E))` by using union find?

* Solution: 
  * union find + greedy
  * time: without path compression O\(elge\); with path compression: O\(e\)
  * space: O\(n\)

```java
static class UnionFind {
    Map<Integer, Integer> valueMap;
    Map<Integer, Integer> sizeMap;
    int count;

    UnionFind() {
        valueMap = new HashMap<>();
        sizeMap = new HashMap<>();
        count = 0;
    }

    void add(int a) {
        if (valueMap.containsKey(a)) {
            return;
        }
        valueMap.put(a, a);
        sizeMap.put(a, 1);
        count++;
    }

    void union(int a, int b) {
        if (!valueMap.containsKey(a) || !valueMap.containsKey(b)) {
            return;
        }

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }
        if (sizeMap.get(pa) <= sizeMap.get(pb)) {
            valueMap.put(pa, pb);
            sizeMap.put(pb, sizeMap.get(pa) + sizeMap.get(pb));
        } else {
            valueMap.put(pb, pa);
            sizeMap.put(pa, sizeMap.get(pa) + sizeMap.get(pb));
        }
        count--;
    }

    int find(int a) {
        int cur = a;
        while (valueMap.get(cur) != cur) {
            int parent = valueMap.get(cur);
            valueMap.put(cur, valueMap.get(parent));
            cur = parent;
        }
        return cur;
    }
}
public static int minCostToConnectNodes(int n, List<List<Integer>> edges, List<List<Integer>> costs) {
    UnionFind uf = new UnionFind();
    for (int i = 1; i <= n; i++) {
        uf.add(i);
    }
    for (List<Integer> edge: edges) {
        int a = edge.get(0);
        int b = edge.get(1);
        uf.union(a, b);
    }

    Collections.sort(costs, (a, b) -> {
        return a.get(2) - b.get(2);
    });

    int sum = 0;
    for (List<Integer> cost: costs) {
        int a = cost.get(0);
        int b = cost.get(1);
        int pa = uf.find(a);
        int pb = uf.find(b);
        if (pa == pb) {
            continue;
        }
        uf.union(a, b);
        sum += cost.get(2);
    }

    return sum;
}
```

## Find All Combination of Numbers that Sum to a Target \| Shopping Options

Given four arrays of integers and an integer `limit`. We need to pick 1 number from each of the four arrays such that the sum of the selected numbers is smaller or equal to `limit`. Find the number of valid combinations.

#### Example

**Input:**

```text
a = [2, 3, 5]
b = [5]
c = [2, 3, 10]
d = [1, 2]
limit = 11
```

**Output: 4**

We can pick the numbers in the following four ways: `[2, 5, 2, 1], [2, 5, 3, 1], [2, 5, 2, 2], [3, 5, 2, 1]`. So return 4.

```java
public static int numberOfOptions(List<Integer> a, List<Integer> b, List<Integer> c, List<Integer> d, int limit) {
    int[][] dp = new int[4][limit + 1];
    for (int j = 1; j <= limit; j++) {
        for (int num: a) {
            if (num <= j) {
                dp[0][j]++;
            }
        }
    }

    for (int i = 1; i < 4; i++) {
        for (int j = 1; j <= limit; j++) {
            if (i == 1) {
                induction(dp, b, i, j);
            } else if (i == 2) {
                induction(dp, c, i, j);
            } else if (i == 3) {
                induction(dp, d, i, j);
            }
        }
    }

    return dp[3][limit];
}

private static void induction(int[][] dp, List<Integer> list, int i, int j) {
    for (int num: list) {
        if (j - num >= 0) {
            dp[i][j] += dp[i - 1][j - num];
        }
    }
}
```

## Earliest Time To Complete Deliveries \| Schedule Deliveries

You are the manager of logistics for a burger franchise, and you are tasked with delivering supplies as quickly as possible.

There are `n` restaurants with `4` receiving docks each. Each dock has a specified maximum receiving rate.

#### Input

`n` = number of restaurants

`openTimes` = a number that represents the time the `i`th restaurant opens

`deliveryTimeCost` = an array of numbers representing the time it takes to unload a delivery. There are exactly `n * 4` values in this list.

#### Output

The earliest time all deliveries can be completed.

#### Examples

**Example 1:**

**Input:**

`n = 2`

`openTimes = [8, 10]`

`deliveryTimeCost = [2,2,3,1,8,7,4,5]`

**Output: 16**

**Explanation:**

For the restaurant that opens at `8`, assign deliveries with cost `[8, 7, 5, 4]`. These will complete at `(8+8), (8+7), (8+5)`, and `(8+4)`, which are `16, 15, 13,` and `12` respectively.

For the restaurant that opens at `10`, assign deliveries with cost `[3, 2, 2, 1]`. These will complete at `(10+3), (10+2), (10+2)`, and `(10+1)`, which are `13, 12, 12`, and `11` respectively.

The lastest of all of the delivery completion time is at `16`.

Solution: We can solve this problem with a greedy algorithm. It's better to assign longer tasks to docks that open earlier because the combined finish time would be minimized. Sort dock ascending and offloading sort time descending, and then assign time to dock.

```java
public static int earliestTime(int n, List<Integer> openTimes, List<Integer> deliveryTimeCost) {
    Collections.sort(openTimes);
    Collections.sort(deliveryTimeCost, (Integer a, Integer b) -> {
        return b - a;
    });

    int ans = 0;
    int index = 0;

    for (Integer openTime: openTimes) {
        ans = Math.max(ans, openTime + deliveryTimeCost.get(index));
        index += 4;
    }

    return ans;
}
```

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

## Optimal Utilization

Find a pair of entries from two lists that yield a sum that is as close to a `target` number as possible, without exceeding it.

Each entry in a list is a key-value pair, where the key is a number identifier and the value is also a number. The output must be a list containing the pairs of numbers representing the identifiers that yield the result.

If a solution is not possible, return an empty list.

#### Input

`a` = an array of `number pairs` where the first number is an identifier and the second number is a value.

`b` = Same as `a`. Each identifier is unique in each list.

`target` = a number

#### Examples

**Example 1:**

**Input:**

`a = [[1, 2], [2, 4], [3, 6]]`, `b = [[1, 2]]`, `target = 7`,

**Output: \[\[2, 1\]\]**

**Explanation:**

There are only three possible pairs, `[1, 1]`, `[2, 1]`, and `[3, 1]`. They yield the sum values of `2 + 2 = 4`, `4 + 2 = 6` and `6 + 2 = 8` respectively.

`6` is the largest number that does not exceed `7`, therefore `[2, 1]` is the optimal pair.

**Example 2:**

**Input:**

`a = [[1, 3], [2, 5], [3, 7], [4, 10]]`, `b = [[1, 2], [2, 3], [3, 4], [4, 5]]`, `target = 10`,

**Output: \[\[2, 4\], \[3, 2\]\]**

**Explanation:**

There are two pairs possible. The element with `id = 2` from list `a` has a value of `5`, and the element with `id = 4` from list `b` also has a value of `5`. Combined, they add up to `10`.

Likewise, the element with `id = 3` from `a` has a value of `7`, and the element with `id = 2` from `b` has a value of `3`. These also add up to `10`.

Therefore, the optimal pairs are `[2, 4]` and `[3, 2]`.

**Example 3:**

**Input:**

`a = [[1, 8], [2, 7], [3, 14]]`, `b = [[1, 5], [2, 10], [3, 14]]`, `target = 20`,

**Output: \[\[3, 1\]\]**

**Example 4:**

**Input:**

`a = [[1, 8], [2, 15], [3, 9]]`, `b = [[1, 8], [2, 11], [3, 12]]`, `target = 20`,

**Output: \[\[1, 3\], \[3, 2\]\]**

* Solution: 
  * time: O\(nlgn + mlgm\)
  * space: O\(m + n\)
* thoughts: this is tricky 2-sum question. since we must pick 1 from a and pick another from b, after sorting both list, we can have 1 pointer points to the smallest item from a, and another pointer points to the largest item from b. The tricky part is that once we encounter a duplicate, we cannot simply change right pointer's value, because the left pointer could still use it since every item has a unique id.

```java
public static List<List<Integer>> getPairs(List<List<Integer>> a, List<List<Integer>> b, int target) {
    Collections.sort(a, (l1, l2) -> {
        return l1.get(1) - l2.get(1);
    });
    Collections.sort(b, (l1, l2) -> {
        return l1.get(1) - l2.get(1);
    });

    int l = 0, r = b.size() - 1;
    int maxSum = Integer.MIN_VALUE;
    List<List<Integer>> result = new ArrayList<>();

    while (l < a.size() && r >= 0) {
        int temp = a.get(l).get(1) + b.get(r).get(1);
        if (temp > target) {
            r--;
        } else {
            // still not optimal
            if (maxSum > temp) {
                l++;
                continue;
            } 

            // found a better option
            if (maxSum < temp) {
                maxSum = temp;
                result.clear();
            }

            // found a tie option
            List<Integer> list = Arrays.asList(a.get(l).get(0), b.get(r).get(0));
            result.add(list);

            // deal with duplicates
            int index = r - 1;
            while (index >= 0 && b.get(index).get(1) == b.get(r).get(1)) {
                List<Integer> more = Arrays.asList(a.get(l).get(0), b.get(index).get(0));
                result.add(more);
                index--;
            }

            l++;
        }
    }

    return result;
}
```

## Amazon Prime Air Route \| Prime Order Prioritization

> this question is the same as above

Amazon Prime Air is developing a system that divides shipping routes using flight optimization routing systems to a cluster of aircraft that can fulfill these routes. Each shipping route is identified by a unique integer identifier, requires a fixed non-zero amount of travel distance between airports, and is defined to be either a forward shipping route or a return shipping route. Identifiers are guaranteed to be unique within their own route type, but not across route types.

Each aircraft should be assigned two shipping routes at once: one forward route and one return route. Due to the complex scheduling of flight plans, all aircraft have a fixed maximum operating travel distance, and cannot be scheduled to fly a shipping route that requires more travel distance than the prescribed maximum operating travel distance. The goal of the system is to optimize the total operating travel distance of a given aircraft. A forward/return shipping route pair is considered to be "optimal" if there does not exist another pair that has a higher operating travel distance than this pair, and also has a total less than or equal to the maximum operating travel distance of the aircraft.

For example, if the aircraft has a maximum operating travel distance of 3000 miles, a forward/return shipping route pair using a total of 2900 miles would be optimal if there does not exist a pair that uses a total operating travel distance of 3000 miles, but it would not be considered optimal if such a pair did exist.

Your task is to write an algorithm to optimize the sets of forward/return shipping route pairs that allow the aircraft to be optimally utilized, given a list of forward shipping routes and a list of return shipping routes.

#### Input

The input to the function/method consists of three arguments:

`maxTravelDist` - an integer representing the maximum operating travel distance of the given aircraft;

`forwardRouteList` - a list of pairs of integers where the first integer represents the unique identifier of a forward shipping route and the second integer represents the amount of travel distance required by this shipping route;

`returnRouteList` - a list of pairs of integers where the first integer represents the unique identifier of a return shipping route and the second integer represents the amount of travel distance required by this shipping route.

#### Output

Return a list of pairs of integers representing the IDs of forward and return shipping routes that optimally utilize the given aircraft. If no route is possible, return an empty list.

#### Example

**Example 1:**

**Input:**

```text
maxTravelDist = 7000
forwardRouteList = [[1, 2000], [2, 4000],[3, 6000]]
returnRouteList = [[1, 2000]]
```

**Output:**

```text
[[2, 1]]
```

**Explanation:**

There are only three combinations, `[1, 1]`, `[2, 1]`, and `[3, 1]`, which have a total of 4000, 6000, and 8000 miles, respectively. Since 6000 is the largest distance that does not exceed 7000, `[2, 1]` is the only optimal pair.

**Example 2:**

**Input:**

```text
maxTravelDist= 10000
forwardRouteList = [[1, 3000], [2, 5000], [3, 7000], [4, 10000]]
returnRouteList= [[1, 2000], [2, 3000], [3, 4000], [4, 5000]]
```

**Output:**

```text
[[2, 4], [3, 2]]
```

**Explanation:**

There are two pairs of forward and return shipping routes possible that optimally utilizes the given aircraft. Shipping Route ID\#2 from `forwardShippingRouteList` requires 5000 miles travelled, and Shipping Route ID\#4 from `returnShippingRouteList` also requires 5000 miles travelled. Combined, they add up to 10000 miles travelled. Similarly, Shipping Route ID\#3 from `forwardShippingRouteList` requires 7000 miles travelled, and Shipping Route ID\#2 from `returnShippingRouteList` requires 3000 miles travelled. These also add up to 10000 miles travelled. Therefore, the pairs of forward and return shipping routes that optimally utilize the aircraft are `[2, 4]` and `[3, 2]`.

## Maximum Disk Space Available

A user wants to store a file in a data center, but requests it to be replicated across each machine in a block. A block is defined as a continuous set of machines, starting from the first machine, with each block being next to one another and fixed in size. For example, if the block size is defined as 3, the first block is composed of machines 1 to 3, the second block is composed of machines 2 to 5, and so on.

Find the largest possible file the user can store in a data center, given a block size.

#### Input

`freeSpace`: a list of numbers representing the free space available in each machine of the data center

`blockSize`: a number representing the size of each block

#### Output

A number representing the amount of free space that the emptiest block in the data center has. The free space within a given block is the minimum free space of all the machines in it.

#### Constraints

The size of the block is always smaller than the number of machines in the `freeSpace` list. `freeSpace` values are never zero.

#### Examples

**Example 1:**

**Input:**

freeSpace = `[8,2,4,5]`

blockSize = `2`

**Output: 4**

**Explanation:**

In this data center, the subarrays representing the free space of each block of size `2` are `[8,2]`, `[2,4]`, and `[4,5]`. The minimum available space of each blocks is `2`, `2`, and `4`. The maximum of these values is `4`. Therefore, the answer is `4`.

#### Complexity

Both time complexity and space complexity must be around `O(n)`.

Solution: this is same as `sliding window maximum`: [https://leetcode.com/problems/sliding-window-maximum/](https://leetcode.com/problems/sliding-window-maximum/)

```java
public static int availableSpace(List<Integer> freeSpace, int blockLength) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    int n = freeSpace.size();
    int k = blockLength;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
        while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
            q.pollFirst();
        }
        while (!q.isEmpty() && freeSpace.get(q.peekLast()) > freeSpace.get(i)) {
            q.pollLast();
        }

        q.offer(i);

        if (i >= k - 1) {
            max = Math.max(max, freeSpace.get(q.peekFirst()));
        }
    }

    return max;
}
```

