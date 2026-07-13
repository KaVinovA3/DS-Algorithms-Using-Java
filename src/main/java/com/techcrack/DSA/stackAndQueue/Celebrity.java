package com.techcrack.dsa.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

class Celebrity {
    public int celebrity(int[][] M) {
      int n = M.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) stack.push(i);

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (M[a][b] == 1) stack.push(b);
            else stack.push(a);
        }

        int candidate = stack.pop();

        for (int i = 0; i < n; ++i) {
            if (i == candidate) continue;
            if (M[i][candidate] == 0 || M[candidate][i] == 1) return -1;
        }

        return candidate;
    }
}