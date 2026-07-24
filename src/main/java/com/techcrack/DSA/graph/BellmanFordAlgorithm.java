package com.techcrack.dsa.graph;

import java.security.interfaces.EdECKey;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    public static int[] bellman_ford(int V, List<List<Integer>> edges, int S) {
        int[] dist = new int[V];

        final int INF = (int)1e9;

        Arrays.fill(dist, INF);
        dist[S] = 0;

        //  Finding Shortest Distance
        for (int i = 0; i < V - 1; ++i) {
            boolean updated = false;

            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);

                if (dist[u] == INF) continue;

                if (dist[u] + wt < dist[v]) {
                    updated = true;
                    dist[v] = dist[u] + wt;
                }
            }

            if (!updated) {
                break;
            }
        }

        // Cycle Detection
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            if (dist[u] == INF) continue;

            if (dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }
}
