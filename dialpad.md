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

