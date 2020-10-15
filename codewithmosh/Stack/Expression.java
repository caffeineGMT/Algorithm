import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> leftBrackets = Arrays.asList('(', '[', '<', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '>', '}');

    public boolean isBalanced(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (isLeftBrackets(ch))
                stack.push(ch);
            if (isRightBrackets(ch)) {
                if (stack.empty())
                    return false;

                var left = stack.pop();
                if (!bracketMatch(left, ch))
                    return false;
            }
        }
        return stack.empty();
    }

    private boolean isLeftBrackets(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBrackets(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    public static void main(String[] args) {
        var test = new Expression();
        var str = ")({[1]+2}";
        var result = test.isBalanced(str);
        System.out.println(result);
    }
}