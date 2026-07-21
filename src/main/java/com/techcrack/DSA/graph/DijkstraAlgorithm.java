package com.techcrack.dsa.graph;

import java.util.*;

import com.techcrack.dsa.graph.ShortestPathDAG.Pair;

public class DijkstraAlgorithm {
    public int[] algoUsingPriorityQueue(List<List<Integer>> edges, int V, int S) {
        List<List<Pair>> adjList = buildGraph(edges, V);

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.weight)
        );

        queue.offer(new Pair(S, 0));

        while (! queue.isEmpty()) {
            Pair cur = queue.poll();

            if (cur.weight > dist[cur.node])
                continue;

            for (Pair pair : adjList.get(cur.node)) {
                int weight = cur.weight + pair.weight;

                if (weight < dist[pair.node]) {
                    dist[pair.node] = weight;

                    queue.offer(new Pair(pair.node, weight));
                }
            }
        }

        return dist;
    }

    private List<List<Pair>> buildGraph(List<List<Integer>> edges, int V) {
        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < V; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(new Pair(edge.get(1), edge.get(2)));
            adjList.get(edge.get(1)).add(new Pair(edge.get(0), edge.get(2)));
        }

        return adjList;
    }

    public static void main(String[] args) {

    }
}
