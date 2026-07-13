package com.techcrack.dsa.graph;

import java.util.*;

class CycleDetection {
    static class Pair {
        public int node;
        public int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isCycle(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; ++i) {
            if (!visited[i]) {
                if (dfs(adj, i, -1 ,  visited)) {
                    visited[i] = true;
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(List<List<Integer>> adj, int curNode, int parent, boolean[] visited) {
        for (int neighbour : adj.get(curNode)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;

                if (dfs(adj, neighbour, curNode, visited)) {
                    return true;
                }
            } else if (parent != neighbour) {
                return true;
            }
        }

        return false;
    }

    private boolean bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        visited[start] = true;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(start, -1));

        while (!queue.isEmpty()) {
            Pair curNode = queue.poll();

            int node = curNode.node;
            int parent = curNode.parent;

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(new Pair(neighbour, node));
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}