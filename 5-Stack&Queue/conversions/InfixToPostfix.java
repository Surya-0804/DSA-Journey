//Infix to Postfix Conversion
//Given an infix expression in the form of string s. Convert this infix expression to a postfix expression.
//link: https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
//time complexity: O(n)
//space complexity: O(n)

import java.util.Stack;

class infixToPostfixSolution {
    public static String infixToPostfix(String s) {
        // code here
        Stack<Character> stack = new Stack<>();

        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
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

        return answer.toString();
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