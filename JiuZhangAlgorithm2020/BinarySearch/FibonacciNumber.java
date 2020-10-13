/**
 * LeetCode 509
 * 
 * https://leetcode.com/problems/fibonacci-number/
 */

public class FibonacciNumber {
    // solution 1
    public int fib1(int N) {
        if (N <= 1) {
            return N;
        }
        return fib1(N - 1) + fib1(N - 2);
    }

    // solution 2
    public int fib2(int N) {
        if (N <= 1)
            return N;

        int prev1 = 0;
        int prev2 = 1;
        int cur = 0;

        for (int i = 2; i <= N; i++) {
            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }

        return cur;
    }

    // solution 3
    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    public int memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }

    // solution 4
    // private Integer[] cache = new Integer[31];

    // public int fib(int N) {
    // if (N <= 1) {
    // return N;
    // }
    // cache[0] = 0;
    // cache[1] = 1;
    // return memoize(N);
    // }

    // public int memoize(int N) {
    // if (cache[N] != null) {
    // return cache[N];
    // }
    // cache[N] = memoize(N-1) + memoize(N-2);
    // return memoize(N);
    // }

    public static void main(String[] args) {

    }
}
