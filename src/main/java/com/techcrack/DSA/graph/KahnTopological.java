package com.techcrack.dsa.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class KahnTopological {
    private List<Integer> bfs(int[][] edges, int nodes) {
        int[] degree = new int[nodes];

        for (int[] edge : edges) {
            degree[edge[1]]++;
        }

        List<List<Integer>> adjacencyList = buildAdjacencyList(edges, nodes);

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nodes; ++i) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int neighbour : adjacencyList.get(node)) {
                degree[neighbour]--;

                if (degree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return ans.size() == nodes ? ans : null;
    }

    private List<List<Integer>> buildAdjacencyList(int[][] edges, int nodes) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        return adj;
    }
}
