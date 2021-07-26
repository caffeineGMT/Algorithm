# Dialpad

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int getMin(String str) {
        int min = Integer.MAX_VALUE;
        int a = dna(str, 'a', 'A');
        int b = dna(str, 'b', 'B');
        int c = dna(str, 'c', 'C');
        min = Math.min(a, b);
        min = Math.min(min, c);
        return min;
    }

    public static int dna(String str, char ch1, char ch2) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // aAbB
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ch1 || ch == ch2) {
                continue;
            }
            if (sb.length() == 0) {
                sb.append(ch);
                continue;
            }
            char chSB = sb.charAt(sb.length() - 1);
            if (Character.isLowerCase(ch) && Character.isUpperCase(chSB) && ch - 'a' == chSB - 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (Character.isUpperCase(ch) && Character.isLowerCase(chSB) && ch - 'A' == chSB - 'a') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        
        return sb.length();
    }

 public static void main(String[] args) {
        int res = dna("abAcCaCBAcCcaA", 'b', 'B');
        System.out.println(res);
   }
}

/*
Given a long DNA string consisting of 3 possible units [‘a’, ‘b’, ‘c’], return the final DNA after the reaction process has been completed.

There are 3 units' types represented by letters  [‘a’, ‘b’, ‘c’]
Each unit type has exactly one polarity represented by capitalization [‘A’, ‘B’, ‘C’].

Reaction process:
The DNA string is formed by smaller units which, when triggered, react with each other such that two adjacent units of the same type and opposite polarity are destroyed. 
For instance, a and A are units with the same type but opposite polarity, whereas a and b are entirely different types and do not react.

Examples (Test Cases)
Input -> Output
‘aA’ -> ‘’
‘ab’ -> ‘ab’
*/

/*
Input: ‘aA’ 
Output: ‘’
Explanation: ‘a’ will then react with ‘A’, leaving nothing behind. 

Input: ‘abBA’
Output: ‘’
Explanation: ‘b’ will react with ‘B’, leaving ‘aA’. Then, ‘a’ will then react with ‘A’, leaving nothing behind. 

Input: ‘abAB’
Output: ‘abAB’
Explanation: no two adjacent units are of the same type, and so nothing happens.

Input: ‘aabAAB’
Output: ‘aabAAB’
Explanation: even though aa and AA are of the same type, their polarities match, and so nothing happens.

Input: ‘’
Output: ‘’
*/

/*
What is the length of the shortest DNA string you can produce by removing all units of exactly one type and fully reacting the result (e.g. removing all c/C -> React)?

Input: ‘abAcCaCBAcCcaA’
// bCBc
Output: 0
Explanation:
Try Removing ‘a/A’ -> ‘bcCCBcCc’ -> ‘bCBc’ -> 4
Try Removing ‘b/B’ -> ‘aAcCaCAcCcaA’ -> ‘aCAc’ -> 4
Try Removing ‘c/C’ -> ‘abAaBAaA’ -> ‘’ -> 0
From above, removing ‘c/C’ results in the shortest DNA string ‘’. Therefer, we should remove unit ‘c’.
*/
```

```java
/*
Problem:
You're the fire marshal of your floor and you've been tasked with determining if the sprinkler setup covers the whole floor-plan. 
Your boss gives you a map of your floor plan as a 2D array of 1's and 0's where 1's represent sprinkler locations. Given this 2D array 
and a radius that each sprinkler can cover, determine if the given sprinkler layout covers the whole floor.
For the sake of simplicity, assume the sprinklers spray in a cross rather than a circular pattern.
 
Example 1:
 
Radius: 2
Floor plan:
1 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 1 0
0 0 0 0 0
 
Output: False
 
Explanation:
The sprinkler layout only covers these spots (the ones with numbers)
1 0 0 - -
0 - - 0 -
0 - - 0 -
- 0 0 1 0
- - - 0 -
 
 
Example 2:
 
Radius: 1
0 0 0 0
1 1 1 1
0 0 0 0
 
Output: True
The sprinkler layout covers the whole floor plan
*/

public boolean canCover(int[][] matrix, int radius) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || radius <= 0) return false;
    
    int m = matrix.length, n = matrix[0].length;
    
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] != 1) continue;
            for (int i = 0; i < 4; i++) { 
                for (int j = 1; j <= radius; j++) {
                    int nx = cur[0] + dx[i] * j, ny = cur[1] + dy[i] * j;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == 1) continue;
                    matrix[nx][ny] = 2;
                }
            }
        }
    }
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0) return false;
        }
    }
    
    return true;
}

```

```java





Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following features:

- post a new tweet.
- Follower follows a followee.
- Follower unfollows a followee.
- get news feed: Retrieve the 10 most recent tweets in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.

func: as listed
no-func: 10k DAU

tweet: 
id, user_id, timestamp, content, img_url

user: 
id, name, email, password, location, isCelebrity

follow_table:
follower_id, followee_id

input: userId
SELECT * from follow_table where follower_id == user_id 
SELECT * from tweet_table where user_id == followee_id Desc Limit 10 
10 friends -> 100 tweets, merge 10 sorted list based on timestamp -> get first 10 tweets
user_id -> followees -> 

avg: following 200 users
assume: 140 chars for a tweet
img: 5M
read: 20 times refresh of newsfeed a day
write: 2 tweets a day

10m users

read: 10^7 * (20 * 10 * 140 + 4 * 10 * 5 * 10 ^ 6) / 86400 
10 ^ 7 * 20 * (n * 10)

user_id -> List<Tweet> list 

bob has 300 followers

elon musk 2m followers


```

