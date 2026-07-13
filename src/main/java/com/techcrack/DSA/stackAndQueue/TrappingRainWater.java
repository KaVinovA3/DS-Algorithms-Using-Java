package com.techcrack.dsa.stackAndQueue;

import java.util.*;

class TrappingRainWater {

    public int trap(int[] height) {

        int n = height.length;

        int water = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Current bar is taller
            while (!stack.isEmpty() &&
                    height[i] > height[stack.peek()]) {

                int valley = stack.pop();

                // No left boundary
                if (stack.isEmpty()) {
                    break;
                }

                int leftWall = stack.peek();

                int width = i - leftWall - 1;

                int boundedHeight =
                        Math.min(height[leftWall], height[i])
                                - height[valley];

                water += width * boundedHeight;
            }

            stack.push(i);
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();

        System.out.println(obj.trap(new int[] {4, 0, 0, 0, 6}));
    }
}