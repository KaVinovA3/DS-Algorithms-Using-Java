package com.techcrack.dsa.graph;

import java.util.*;


public class FloydWarshallNeed {
    static class State {
        public int node;
        public int cost;

        public State(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

    }
    public void shortestDistance(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            applyDijkstraAlgorithm(matrix, i);
        }
    }

    public void applyDijkstraAlgorithm(int[][] matrix, int curNode) {
        int[] curDist = new int[matrix.length];

        Arrays.fill(curDist, Integer.MAX_VALUE);
        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));

        for (int i = 0; i < matrix.length; ++i) {
            curDist[i] = matrix[curNode][i] == -1 ? Integer.MAX_VALUE : matrix[curNode][i];

            if (curDist[i] != Integer.MAX_VALUE)
                queue.offer(new State(i, curDist[i]));
        }


        while (!queue.isEmpty()) {
            State current = queue.poll();

            for (int i = 0; i < matrix.length; ++i) {
                if (matrix[current.node][i] != -1 && current.node != i) {
                    int newCost = current.cost + matrix[current.node][i];

                    if (newCost < curDist[i]) {
                        curDist[i] = newCost;

                        queue.offer(new State(i, newCost));
                    }
                }
            }
        }

        System.arraycopy(curDist, 0, matrix[curNode], 0, matrix.length);
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 2, -1, -1},{1, 0, 3, -1},{-1, -1, 0, 1},{3, 5, 4, 0}};
        new FloydWarshallNeed().shortestDistance(matrix);

        for (int[] mat : matrix) {
            System.out.println(Arrays.toString(mat));
        }
    }
}
