package com.techcrack.dsa.graph;

import java.util.*;

class ShortestPathInUnDirectedGraph {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.add(src);
        
        int[] dist = new int[adj.size()];
        
        Arrays.fill(dist, -1);
        
        dist[src] = 0;
        
        while (! queue.isEmpty()) {
            int node = queue.poll();
            int distance = dist[node];
            
            for (Integer ad : adj.get(node)) {
                if (dist[ad] == -1) {
                    dist[ad] = distance + 1;
                    queue.add(ad);
                }
            }
        }
        
//        for (int i = 0; i < dist.length; i++) {
//            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
//        }
        
        return dist;
    }
}