package com.techcrack.dsa.graph;

import java.util.*;

class AlienDictionary {
    public String findOrder(String [] dict, int N, int K) {

        List<List<Integer>> adjList = buildAdjLst(dict, K, N);

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[K];

        for (int i = 0; i < K; ++i) {
            if (!visited[i]) {
                topologicalSort(adjList, visited, stack, i);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.append((char) (stack.pop() + 'a')).append(" ");
        }

        return res.toString();
    }



    private void topologicalSort(List<List<Integer>> adjList, boolean[] visited, Deque<Integer> stack, int node) {
        visited[node] = true;

        for (int neighbour : adjList.get(node)) {

            if (! visited[neighbour]) {
                topologicalSort(
                        adjList,
                        visited,
                        stack,
                        neighbour
                );
            }
        }


        stack.push(node);


    }

    private List<List<Integer>> buildAdjLst(String[] dict, int K, int N) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < K; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i < N; ++i)  {
            String first = dict[i - 1];
            String second = dict[i];

            int len = Math.min(first.length(), second.length());

            for (int j = 0; j < len; ++j) {
                if (first.charAt(j) != second.charAt(j)) {
                    adjList.get(first.charAt(j) - 'a')
                            .add(second.charAt(j) - 'a');
                    break;
                }
            }
        }

        return adjList;
    }

    private String findOrderUsingBFS(String [] dict, int N, int K) {
        List<List<Integer>> adjList = buildAdjLst(dict, K, N);
        int[] degree = new int[K];

        for (List<Integer> neighbours : adjList) {
            for (int neighbour : neighbours) {
                degree[neighbour]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; ++i) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (! queue.isEmpty()) {
            int node = queue.poll();
            sb.append((char)(node + 'a'))
                    .append(" ");

            for (int neighbour : adjList.get(node)) {
                degree[neighbour]--;

                if (degree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"baa","abcd","abca","cab","cad"};
        int N = 5;
        int K = 4;

        System.out.println(new AlienDictionary().findOrder(words, N, K));
    }
}