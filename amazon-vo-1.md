# Amazon VO

## VO cheatsheet

Other coded

1. [ ] 3sum\(fix 1 ptr, then 2sum\)
2. [ ] 4sum
3. [ ] 3sum closest
4. [x] Random Pick with Weight\(prefixSum + binary search\)
5. [x] write a function that 50% return 1, 50% return 0. follow up: utilize the function you just wrote, write another function 75% return 1 and 25% return 0 \(bit\) \([https://massivealgorithms.blogspot.com/2016/08/generate-0-and-1-with-25-and-75.html](https://massivealgorithms.blogspot.com/2016/08/generate-0-and-1-with-25-and-75.html)\)
6. [x] \(bonus\) input is a TreeNode. update all the node values with the sum of its all children \(in-order traversal, update self from left and right, return sum\)
7. [x] Minimum Path Sum \(dp on matrix\)
8. [x] Simplify Paths\(split + stack\)
9. [x] Pow\(x,y\) \(divideConquer / bit\)
10. [x] Evaluate Division \(graph dfs\)
11. [x] Minimum Genetic Mutation \(bfs / dfs, same as word ladder\)
12. [x] First Unique Character in a String \(2 pass map, can be optimized based on different scenario in both space and time\)
13. [x] Interval List Intersections\(merge 2 sorted list + max & min for start and end\)
14. [x] Count Good Nodes in Binary Tree\(preorder dfs\)
15. [x] Non-overlapping Intervals\(reverse thinking + sort based on end + dp\)
16. [x] Design HashMap\(bucket + linkedlist\)
17. [x] Copy List with Random Pointer \(similar to clone graph \| O\(1\) space: change in-place, copy, then rewind\)
18. [x] Happy Number \(set / list cycle I O\(1\) space\)
19. [x] Design In-Memory File System \(trie-like structure\)
20. [x] Design File System\(same as trie\)
21. [x] Subarray Sum Equals K \(prefix sum\)
22. [x] Longest Univalue Path \(l, r, leftMost, rightMost, global\)
23. [x] Daily Temperatures \(push when t\[stack.peek\(\)\] &gt;= t\[i\], pop otherwise, remember push the last one in after popping\)
24. [x] Single Element in a Sorted Array \(binary search, l &lt; r exit, remember to use clean boundary as we move mid instead of normal template\)
25. [x] Next Greater Element II \(same as next greater element I, i % n, 2\*n loop\)
26. [x] Remove All Adjacent Duplicates in String II \(pair \(ch, count\)\)
27. [x] Number of Atoms \(similar to basic calculator I, store Map in stack\)
28. [x] Sqrt\(x\) \(binary search, l, r need to be long to prevent overflow, cast into int when return\)
29. [x] path sum I \(maintain sum along path, check sum == target at leaf\)
30. [x] path sum II \(remember to backtrack at last level\)
31. [x] path sum III \(prefix sum\)
32. [x] coin change II \(dp\[i\]\[j\] = dp\[i - 1\]\[j\] + dp\[i\]\[j - coins\[i - 1\]\]\)
33. [x] Insert Delete GetRandom O\(1\) \(swap with last item in list\)

Tasks

* [x] balanced binary tree
* [x] shortest word distance I 
* [x] shortest word distance II \(merge sort\)
* [x] remove duplicates from sorted list
* [x] partition label \(greedy, shoot far, expand window, slide window\)
* [x] longest increasing path in a matrix \(dfs + int\[\]\[\] memo\)
* [x] number of closed islands
* [x] search suggestion system \(build prefix hashmap / build trie and dfs\)
* [x] minimum window substring
* [x] valid palindrome I 
* [x] valid palindrome II
* [x] nested list weight sum \(same as flatten nested list\)
* [x] Account Merge
* [x] Friend circle \(num of province, uf\)
* [x] number of connected components \(uf\)
* [x] Open the Lock \(bfs, remember to check the first node\)
* [x] Reorganize String \(always use map\[ch - 'a'\]--\)
* [x] median in sliding widow
* [x] decode ways \(watch out leading 0\)
* [x] maximum averge subtree
* [x] Queue with stacks
* [x] copy list with random pointer
* [x] Logger Rate Limiter \(hashmap \|\| queue + set \|\| lru\)
* [x] Longest Substring Without Repeating Characters
* [x] Flood Fill \(bfs\)
* [x] Binary Tree Level Order Traversal II
* [x] Longest Consecutive Sequence \(uf-alike set, push all into set, 2nd loop look up and down to see if can connect them, move boundary and remove connected piece\)
* [x] Maximum Frequency Stack
* [x] Valid Sudoku
* [x] Sudoku Solver
* [x] Insert Delete GetRandom O\(1\)
* [x] Insert Delete GetRandom O\(1\) - Duplicates allowed
* [x] First unique word in a stream 
  * [x] \(similar to LRU [https://leetcode.com/discuss/interview-question/124719/Find-the-first-word-in-a-stream-in-which-it-is-not-repeated-in-the-rest-of-the-stream/](https://leetcode.com/discuss/interview-question/124719/Find-the-first-word-in-a-stream-in-which-it-is-not-repeated-in-the-rest-of-the-stream/)\)
  * [x] [https://www.jiuzhang.com/problem/first-unique-number-in-data-stream-ii/](https://www.jiuzhang.com/problem/first-unique-number-in-data-stream-ii/)
* [x] Design In-Memory File System
* [x] Design Search Autocomplete System
* [x] Intersection of Two Arrays I \(2 hashset / sort + binary search/ sort + merge\)
* [x] Intersection of Two Arrays II 
* [x] LFU Cache
* [x] Encode and Decode TinyURL
* [x] Single Number
* [x] Subtree of Another Tree \(double dc, because we might have duplicates\)
* [x] Tree Diameter \(2 bfs\)
* [x] Binary Tree Paths
* [x] The Maze
* [x] The Maze II
* [x] Analyze User Website Visit Pattern\(brute force count every occurence\)
* [x] Number of Days Between Two Dates \(calc date from 1971\)
* [x] triangle \(dp or divide conquer + memo\)
* [x] serialize & deserializae n-ary tree \(append children count\)
* [x] Minimum Knight Moves \(just calc one corner region\)
* [x] All Nodes Distance K in Binary Tree \(convert to graph and run bfs\)
* [x] select a random node from a tree with equal probability \(similar to quick select\)
  * [x] \([https://www.youtube.com/watch?v=nj5jFhglw8U](https://www.youtube.com/watch?v=nj5jFhglw8U)\)
  * [x] \([https://www.byte-by-byte.com/randombinarytree/](https://www.byte-by-byte.com/randombinarytree/)\)
* [x] Minimum Cost to Connect Sticks \(pq\)
* [x] add two numbers III 
  * [x] \([https://leetcode.com/problems/add-strings/discuss/522194/follow-up-in-case-of-negative-numbers-python](https://leetcode.com/problems/add-strings/discuss/522194/follow-up-in-case-of-negative-numbers-python)\)
  * [x] [https://app.gitbook.com/@guomaitao/s/datastructure-and-algorithm/v/master/follow-ups\#add-strings-iii-add-2-numbers-with-linkedlist-substract-2-numbers](https://app.gitbook.com/@guomaitao/s/datastructure-and-algorithm/v/master/follow-ups#add-strings-iii-add-2-numbers-with-linkedlist-substract-2-numbers)
* [x] peeking iterator
  * [x] [https://stackoverflow.com/questions/52159526/iterator-for-a-list-of-sorted-lists-using-a-priority-queue](https://stackoverflow.com/questions/52159526/iterator-for-a-list-of-sorted-lists-using-a-priority-queue)
* [x] Delete Node in a Linked List
* [x] write a iterator，based on percentage, return a list of string. e.g.\[foo, bar\] = \[1:1\]，total = 500, return 250 foo and 250 bar
  * [x] OfInt iter = IntStream.range\(0, 10\).iterator\(\);
  * [x] prefix sum as key
  * [x] tree map hoding the key, val is String
  * [x] using intstream to iterate thru the whole range, find ceilingKey as we iterate and return the string val
* [x] My Calendar III
* [x] Max stack
* [x] Implement Stack using Queues
* [x] Implement Queue using Stacks
* [x] Palindrome Linked List

Reviewed

1. [x] Robot Bounded In Circle \(dir = \(dir + 3\) % 4 / dir = \(dir + 1\) % 4\)
2. [x] Rotting Oranges \(same as walls and gates, start from rotten oranges and keep fress counts\)
3. [x] Most Common Word\(replaceAll, split, set\)
4. [x] Find Peak Element \(nums\[mid\] &gt; nums\[mid + 1\], go to left, else go to right\)

Others

* [ ] sliding puzzle 
* [ ] synonymous sentence
* [ ] Web Crawler
* [ ] shortest completing word
* [ ] Iterator for Combination
* [ ] ~~s~~hortest path visiting all nodes
* [ ] valid palindrome III 
* [ ] Number of Longest Increasing Subsequence
* [ ] Divide Array in Sets of K Consecutive Numbers
* [ ] valid word abbreviation
* [ ] shortest unsorted continuous subarray
* [ ] transform one string to another using minimum number of given operation
* [ ] next greater node in linked list
* [ ] Data Stream as Disjoint Intervals
* [ ] reverse bits
* [ ] regular-expression-matching & wild card matching
* [ ] Critical Connections in a Network
* [ ] Partition equal subset sum
* [ ] unique binary search trees
* [ ] min BST node distance
* [ ] bus-routes
* [ ] Rotate Array

OOD

* [x] LRU
* [x] file system
* [x] linux find
* [x] parking lot
* [x] Amazon Locker
* [x] restaurant reservation
* [x] elevator
* [x] coffee machine
* [x] tic-tac-toe
* [x] blackjack
* [x] chess
* [x] deck of cards
* [x] shopping cart \(similar to vending machine\)
* [x] ticket booking \(similar to restaurant reservation\)
* [x] phonebook \(similar to file system\)

## Linux Find

![](.gitbook/assets/image.png)



```java
public class LinuxFindDesign {
    class File {
        String name;
        String extension;
        int size;
        boolean isDir;
        List<File> children;
        Timestamp deleted;
        Timestamp created;
        Timestamp modified;

        File() {
            name = "";
            extension = "";
            size = 0;
            isDir = false;
            children = new ArrayList<>();
        }
    }

    File root = new File();

    class SearchParams {
        String extension;
        Integer minSize;
        Integer maxSize;
        String name;
    }

    interface Filter {
        boolean isValid(SearchParams params, File file);
    }

    class ExtensionFilter implements Filter {
        @Override
        public boolean isValid(SearchParams params, File file) {
            if (params.extension == null) return true;
            return file.extension.equals(params.extension);
        }
    }

    class MinSizeFilter implements Filter {
        @Override
        public boolean isValid(SearchParams params, File file) {
            if (params.minSize == null) return true;
            return file.size >= params.minSize;
        }
    }

    class MaxSizeFilter implements Filter {
        @Override
        public boolean isValid(SearchParams params, File file) {
            if (params.maxSize == null) return true;
            return file.size <= params.maxSize;
        }
    }

    class NameFilter implements Filter {
        @Override
        public boolean isValid(SearchParams params, File file) {
            if (params.name == null) return true;
            return file.name.equals(params.name);
        }
    }

    class FileFilter {
        List<Filter> filters;
        FileFilter() {
            filters = new ArrayList<>();
            filters.add(new ExtensionFilter());
            filters.add(new NameFilter());
            filters.add(new MaxSizeFilter());
            filters.add(new MinSizeFilter());
        }
        public boolean isValid(SearchParams params, File file) {
            for (Filter filter: filters) {
                if (!filter.isValid(params, file)) {
                    return false;
                }
            }
            return true;
        }
    }

    class FileSearcher {
        private FileFilter fileFilter;
        FileSearcher() {
            FileFilter fileFilter= new FileFilter();
        }

        public List<File> search(File root, SearchParams searchParams) {
            List<File> res = new ArrayList<>();
            Queue<File> q = new ArrayDeque<>();
            q.offer(root);
            while(!q.isEmpty()) {
                File file = q.poll();
                if (!file.isDir && fileFilter.isValid(searchParams, file)) {
                    res.add(file);
                    continue;
                }
                for (File neighbor: file.children) {
                    q.offer(neighbor);
                }
            }
            return res;
        }
    }
}
```

 

## Parking Lot

![](.gitbook/assets/image%20%281%29.png)

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

## Singleton

```java
public class Singleton {
    public static class ParkingLot {
        private static ParkingLot _instance = null;
        private List<Integer> levels;
        private ParkingLot() {
            levels = new ArrayList<>();
        }

        // non-thread safe
        public static ParkingLot getInstance() {
            if (_instance == null) {
                _instance = new ParkingLot();
            }
            return _instance;
        }

        // thread safe
//        public static synchronized ParkingLot getInstance() {
//            if (_instance == null) {
//                _instance = new ParkingLot();
//            }
//            return _instance;
//        }
    }
}
```

## Amazon Locker

```java
public class AmazonLockerDesign {
    public enum Size {
        SMALL, MIDDLE, LARGE
    }

    public class Package {
        public long packageId;
        private Size packageSize;
        public Package (Long packageId, Size packageSize) {
            this.packageId = packageId;
            this.packageSize = packageSize;
        }
        public Size getSize() {
            return packageSize;
        }
    }

    public class Locker {
        private int lockerId;
        private Size lockerSize;
        private boolean availability;
        public Locker (int lockerId, Size lockerSize) {
            this.lockerId = lockerId;
            this.lockerSize = lockerSize;
        }
        public void takeLocker() {
            markUnavailable();
        }

        public void clearLocker() {
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

        public Size getSize() {
            return lockerSize;
        }

        public boolean isFitIn (Package p) {
            if (lockerSize == Size.LARGE) {
                return true;
            } else if (lockerSize == Size.MIDDLE) {
                return p.getSize() == Size.MIDDLE || p.getSize() == Size.SMALL;
            } else {
                return p.getSize() == Size.SMALL;
            }
        }
    }

    class Receipt{
        private Package p;
        private Locker locker;
        private float startTime;

        public Receipt(Package p, Locker locker, long startTime) {
            this.p = p;
            this.locker = locker;
            this.startTime = startTime;
        }
    }

    public class LockerSystem {
        private float hourlyRate;
        Stack<Locker> availableSmall = new Stack<>();
        Stack<Locker> availableMiddle = new Stack<>();
        Stack<Locker> availableLarge = new Stack<>();

        public LockerSystem(int s, int m, int l, int hourlyRate) {
            int id = 0;
            for (int i = 0; i < s; i++) {
                availableSmall.push(new Locker(id++, Size.SMALL));
            }
            for (int i = 0; i < m; i++) {
                availableMiddle.push(new Locker(id++, Size.MIDDLE));
            }
            for (int i = 0; i < l; i++) {
                availableLarge.push(new Locker(id++, Size.LARGE));
            }
        }

        public boolean checkAvailability(Package p) {
            Size size = p.getSize();
            if (size == Size.LARGE) {
                return availableLarge.size() != 0;
            } else if (size == Size.MIDDLE) {
                return availableMiddle.size() != 0;
            } else {
                return availableSmall.size() != 0;
            }
        }

        public void removePackage(Receipt receipt) {
            receipt.locker.markAvailable();
            if (receipt.locker.getSize() == Size.LARGE) {
                availableLarge.push(new Locker(receipt.locker.lockerId, receipt.locker.lockerSize));
            } else if (receipt.locker.getSize() == Size.MIDDLE){
                availableMiddle.push(new Locker(receipt.locker.lockerId, receipt.locker.lockerSize));
            } else {
                availableSmall.push(new Locker(receipt.locker.lockerId, receipt.locker.lockerSize));
            }
        }

        public Receipt addPackage(Package p) throws LockerFullException{
            if (!checkAvailability(p)) {
                throw new LockerFullException("locker is full");
            }
            Locker locker = null;
            if (p.getSize() == Size.SMALL) {
                locker = availableSmall.pop();
            } else if (p.getSize() == Size.MIDDLE) {
                locker = availableMiddle.pop();
            } else {
                locker = availableLarge.pop();
            }
            Date date = new Date();
            Receipt receipt= new Receipt(p, locker, date.getTime());
            return receipt;
        }

        private float calcPrice(Receipt t) {
            Date curTime = new Date();
            return (curTime.getTime() - t.startTime) / (60 * 60 * 1000) * hourlyRate;
        }
    }

    class LockerFullException extends Exception {
        public LockerFullException(String s) {
            super(s);
        }
    }
}
```



## Restaurant Reservation

![](.gitbook/assets/image%20%282%29.png)

* reservation info is saved in table in code below
* we record time instead of timeperiod



```java
import java.util.*;

public class RestaurantDesign {
    class Date {
        long time;

        public long getTime() {
            return time;
        }
    }
    class NoTableException extends Exception {
        public NoTableException(Party p) {
            super("No table available for party size: " + p.getSize());
        }
    }

    class Meal {
        private float price;

        public Meal(float price) {
            this.price = price;
        }

        public float getPrice() {
            return this.price;
        }
    }

    class Order {
        private List<Meal> meals;
        private Table table;
        private Party p;

        public Order(List<Meal> meals, Table table, Party p) {
            this.meals = meals;
            this.table = table;
            this.p = p;
        }

        public List<Meal> getMeals() {
            return meals;
        }

        public void mergeOrder(Order order) {
            if (order != null) {
                for (Meal meal : order.getMeals()) {
                    meals.add(meal);
                }
            }
        }

        public float getPrice() {
            int bill = 0;
            for (Meal meal : meals) {
                bill += meal.getPrice();
            }
            return bill;
        }
    }

    class Party {
        private int size;

        public Party(int size) {
            this.size = size;
        }

        public int getSize() {
            return this.size;
        }
    }

    class Table implements Comparable<Table> {
        private int id;
        private int capacity;
        private boolean available;
        private Order order;
        List<Date> reservations;

        public Table(int id, int capacity) {
            this.id = id;
            this.capacity = capacity;
            available = true;
            order = null;
            reservations = new ArrayList<>();
        }

        public int getId() {
            return this.id;
        }

        public int getCapacity() {
            return this.capacity;
        }

        public List<Date> getReservation() {
            return reservations;
        }

        public boolean isAvailable() {
            return this.available;
        }

        public void markAvailable() {
            this.available = true;
        }

        public void markUnavailable() {
            this.available = false;
        }

        public Order getCurrentOrder() {
            return this.order;
        }

        public void setOrder(Order o) {
            if (order == null) {
                this.order = o;
            } else {
                if (o != null) {
                    this.order.mergeOrder(o);
                }
            }
        }

        @Override
        public int compareTo(Table compareTable) {
            return this.capacity - compareTable.getCapacity();
        }

        // find first item that is larger than target
        private int findDatePosition(Date target) {
            int len = reservations.size();
            if (len == 0)
                return 0;
            if (target.getTime() > reservations.get(len - 1).getTime()) {
                return len;
            }

            int l = 0;
            int r = len - 1;

            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (reservations.get(mid).getTime() <= target.getTime()) {
                    l = mid;
                } else {
                    r = mid;
                }
            }

            if (reservations.get(l).getTime() > target.getTime()) {
                return l;
            }
            if (reservations.get(r).getTime() > target.getTime()) {
                return r;
            }

            return len;
        }

        public boolean noFollowReservation(Date d) {
            final int MILLI_TO_HOUR = 1000 * 60 * 60;
            int position = findDatePosition(d);

            if (position < reservations.size()) {
                Date nextReservation = reservations.get(position);
                int diff = (int) ((nextReservation.getTime() - d.getTime()) / MILLI_TO_HOUR);
                if (diff < Restaurant.MAX_DINEHOUR) {
                    return false;
                }
            }
            return true;
        }

        public boolean reserveForDate(Date d) {
            final int MILLI_TO_HOUR = 1000 * 60 * 60;
            int position = findDatePosition(d);
            int before = position - 1;
            int after = position;

            if (before >= 0) {
                Date previousReservation = reservations.get(before);
                int diff = (int) ((d.getTime() - previousReservation.getTime()) / MILLI_TO_HOUR);
                if (diff < Restaurant.MAX_DINEHOUR) {
                    return false;
                }
            }

            if (after < reservations.size()) {
                Date nextReservation = reservations.get(after);
                int diff = (int) ((nextReservation.getTime() - d.getTime()) / MILLI_TO_HOUR);
                if (diff < Restaurant.MAX_DINEHOUR) {
                    return false;
                }
            }

            reservations.add(position, d);
            return true;
        }

        public void removeReservation(Date d) {
            reservations.remove(d);
        }
    }

    class Reservation {
        private Table table;
        private Date date;

        public Reservation(Table table, Date date) {
            this.table = table;
            this.date = date;
        }

        public Date getDate() {
            return date;
        }

        public Table getTable() {
            return table;
        }
    }

    public class Restaurant {
        private List<Table> tables;
        private List<Meal> menu;
        public static final int MAX_DINEHOUR = 2;
        public static final long HOUR = 3600 * 1000;

        public Restaurant() {
            tables = new ArrayList<Table>();
            menu = new ArrayList<Meal>();
        }

        public void findTable(Party p) throws NoTableException {
            Date currentDate = new Date();
            for (Table t : tables) {
                if (t.isAvailable() && t.getCapacity() >= p.getSize() && t.noFollowReservation(currentDate)) {
                    t.markUnavailable();
                    return;
                }
            }
            throw new NoTableException(p);
        }

        public void takeOrder(Order o) {
        }

        public float checkOut(Order order) {
            order.table.markAvailable();
            return order.getPrice();
        }

        public List<Meal> getMenu() {
            return menu;
        }

        public void addTable(Table t) {
            tables.add(t);
            Collections.sort(tables);
        }

        public Reservation findTableForReservation(Party p, Date date) {
            for (Table table : tables) {
                if (table.getCapacity() >= p.getSize() && table.reserveForDate(date)) {
                    return new Reservation(table, date);
                }
            }
            return null;
        }

        public void cancelReservation(Reservation r) {
            Date date = r.getDate();
            r.getTable().removeReservation(date);
        }
    }
}

```

## TicTacToe

```java
public class TicTacToeDesign {
    public class TicTacToe {
        private char[][] board;
        private char currentPlayerMark;
        private boolean gameEnd;
        
        // v2:
        int[] rows;
        int[] cols;
        int diagonal;
        int antiDiagonal;

        public TicTacToe() {
            board = new char[3][3];
            initialize();
        }

        public char getCurrentPlayer() {
            return currentPlayerMark;
        }

        public void initialize() {
            gameEnd = false;
            currentPlayerMark = 'x';

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }
            
            // v2:
            rows = new int[3];
            cols = new int[3];
            diagonal = 0;
            antiDiagonal = 0;
        }

        public boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        return false;
                    }
                }
            }
            gameEnd = true;
            return true;
        }

        public void changePlayer() {
            if (currentPlayerMark == 'x')
                currentPlayerMark = 'o';
            else
                currentPlayerMark = 'x';

        }
        
        // v1:
        public void move(int row, int col, char player) throws AlreadyTakenException, GameEndException{
            if (gameEnd) {
                throw new GameEndException();
            }

            if (board[row][col] != '-') {
                throw new AlreadyTakenException();
            }
            
            board[row][col] = player;
            
            int cur = player == 'x' ? 1 : -1;
            int n = rows.length;
            rows[row] += cur;
            cols[col] -= cur;
            if (row == col) {
                diagonal += cur;
            }
            if (row + col == n - 1) {
                antiDiagonal += cur;
            }
            if (Math.abs(rows[row]) == n ||
                    Math.abs(cols[col]) == n ||
                    Math.abs(diagonal) == n ||
                    Math.abs(antiDiagonal) == n) {
                gameEnd = true;
                System.out.println(player + "wins");
            }
        }

        // v2:
        // true means this move wins the game, false means otherwise
        public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {

            if (gameEnd) {
                throw new GameEndException();
            }

            if (board[row][col] != '-') {
                throw new AlreadyTakenException();
            }

            board[row][col] = currentPlayerMark;

            boolean win;

            //check row
            win = true;
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] != currentPlayerMark) {
                    win = false;
                    break;
                }
            }

            if (win) {
                gameEnd = true;
                return win;
            }

            //check column
            win = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] != currentPlayerMark) {
                    win = false;
                    break;
                }
            }

            if (win) {
                gameEnd = true;
                return win;
            }

            //check back diagonal
            win = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != currentPlayerMark) {
                    win = false;
                    break;
                }
            }

            if (win) {
                gameEnd = true;
                return win;
            }

            //check forward diagonal
            win = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length - i - 1] != currentPlayerMark) {
                    win = false;
                    break;
                }
            }

            if (win) {
                gameEnd = true;
                return win;
            }
            changePlayer();
            return win;
        }
    }


    class GameEndException extends Exception {
        public GameEndException() {
            super("Game has been ended, cannot make any more moves");
        }
    }

    class AlreadyTakenException extends Exception {
        public AlreadyTakenException() {
            super("This place has been taken");
        }
    }
}

```

## Merge Sort

```java
public class MergeSort {
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0)
            return;

        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end)
            return;

        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = leftIndex;

        while (leftIndex <= middle && rightIndex <= end) {
            if (A[leftIndex] < A[rightIndex])
                temp[index++] = A[leftIndex++];
            else
                temp[index++] = A[rightIndex++];
        }

        while (leftIndex <= middle)
            temp[index++] = A[leftIndex++];
        while (rightIndex <= end)
            temp[index++] = A[rightIndex++];

        for (int i = start; i <= end; i++)
            A[i] = temp[i];

    }
}

```

## Quick Sort

```java
public class QuickSort {
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0)
            return;
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end)
            return;

        int l = start;
        int r = end;
        // key1: get the value of pivot, not index
        int pivot = A[(start + end) / 2];
        // key2: l <= r, not l < r
        while (l <= r) {
            // key3: A[l] < pivot, not A[l] <= pivot
            while (l <= r && A[l] < pivot)
                l++;
            while (l <= r && A[r] > pivot)
                r--;
            if (l <= r) {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }
        }

        quickSort(A, start, r);
        quickSort(A, l, end);
    }
}
```

## Quick Select

```java
public class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];

        int l = start;
        int r = end;
        int pivot = nums[(start + end) / 2];
        while (l <= r) {
            while (l <= r && nums[l] > pivot)
                l++;
            while (l <= r && nums[r] < pivot)
                r--;

            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }

        if (start + k - 1 <= r)
            return quickSelect(nums, start, r, k);
        if (start + k - 1 >= l)
            return quickSelect(nums, l, end, k - (l - start));

        return nums[r + 1];
    }
}
```

## Bucket Sort

```java
public class BucketSort {
    public void sort(int[] array, int numberOfBuckets) {
        var i = 0;
        for (var bucket : createBuckets(array, numberOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (var i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : array)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }
}

```

## Bubble Sort

```java
public class BubbleSort {
    public void sort(int[] arr) {
        boolean flag;
        for (int i = arr.length - 1; i >= 1; i--) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                    flag = false;
                }
            }
            if (flag)
                return;
        }
    }

    public void swap(int a, int b, int[] arr) {
        var temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}

```

## Couting Sort

```java

public class CountingSort {
    public static void sort(int[] arr, int max) {
        if (arr == null)
            return;

        var countArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            var key = arr[i];
            countArr[key]++;
        }

        var pointer = 0;
        for (int key = 0; key < countArr.length; key++) {
            var count = countArr[key];
            if (count != 0)
                for (int j = 0; j < count; j++) {
                    arr[pointer] = key;
                    pointer++;
                }
        }

        // compact implementation
        // int[] counts = new int[max + 1];
        // for (var item : array)
        // counts[item]++;

        // var k = 0;
        // for (var i = 0; i < counts.length; i++)
        // for (var j = 0; j < counts[i]; j++)
        // array[k++] = i;
    }
}

```

## MinHeap

{% embed url="https://aaronice.gitbook.io/lintcode/data\_structure/heapify" %}

[https://www.jiuzhang.com/problem/heapify/](https://www.jiuzhang.com/problem/heapify/)

```java
public class Solution {
    class Node {
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] nodes = new Node[20];
    private int size;

    public void insert(int key, int val) {
        if (isFull())
            throw new IllegalArgumentException();
        nodes[size++] = new Node(key, val);
        bubbleUp();
    }

    public int remove(){
        if (isEmpty()) 
            throw new IllegalArgumentException();
        int ret = nodes[0].val;
        nodes[0] = nodes[size - 1];
        size--;

        bubbleDown();

        return ret;
    }

    private void bubbleUp() {
        int i = size - 1;
        while (i > 0 && nodes[i].key < nodes[(i - 1) / 2].key) {
            swap(nodes, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void bubbleDown() {
        int i = 0;
        while (i < size) {
            int smallest = i;
            if (2 * i + 1 < size && nodes[2 * i + 1].key < nodes[smallest].key) {
                smallest = 2 * i + 1;
            }
            if (2 * i + 2 < size && nodes[2 * i + 2].key < nodes[smallest].key) {
                smallest = 2 * i + 2;
            }
            if (smallest == i) {
                break;
            }
            swap(nodes, smallest, i);
            i = smallest;
        }
    }

    private void swap(Node[] arr, int a, int b) {
        Node temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private boolean isFull() {
        return size == nodes.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void heapify(Node[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            siftDown(arr);
        }
    }

    private void siftDown(Node[] arr) {
        int i = 0;
        while (i < arr.length) {
            int smallest = i;
            if (2 * i + 1 < arr.length && nodes[2 * i + 1].val < arr[smallest].val) {
                smallest = 2 * i + 1;
            }
            if (2 * i + 2 < arr.length && nodes[2 * i + 2].val < arr[smallest].val) {
                smallest = 2 * i + 2;
            }
            if (smallest == i) {
                break;
            }
            swap(arr, smallest, i);
            i = smallest;
        }
    }
}
```

## Binary Tree Preorder traversal

```java
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();
        
        if (root == null) {
            return preorder;
        }
        
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return preorder;
    }
```

## Binary Tree Inorder Traversal

```java
public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            result.add(node.val);
            
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }
```

## Binary Tree Postorder traversal 

```java
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null; // previously traversed node
    TreeNode curr = root;

    if (root == null) {
        return result;
    }

    stack.push(root);
    while (!stack.empty()) {
        curr = stack.peek();
        if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
            if (curr.left != null) {
                stack.push(curr.left);
            } else if (curr.right != null) {
                stack.push(curr.right);
            }
        } else if (curr.left == prev) { // traverse up the tree from the left
            if (curr.right != null) {
                stack.push(curr.right);
            }
        } else { // traverse up the tree from the right
            result.add(curr.val);
            stack.pop();
        }
        prev = curr;
    }

    return result;
}
```

