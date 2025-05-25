//Postfix to Infix Conversion
// Given a postfix expression in the form of string post_exp. Convert this postfix expression to a prefix expression.
// Link: https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1

// Time complexity: O(n)
// Space complexity: O(n)
import java.util.Stack;

class PostfixToPrefix {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> stack = new Stack<>();

        for (char ch : post_exp.toCharArray()) {

            if (isOperand(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String temp = ch + top2 + top1;
                stack.push(temp);
            }
        }
        return stack.pop();

    }

    private static boolean isOperand(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
