
//Postfix to Infix Conversion using Stack
// Given a postfix expression in the form of string exp. Convert this postfix expression to an infix expression.
// Link: hhttps://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1
// Time complexity: O(n)+ O(n) = O(n)
// Space complexity: O(n)
import java.util.Stack;

class PostfixToInfixSolution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (isOperand(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String temp = '(' + top2 + ch + top1 + ')';
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    private static boolean isOperand(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

}
