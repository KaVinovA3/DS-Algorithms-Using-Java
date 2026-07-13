package com.techcrack.dsa.graph;

import java.util.*;

public class TopologicalSort {
    private static int[] topologicalSort(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < adj.size(); ++i) {
            if (!visited[i]) {
                dfs(
                        adj,
                        visited,
                        stack,
                        i
                );
            }
        }

        int[] res = new int[stack.size()];

        for (int i = 0; i < res.length; ++i) {
            res[i] = stack.pop();
        }

        return res;
    }
    private static void dfs(List<List<Integer>> adjList, boolean[] visited, Deque<Integer> stack, int node) {
        visited[node] = true;

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(
                        adjList,
                        visited,
                        stack,
                        neighbour
                );
            }
        }

        stack.push(node);
    }

    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
//        adj.get(5).add(2);

        System.out.println(Arrays.toString(topologicalSort(adj)));
    }
}
