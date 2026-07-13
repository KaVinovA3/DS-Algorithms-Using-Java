package com.techcrack.dsa.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

class PostfixToInfix {
    public String postToInfix(String postExp) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < postExp.length(); ++i) {
            char ch = postExp.charAt(i);

            if (Character.isLetterOrDigit(ch)) stack.push(ch + "");
            else {
                String right = stack.pop();
                String left = stack.pop();

                stack.push("(" + left + ch + right + ")");
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        PostfixToInfix obj = new PostfixToInfix();

        System.out.println(obj.postToInfix("ab+"));
        System.out.println(obj.postToInfix("abc*+"));
        System.out.println(obj.postToInfix("abc/-ak/l-*"));
    }
}
