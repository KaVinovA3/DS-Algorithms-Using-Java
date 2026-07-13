package com.techcrack.dsa.stackAndQueue;

import java.util.Stack;

public class InfixToPostfix {
    private int getPrecedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 4;
        };
    }

    private boolean isOperator(char ch) {
        return  ch == '+' || ch == '-' ||
                ch == '*' || ch == '/' ||
                ch == '^';
    }

    public String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) sb.append(ch);
            else if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                while (stack.peek() != '(') sb.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() &&
                        (getPrecedence(stack.peek()) > getPrecedence(ch) ||
                                (getPrecedence(stack.peek()) == getPrecedence(ch) &&
                                        ch != '^')))
                    sb.append(stack.pop());
                stack.push(ch);
            }
        }

        return sb.toString();
    }
}
