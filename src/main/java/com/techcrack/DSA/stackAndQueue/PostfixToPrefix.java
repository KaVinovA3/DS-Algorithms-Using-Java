package com.techcrack.dsa.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

class PostfixToPrefix {
    public String postToPre(String postfix) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < postfix.length(); ++i) {
            char ch = postfix.charAt(i);

            if (Character.isLetterOrDigit(ch)) stack.push(ch + "");
            else {
                String right = stack.pop();
                String left = stack.pop();

                stack.push(ch + left + right);
            }
        }

        return stack.peek();
    }
    public static void main(String[] args) {
        PostfixToPrefix obj = new PostfixToPrefix();
        System.out.println(obj.postToPre("ab+"));
        System.out.println(obj.postToPre("abc*+d-"));
        System.out.println(obj.postToPre("xyz*+ab/-"));
    }

}