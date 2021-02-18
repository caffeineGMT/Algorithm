# LeetCode & LintCode

## DP

#### 322. Coin ChangeMedium6038183Add to ListShare

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

You may assume that you have an infinite number of each kind of coin.

**Example 1:**

```text
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

**Example 2:**

```text
Input: coins = [2], amount = 3
Output: -1
```

**Example 3:**

```text
Input: coins = [1], amount = 0
Output: 0
```

**Example 4:**

```text
Input: coins = [1], amount = 1
Output: 1
```

**Example 5:**

```text
Input: coins = [1], amount = 2
Output: 2
```

**Constraints:**

* `1 <= coins.length <= 12`
* `1 <= coins[i] <= 231 - 1`
* `0 <= amount <= 104`

```java
class Solution {
    // v1: 2d array without any optimization
    public int coinChange(int[] coins, int amount) {
        // amount can be 0
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        
        int len = coins.length;
        
        int[][] dp = new int[len + 1][amount + 1];
        for (int j = 1; j <= amount; j++) {
            // cannot initialize to Integer.MAX_VALUE because later on we will potentially add some count to previous state, and count can be as large as 2^31 - 1, which will result in overflow.
            dp[0][j] = amount + 1;
        } 
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                
                int min = dp[i - 1][j];
                for (int count = 1; count <= j / coins[i - 1]; count++) {
                    min = Math.min(min,
                                   dp[i - 1][j - count * coins[i - 1]] + count);
                }
                dp[i][j] = min;
            }
        }
        
        if (dp[len][amount] == amount + 1) {
            return -1;
        }
        return dp[len][amount];
    }
    
    // v2: with time and space optimization
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        
        int len = coins.length;
        
        int[][] dp = new int[2][amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[0 % 2][j] = amount + 1;
        } 
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                    continue;
                }
                
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j],
                                        dp[i % 2][j - coins[i - 1]] + 1);
            }
        }
        
        return dp[len % 2][amount] == amount + 1 ? -1 : dp[len % 2][amount];
    }
}
```



