/* LeetCode 1154 

Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.
Example 2:

Input: date = "2019-02-10"
Output: 41
Example 3:

Input: date = "2003-03-01"
Output: 60
Example 4:

Input: date = "2004-03-01"
Output: 61
 

Constraints:

date.length == 10
date[4] == date[7] == '-', and all other date[i]'s are digits
date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019. */

public class DayOfTheYear {
    public static int dayOfYear(String date) {
        // data validation

        // data parsing
        String[] str_YMD = date.split("-");
        int year = Integer.parseInt(str_YMD[0]);
        int months = Integer.parseInt(str_YMD[1]);
        int extra_days = Integer.parseInt(str_YMD[2]);

        // if leap year, the second month would be 29 days, change it in month record
        var months_record = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year % 4 == 0 && year % 100 != 0) {
            months_record[1] = 29;
        } else if (year % 400 == 0)
            months_record[1] = 29;

        // loop over the month record and plus the extra days
        int total_days = 0;
        for (int i = 0; i < months - 1; i++) {
            total_days += months_record[i];
        }
        total_days += extra_days;

        // return result
        return total_days;
    }

    public static void main(String[] args) {
        var date = "2019-01-09";
        System.out.println(dayOfYear(date));
    }

    // note: leap year check could be separated as another function
    // boolean checkYear(int year) {
    // if (year % 400 == 0)
    // return true;
    // if (year % 100 == 0)
    // return false;
    // if (year % 4 == 0)
    // return true;
    // return false;
    // }

}
