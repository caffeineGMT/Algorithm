import java.util.*;

import java.lang.*;
import java.time.format.TextStyle;

class Solution {
    public static List<Integer> getTimes(int numWorker, List<Integer> arrTime, List<Integer> direction) {
        Queue<Integer> load = new ArrayDeque<>();
        Queue<Integer> unload = new ArrayDeque<>();
        for (int i = 0; i < numWorker; i++) {
            if (direction.get(i) == 0) {
                load.offer(i);
            } else {
                unload.offer(i);
            }
        }

        Integer[] result = new Integer[numWorker];
        int curTime = -1;
        int prevState = -1;
        while (!load.isEmpty() && !unload.isEmpty()) {
            int loadID = load.peek();
            int unloadID = unload.peek();
            int curLoadTime = Math.max(curTime, arrTime.get(loadID));
            int curUnloadTime = Math.max(curTime, arrTime.get(unloadID));

            if (curLoadTime < curUnloadTime) {
                result[loadID] = curLoadTime;
                prevState = 0;
                load.poll();
                curTime = curLoadTime + 1;
            } else if (curLoadTime > curUnloadTime) {
                result[unloadID] = curUnloadTime;
                prevState = 1;
                unload.poll();
                curTime = curUnloadTime + 1;
            } else {
                if (curLoadTime > curTime + 1) {
                    result[unloadID] = curUnloadTime;
                    prevState = 1;
                    unload.poll();
                    curTime = curUnloadTime + 1;
                } else if (prevState == 1) {
                    result[unloadID] = curUnloadTime;
                    prevState = 1;
                    unload.poll();
                    curTime = curUnloadTime + 1;
                } else if (prevState == 0) {
                    result[loadID] = curLoadTime;
                    prevState = 0;
                    load.poll();
                    curTime = curLoadTime + 1;
                }
            }
        }

        Queue<Integer> q = load.isEmpty() ? unload : load;
        while (!q.isEmpty()) {
            int id = q.poll();
            curTime = Math.max(curTime, arrTime.get(id));
            result[id] = curTime;
            curTime++;
        }
        Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
        List<Integer> targetList = Arrays.asList(sourceArray);
        List<Integer> a = Arrays.asList(result);
        return a;
    }

    public static void main(String[] args) {
        // List<List<Integer>> ranges = new ArrayList<>();
        // ranges.add(new ArrayList<Integer>());
        // var range = ranges.get(0);
        // range.add(1);
        // range.add(3);
        // var result = numberOfItems("||||||", ranges);
        // System.out.println(result);
        List<List<Integer>> ratings = new ArrayList<>();
        var a = new ArrayList<Integer>();
        a.add(4);
        a.add(4);
        var b = new ArrayList<Integer>();
        b.add(1);
        b.add(2);
        var c = new ArrayList<Integer>();
        c.add(3);
        c.add(6);

        ratings.add(a);
        ratings.add(b);
        ratings.add(c);

        int[] d = { 1, 2, 3, 4 };
        var e = Arrays.asList(d);
        System.out.println(e);
    }
}
