package com.techcrack.dsa.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

class PrefixToPostfix {
    public String prefixToPostfix(String s) {
        Deque<String> stack = new ArrayDeque<>();
        
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) stack.push(ch + "");
            else stack.push(stack.pop() + stack.pop() + ch);
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        PrefixToPostfix obj = new PrefixToPostfix();
        System.out.println(obj.prefixToPostfix("+ab"));
        System.out.println(obj.prefixToPostfix("*+ab-cd"));
        System.out.println(obj.prefixToPostfix("^a*bc"));
    }
}
