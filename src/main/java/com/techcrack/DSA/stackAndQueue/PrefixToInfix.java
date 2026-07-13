package com.techcrack.dsa.stackAndQueue;

import java.util.Stack;

public class PrefixToInfix {
    public String prefixToInfix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) stack.push("" + ch);
            else {
                String left = stack.pop();
                String right = stack.pop();
                stack.push("(" + left + ch + right + ")");
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        PrefixToInfix obj = new PrefixToInfix();
        System.out.println(obj.prefixToInfix("+ab"));
        System.out.println(obj.prefixToInfix("*+ab-cd"));
        System.out.println(obj.prefixToInfix("^a*bc"));
    }
}