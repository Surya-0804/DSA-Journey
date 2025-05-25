
// Given a prefix expression, convert it to a postfix expression.
// Link: https://www.geeksforgeeks.org/problems/prefix-to-postfix-conversion/1
// Time complexity: O(n)
// Space complexity: O(n)
import java.util.Stack;

class PrefixToPostfixSolution {

    static String preToPost(String pre_exp) {
        // code here
        Stack<String> stack = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);
            if (isOperand(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String temp = top1 + top2 + ch;
                stack.push(temp);
            }
        }
        return stack.pop();

    }

    private static boolean isOperand(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

}
