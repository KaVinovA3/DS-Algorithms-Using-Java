package com.techcrack.dsa.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPrefix {
    private int getPrecedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default ->  -1;
        };
    }

    public String infixToPrefix(String exp) {
        Deque<String> operand = new ArrayDeque<>();
        Deque<Character> operator = new ArrayDeque<>();

        for (int i = 0; i < exp.length(); ++i) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) operand.push(ch + "");
            else if (ch == '(') operator.push(ch);
            else if (ch == ')') {
                while (! operator.isEmpty() && operator.peek() != '(') {
                    String right = operand.pop();
                    String left = operand.pop();

                    operand.push(
                            new StringBuilder()
                                    .append(operator.pop())
                                    .append(left)
                                    .append(right)
                                    .toString()
                    );
                }

                operator.pop();
            } else {
                while (!operator.isEmpty() && getPrecedence(operator.peek()) >= getPrecedence(ch)) {
                    String right = operand.pop();
                    String left = operand.pop();

                    operand.push(
                            new StringBuilder()
                                    .append(operator.pop())
                                    .append(left)
                                    .append(right)
                                    .toString()
                    );
                }

                operator.push(ch);
            }
        }

        while (!operator.isEmpty()) {
            String right = operand.pop();
            String left = operand.pop();

            operand.push(
                    new StringBuilder()
                            .append(operator.pop())
                            .append(left)
                            .append(right)
                            .toString()
            );
        }
        return operand.pop();
    }

    public static void main(String[] args) {
        InfixToPrefix obj = new InfixToPrefix();

        System.out.println(obj.infixToPrefix("(a+b)*c"));
        System.out.println(obj.infixToPrefix("a+b*c"));
        System.out.println(obj.infixToPrefix("((a-(b/c))*((a/k)-l))"));

    }
}
