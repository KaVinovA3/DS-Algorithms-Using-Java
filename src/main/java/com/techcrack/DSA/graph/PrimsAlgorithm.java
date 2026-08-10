package com.techcrack.dsa.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Edge {
        public int source, weight, parent;

        public Edge(int source, int weight, int parent) {
            this.source = source;
            this.weight = weight;
            this.parent = parent;
        }
    }

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(s  -> s.weight));
        boolean[] visited = new boolean[V];

        int minSum = 0;

        queue.offer(new Edge(0, 0, -1));

        while (! queue.isEmpty()) {
            Edge current = queue.poll();

            if (visited[current.source]) {
                continue;
            }

            if (current.parent != -1) {
                minSum += current.weight;
            }

            visited[current.source] = true;

            for (List<Integer> edge : adj.get(current.source)) {
                if (!visited[edge.get(0)]) {
                    queue.offer(new Edge(edge.get(0), edge.get(1), current.source));
                }
            }
        }

        return minSum;
    }
}
