package com.techcrack.dsa.graph;

import java.util.*;

public class ShortestPath {
    public List<List<Integer>> buildGraph(int[][] edges, int nodes) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < nodes; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }

    public int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Integer>> adjList = buildGraph(edges, N);

        int[] ans = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(0);
        Arrays.fill(ans, -1);
        ans[0] = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbour : adjList.get(node)) {
                if (ans[neighbour] == -1) {
                    ans[neighbour] = ans[node] + 1;
                    queue.offer(neighbour);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,3},{3,4},{4,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        System.out.println(Arrays.toString(
                new ShortestPath().shortestPath(edges, 9, 8)
        ));

//        0 1 2 1 2 3 3 4 4
//        [0, 1, 2, 1, 2, 4, 3, 4, 5]
    }

}
