
// Infix to Prefix Conversion
// Given an infix expression in the form of string s. Convert this infix expression to a prefix expression.

//Time complexity: O(n)
//Space complexity: O(n)
import java.util.Stack;

class InfixToPrefixSolution {
    private static String reverseString(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                reversed.append(')');
            } else if (ch == ')') {
                reversed.append('(');
            } else {
                reversed.append(ch);
            }
        }
        return reversed.toString();
    }

    public static String infixToPrefix(String s) {
        String reversed = reverseString(s);
        Stack<Character> stack = new Stack<>();

        StringBuilder answer = new StringBuilder();
        for (char ch : reversed.toCharArray()) {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                answer.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    answer.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
                    answer.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }

    private static int priority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '/' || ch == '*') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return -1;
        }
    }

}
