# Amazon VO

## VO cheatsheet

Other coded

1. [ ] 3sum\(fix 1 ptr, then 2sum\)
2. [x] Random Pick with Weight\(prefixSum + binary search\)
3. [x] write a function that 50% return 1, 50% return 0. follow up: utilize the function you just wrote, write another function 75% return 1 and 25% return 0 \(bit\) \([https://massivealgorithms.blogspot.com/2016/08/generate-0-and-1-with-25-and-75.html](https://massivealgorithms.blogspot.com/2016/08/generate-0-and-1-with-25-and-75.html)\)
4. [x] \(bonus\) input is a TreeNode. update all the node values with the sum of its all children \(in-order traversal, update self from left and right, return sum\)
5. [x] Minimum Path Sum \(dp on matrix\)
6. [ ] Simplify Paths\(split + stack\)
7. [ ] Pow\(x,y\) \(divideConquer / bit\)
8. [ ] Evaluate Division \(graph dfs\)
9. [ ] Minimum Genetic Mutation \(bfs / dfs, same as word ladder\)
10. [ ] First Unique Character in a String \(2 pass map, can be optimized based on different scenario in both space and time\)
11. [ ] Interval List Intersections\(merge 2 sorted list + max & min for start and end\)
12. [ ] Count Good Nodes in Binary Tree\(preorder dfs\)
13. [ ] Non-overlapping Intervals\(reverse thinking + sort based on end + dp\)
14. [x] Design HashMap\(bucket + linkedlist\)
15. [ ] Copy List with Random Pointer \(similar to clone graph \| O\(1\) space: change in-place, copy, then rewind\)
16. [ ] Happy Number \(set / list cycle I O\(1\) space\)
17. [x] Design In-Memory File System \(trie-like structure\)
18. [x] Design File System\(same as trie\)
19. [ ] Search Suggestions System \(trie search\)
20. [ ] Subarray Sum Equals K \(prefix sum\)
21. [ ] Longest Univalue Path \(l, r, leftMost, rightMost, global\)
22. [x] Daily Temperatures \(push when t\[stack.peek\(\)\] &gt;= t\[i\], pop otherwise, remember push the last one in after popping\)
23. [x] Single Element in a Sorted Array \(binary search, l &lt; r exit, remember to use clean boundary as we move mid instead of normal template\)
24. [ ] Next Greater Element II \(same as next greater element I, i % n, 2\*n loop\)
25. [x] Remove All Adjacent Duplicates in String II \(pair \(ch, count\)\)
26. [x] Number of Atoms \(similar to basic calculator I, store Map in stack\)
27. [x] Sqrt\(x\) \(binary search, l, r need to be long to prevent overflow, cast into int when return\)
28. [x] path sum I \(maintain sum along path, check sum == target at leaf\)
29. [x] path sum II \(remember to backtrack at last level\)
30. [x] path sum III \(prefix sum\)
31. [ ] coin change II \(dp\[i\]\[j\] = dp\[i - 1\]\[j\] + dp\[i\]\[j - coins\[i - 1\]\]\)
32. [x] Insert Delete GetRandom O\(1\) \(swap with last item in list\)

Tasks

* [x] balanced binary tree
* [ ] synonymous sentence
* [ ] sliding puzzle
* [ ] reverse bits
* [ ] remove duplicates from sorted list
* [ ] partition label \(greedy, shoot far, expand window, slide window\)
* [ ] best meeting points
* [ ] BST node distance
* [x] longest increasing path in a matrix \(dfs + int\[\]\[\] memo\)
* [ ] number of closed islands
* [ ] next greater node in linked list
* [ ] search suggestion system
* [ ] minimum window substring
* [ ] shortest completing word
* [ ] valid word abbreviation
* [ ] valid palindrom II
* [ ] valid palindrome III
* [ ] transform one string to another using minimum number of given operation
* [ ] nested-list-weight-sum
* [x] Account Merge
* [ ] Friend circle
* [ ] number-of-connected-components
* [x] Open the Lock \(bfs, remember to check the first node\)
* [ ] shortest-path-visiting-all-nodes
* [ ] bus-routes
* [x] Reorganize String \(always use map\[ch - 'a'\]--\)
* [ ] data-stream-as-disjoint-intervals
* [ ] median in sliding widow
* [ ] decode ways
* [ ] Partition equal subset sum
* [ ] common sub-sequence of two \(or more\) strings
* [ ] regular-expression-matching & wild card matching
* [ ] Max sum from root，max sum from any to any
* [ ] Right pointer
* [ ] Rank in a stream
* [ ] unique-binary-search-trees
* [ ] maximum-averge-subtree
* [ ] Queue with stacks
* [ ] longest-valid-parentheses
* [ ] Iterator for Combination
* [ ] Find Max Bandwidth
* [ ] copy-list-with-random-pointer
* [ ] shortest-unsorted-continuous-subarray
* [ ] Logger Rate Limiter
* [ ] Web Crawler
* [ ] Number of Longest Increasing Subsequence
* [ ] Longest Substring Without Repeating Characters
* [ ] Flood Fill
* [x] Binary Tree Level Order Traversal II
* [x] Longest Consecutive Sequence \(uf-alike set, push all into set, 2nd loop look up and down to see if can connect them, move boundary and remove connected piece\)
* [ ] Robot Bounded In Circle
* [ ] Maximum Frequency Stack
* [ ] Valid Sudoku
* [ ] Sudoku Solver
* [x] Insert Delete GetRandom O\(1\)
* [ ] Insert Delete GetRandom O\(1\) - Duplicates allowed
* [ ] First unique word in a stream
* [x] Design In-Memory File System
* [x] Design Search Autocomplete System
* [ ] Intersection of Two Arrays I
* [ ] Intersection of Two Arrays II
* [ ] LFU Cache
* [ ] Divide Array in Sets of K Consecutive Numbers
* [ ] unique pathsI & 63 unique pathsII & 980 unique paths III
* [ ] Encode and Decode TinyURL
* [ ] Single Number
* [x] Subtree of Another Tree \(double dc, because we might have duplicates\)
* [ ] Tree Diameter
* [ ] Binary Tree Paths
* [ ] The Maze
* [ ] The Maze II
* [ ] Analyze User Website Visit Pattern



https://leetcode.com/discuss/interview-question/124719/Find-the-first-word-in-a-stream-in-whic

h-it-is-not-repeated-in-the-rest-of-the-stream/

Find target word

https://www.1point3acres.com/bbs/thread-617156-1-1.html

given list of tuples: \[\("a", "b"\), \("b", "c".....\] and a target word: "hello", 要 求 判 断 能 否 ⽤ tuples

的 字 母 组 成 target 。 每 个 tuple 只 能 ⽤ ⼀ 次 ， tuple ⾥ 两 个 字 母 是 ⼆ 选 ⼀。

LC 237. Delete Node in a Linked List

hasNext\(\) & Next\(\)

LC 284?

给 ⼀ 个 sorted 的 list of list ， 实 现 bool hasNext\(\) 和 next\(\) ， 刚 开 始 提 出 priority queue ， ⾯ 试 官

说 不 ⽤ 额 外 space ， 后 来 ⽤ pointer 做 的

Reviewed

1. [ ] Robot Bounded In Circle \(dir = \(dir + 3\) % 4 / dir = \(dir + 1\) % 4\)
2. [ ] Rotting Oranges \(same as walls and gates, start from rotten oranges and keep fress counts\)
3. [ ] Most Common Word\(replaceAll, split, set\)
4. [ ] Find Peak Element \(nums\[mid\] &gt; nums\[mid + 1\], go to left, else go to right\)



OOD

* [ ] LRU
* [ ] LINUX FIND
* [x] parking lot
* [ ] 设计象棋
* [ ] tik-tok-toe
* [ ] 设计一个电话簿
* [ ] string parser
* [ ] top N selling products
* [ ] analyze-user-website-visit-pattern
* [ ] 设计Amazon Locker
* [ ] 德州扑克
* [ ] 购物车
* [ ] 贪吃蛇
* [ ] Ticket booking
* [x] restaurant reservation
* [ ] vendor machine

## Parking Lot

```java
import java.util.*;
public class ParkingLotDesign {
    enum VehicleSize {
        Motorcycle,
        Compact,
        Large,
    }
    abstract class Vehicle {
        protected VehicleSize size;
        protected String licensePlate;

        public VehicleSize getSize() {
            return size;
        }
    }

    class Motorcycle extends Vehicle {
        public Motorcycle(String id) {
            size = VehicleSize.Motorcycle;
            licensePlate = id;
        }
    }

    class Car extends Vehicle {
        public Car(String id) {
            size = VehicleSize.Compact;
            licensePlate = id;
        }
    }

    class Bus extends Vehicle {
        public Bus(String id) {
            size = VehicleSize.Large;
            licensePlate = id;
        }
    }

    class Level {
        private List<Spot> spots;
        private int availableCount;
        private int floor;

        public Level(int num_spots) {
            spots = new ArrayList<>();
            for (int i = 0; i < num_spots; i++) {
                spots.add(new Spot(floor));
            }
        }

        public int getAvailableCount() {
            return availableCount;
        }

        public void updateAvailableCount() {
            int count = 0;
            for (Spot spot: spots) {
                if (spot.availability) {
                    count++;
                }
            }
            availableCount = count;
        }
    }

    class Spot {
        private boolean availability;
        private int level;
        private VehicleSize size;

        public Spot(int level) {
            this.level = level;
        }

        public void takeSpot() {
            markUnavailable();
        }

        public void clearSpot() {
            markAvailable();
        }

        private boolean getAvailability() {
            return availability;
        }

        private void markAvailable() {
            this.availability = true;
        }

        public void markUnavailable() {
            this.availability = false;
        }

        public VehicleSize getSize() {
            return size;
        }
    }

    class Ticket{
        private Vehicle v;
        private Spot spot;
        private long startTime;

        public Ticket(Vehicle v, Spot spot, long startTime) {
            this.v = v;
            this.spot = spot;
            this.startTime = startTime;
        }
    }

    public class ParkingLot {
        private List<Level> levels;
        private float hourlyRate;

        // @param n number of levels
        // @param num_rows  each level has num_rows rows of spots
        // @param spots_per_row each row has spots_per_row spots
        public ParkingLot(int n, int spots_per_level) {
            levels = new ArrayList<>();
            for (int i  = 0; i < n; i++) {
                levels.add(new Level(spots_per_level));
                levels.get(i).floor = i;
            }
        }

        public boolean parkVehicle(Vehicle v) throws ParkingLotFullException {
            for (Level level : levels) {
                if (level.getAvailableCount() == 0) {
                    continue;
                }
                Spot spot = findSpots(v, level);
                if (spot != null) {
                    spot.markUnavailable();
                    levels.get(spot.level).updateAvailableCount();
                    return true;
                }
            }
            throw new ParkingLotFullException("parking lot is full");
        }

        public void unParkVehicle(Ticket t) {
            t.spot.markAvailable();
            levels.get(t.spot.level).updateAvailableCount();
        }

        public int getAvailableCount() {
            int count = 0;
            for (Level level : levels) {
                count += level.availableCount;
            }
            return count;
        }

        private Spot findSpots(Vehicle v, Level level) {
            for (Spot spot: level.spots) {
                if (canFitIn(spot, v)) {
                    return spot;
                }
            }
            return null;
        }

        private boolean canFitIn(Spot spot, Vehicle v) {
            if (spot.size == VehicleSize.Motorcycle) {
                return v.size == VehicleSize.Motorcycle;
            } else if (spot.size == VehicleSize.Compact) {
                return v.size != VehicleSize.Large;
            } else {
                return true;
            }
        }

        private float calcPrice(Ticket t) {
            Date curTime = new Date();
            return (curTime.getTime() - t.startTime) / (60 * 60 * 1000) * hourlyRate;
        }
    }

    class ParkingLotFullException extends Exception {
        public ParkingLotFullException(String s) {
            super(s);
        }
    }
}
```

 

