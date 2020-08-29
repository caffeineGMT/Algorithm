
/* LeetCode=278 
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.  */

class VersionControl {
    public static int badVersion = 5;

    public static boolean isBadVersion(int version) {
        if (badVersion == version)
            return true;
        return false;
    }
}

public class FirstBadVersion {

    private boolean[] arr = { false, false, false, true, true, true, true };

    private boolean isBadVersion(int version) {
        return arr[version];
    }

    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int left, int right) {
        if (left == right && isBadVersion(left)) {
            return left;
        }
        if (left == right && !isBadVersion(left)) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (isBadVersion(middle) == true) {
            return firstBadVersion(left, middle);
        } else {
            return firstBadVersion(middle + 1, right);
        }
    }

    public static void main(String[] args) {
        var object = new FirstBadVersion();
        System.out.println(object.firstBadVersion(5));
    }

}