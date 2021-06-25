# Follow-ups

## add strings III / add 2 numbers with linkedlist / substract 2 numbers

```java
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.add("0", "-9"));
        System.out.println(solution.add("10", "-9"));
        System.out.println(solution.add("29", "99"));
        System.out.println(solution.add("-10", "-9"));
        System.out.println(solution.add("-1000", "2"));
        System.out.println(solution.add("-1000", "1000"));
    }
    
    public String add(String num1, String num2) {
        // 1st case: both are positive
        if (!isNegative(num1) && !isNegative(num2)) return addStrings(num1, num2);
        // 2nd case: both are negative
        else if (isNegative(num1) && isNegative(num2)) return "-" + addStrings(num1.substring(1), num2.substring(1));
        // 3rd case: one of number is negative, let's make num1 > 0, non-negative
        else if (isNegative(num1)) { 
            String temp = num1; num1 = num2; num2 = temp; 
        }
        num2 = num2.substring(1); // call out, remove sign before doing calculation
        int compareRes = compareNums(num1, num2);
        if (compareRes == 0) return "0";
        else if (compareRes == 1) return subtractString(num1, num2);
        else return "-" + subtractString(num2, num1);
    }


    private String addStrings(String num1, String num2) {
        // assert num1 >= 0, num2 >= 0
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1){
            int x = i < 0 ? 0 : Character.digit(num1.charAt(i), 10);
            int y = j < 0 ? 0 : Character.digit(num2.charAt(j), 10);
            int digitSum = x + y + carry;
            // call out, record carry first, then update digitSum
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            sb.append(digitSum);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    private String subtractString(String num1, String num2) {
        // assert num1 >= num2 >= 0
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1){
            int x = i < 0 ? 0 : Character.digit(num1.charAt(i), 10);
            int y = j < 0 ? 0 : Character.digit(num2.charAt(j), 10);
            int digitRes = x - y - carry;
            if (digitRes < 0) {
                carry = 1;
                digitRes += 10;
            } else {
                carry = 0;
            }
            sb.append(digitRes);
            i--;
            j--;
        }
        // call out, there might be leading zeros
        return sb.reverse().toString().replaceFirst("^0+(?!$)", ""); 
    }

    private int compareNums(String num1, String num2) {
        // compare len
        int len1 = num1.length(), len2 = num2.length();
        if (len1 < len2) return -1;
        else if (len1 > len2) return 1;
        else { // (len1 == len2) 
            // compare first char
            if (len1 == 0) return 0;
            else if (num1.charAt(0) < num2.charAt(0)) return -1;
            else if (num1.charAt(0) > num2.charAt(0)) return 1;
            else return compareNums(num1.substring(1), num2.substring(1));
        }
    }

    private boolean isNegative(String num) {
        // assert num not empty and is valid
        return num.charAt(0) == '-';
    }
}
```



