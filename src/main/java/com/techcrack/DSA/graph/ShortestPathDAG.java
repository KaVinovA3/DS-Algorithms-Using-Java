package com.techcrack.dsa.graph;

import java.util.*;

public class ShortestPathDAG {
    private List<List<Integer>> buildGraph(int[][] weights, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < weights.length; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);

            weights[edge[0]][edge[1]] = edge[2];
        }

        return adjList;
    }

    // This not much efficient due to re compute when we change dist to calculate all child
    public int[] shortestPathNotRecommend(int N, int M, int[][] edges) {
        int[][] weights = new int[N][N];

        List<List<Integer>> adjList = buildGraph(weights, edges);
        int[] ans = new int[N];

        Arrays.fill(ans, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(0);

        ans[0] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbour : adjList.get(node)) {
                if (ans[neighbour] == -1) {
                    ans[neighbour] = ans[node] + weights[node][neighbour];
                    queue.offer(neighbour);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] edges =  {{0,1,2},{0,2,1}};

        System.out.println(
                Arrays.toString(
                        new ShortestPathDAG().shortestPath(4, 2, edges)
                )
        );
    }

    static class Pair {
        public int node;
        public int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        boolean[] visited = new boolean[N];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; ++i) {
            if (!visited[i]) {
                dfs(adjList, stack, visited, i);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.poll();

            if (dist[node] == Integer.MAX_VALUE)
                continue;

            for (Pair neighbour : adjList.get(node)) {
                int weight = neighbour.weight + dist[node];

                if (weight < dist[neighbour.node]) {
                    dist[neighbour.node] = weight;
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            dist[i] = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
        }

        return dist;
    }

    private void dfs(List<List<Pair>> adjList, Deque<Integer> stack, boolean[] visited, int node) {
        visited[node] = true;

        for (Pair neighbour : adjList.get(node)) {
            if (!visited[neighbour.node]) {
                dfs(
                        adjList,
                        stack,
                        visited,
                        neighbour.node
                );
            }
        }

        stack.push(node);
    }
}
