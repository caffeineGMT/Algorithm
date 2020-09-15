import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StringUtils {

    public static int findVowels(String str) {
        if (str == null)
            return 0;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        var lowercaseStr = str.toLowerCase();
        var count = 0;
        for (char ch : lowercaseStr.toCharArray())
            if (set.contains(ch))
                count++;

        return count;

        // other string check method:
        // 1: str.indexOf(ch)!=-1
        // 2: str.contains (Character.toString(ch))

    }

    public static String reverseString(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for (Character ch : str.toCharArray())
            stack.push(ch);
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();

        // solution 2: string is immutable, every time we concat a string, we created a
        // new string and copied over old chars, this is O(n) runtime complexity. So we
        // use StringBuilder. The append operation is O(1)

        // if (str == null)
        // return "";

        // StringBuilder reversed = new StringBuilder();
        // for (var i = str.length() - 1; i >= 0; i--)
        // reversed.append(str.charAt(i));

        // return reversed.toString();
    }

    public static String reverseWords(String str) {
        // if (str == null)
        // throw new IllegalArgumentException();

        // String[] words = str.trim().split(" ");
        // StringBuilder reversed = new StringBuilder();

        // for (int i = words.length - 1; i >= 0; i--) {
        // reversed.append(words[i]);
        // if (i != 0)
        // reversed.append(" ");
        // }

        // return reversed.toString();

        // solution 2:
        // split method won't remove the leading empty space
        String[] words = str.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        if (str1.length() != str2.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        var length = str1.length();

        for (int i = 0; i < length; i++) {
            if (i == length - 1)
                map.put(str1.charAt(i), str1.charAt(0));
            else
                map.put(str1.charAt(i), str1.charAt(i + 1));
        }

        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                if (map.get(str2.charAt(i)) != str2.charAt(0))
                    return false;
            } else {
                if (map.get(str2.charAt(i)) != str2.charAt(i + 1))
                    return false;
            }
        }

        return true;

        // solution 2: repeat str1 on itself and check if str2 is the substring of this
        // double str1
        // if (str1 == null || str2 == null)
        // return false;

        // return (str1.length() == str2.length() && (str1 + str1).contains(str2));

        // solution 3: using double pointers
    }

    public static String removeDuplicates(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        Set<Character> set = new HashSet<>();
        StringBuilder output = new StringBuilder();
        for (var ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                output.append(ch);
                set.add(ch);
            }
        }

        return output.toString();
    }

    public static char getMaxOccuringChar(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        Map<Character, Integer> map = new HashMap<>();
        for (var ch : str.toCharArray()) {
            map.putIfAbsent(ch, 1);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
                // map.replace(ch, map.get(ch) + 1); // this is same as put
            }
        }

        var result = str.charAt(0);
        for (var ch : map.keySet())
            if (map.get(ch) > map.get(result))
                result = ch;

        return result;

        // solution 2: when we are asked not to use hashmap. We could use ASCII code as
        // the key of array, array value as count

        // if (str == null || str.isEmpty())
        // throw new IllegalArgumentException();

        // final int ASCII_SIZE = 256;
        // int[] frequencies = new int[ASCII_SIZE];
        // for (var ch : str.toCharArray())
        // frequencies[ch]++;

        // int max = 0;
        // char result = ' ';
        // for (var i = 0; i < frequencies.length; i++)
        // if (frequencies[i] > max) {
        // max = frequencies[i];
        // result = (char) i;
        // }

        // return result;
    }

    public static String capitalize(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            throw new IllegalArgumentException();

        var wordArray = sentence.trim().replaceAll(" +", " ").split(" ");

        for (var i = 0; i < wordArray.length; i++)
            wordArray[i] = wordArray[i].substring(0, 1).toUpperCase() + wordArray[i].substring(1).toLowerCase();

        return String.join(" ", wordArray);
    }

    public static boolean areAnagrams(String first, String second) {
        // solution1 : using hashtable. O(n)

        if (first == null || second == null)
            return false;
        if (first.length() != second.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (var ch : first.toCharArray()) {
            map1.putIfAbsent(ch, 1);
            map1.replace(ch, map1.get(ch) + 1);
        }
        for (var ch : second.toCharArray()) {
            map2.putIfAbsent(ch, 1);
            map2.replace(ch, map2.get(ch) + 1);
        }

        for (var ch : second.toCharArray())
            if (map2.get(ch) != map1.get(ch))
                return false;

        return true;

        // solution 2: using sort. quick Sort is used. O(n log n)
        // if (first == null || second == null)
        // return false;

        // var array1 = first.toLowerCase().toCharArray();
        // Arrays.sort(array1);

        // var array2 = second.toLowerCase().toCharArray();
        // Arrays.sort(array2);

        // return Arrays.equals(array1, array2);

        // solution 3: using ASCII code. O(n)
        // if (first == null || second == null)
        // return false;

        // final int ENGLISH_ALPHABET = 26;
        // int[] frequencies = new int[ENGLISH_ALPHABET];

        // first = first.toLowerCase();
        // for (var i = 0; i < first.length(); i++)
        // frequencies[first.charAt(i) - 'a']++;

        // second = second.toLowerCase();
        // for (var i = 0; i < second.length(); i++) {
        // var index = second.charAt(i) - 'a';
        // if (frequencies[index] == 0)
        // return false;

        // frequencies[index]--;
        // }

        // return true;
    }

    public static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        if (str == "")
            return true;

        var p1 = 0;
        var p2 = str.length() - 1;

        for (var i = 0; i < str.length() / 2; i++) {
            if (str.charAt(p1) != str.charAt(p2))
                return false;
            p1++;
            p2--;
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "";
        // String test2 = "dabcdd";
        // var words = test.split(" ");
        // System.out.println("'" + Arrays.toString(words) + "'");
        // System.out.println("'" + reverseWords(test) + "'");
        // System.out.println(removeDuplicates(test2));
        System.out.println(isPalindrome(test1));

    }
}
