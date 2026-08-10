package com.techcrack.dsa.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Disjoint {
    private int[] parents, size;

    public Disjoint(int n) {
        this.parents = new int[n];
        this.size = new int[n];

        initialize(n);
    }

    public void initialize(int n) {
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (node == parents[node]) {
            return node;
        }

        return parents[node] = find(parents[node]);
    }

    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) {
            return;
        }

        if (size[pu] > size[pv]) {
            parents[pv] = pu;
            size[pu] += size[pv];
        } else {
            parents[pu] = pv;
            size[pv] += size[pu];
        }
    }


}

public class NumberIsland2 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        Disjoint ds = new Disjoint(n * m);
        int[][] grid = new int[n][m];

        int groups = 0;
        List<Integer> ans = new ArrayList<>();

        for (int[] index : A) {
            int node = index[0] * m + index[1];

            Set<Integer> parents = new HashSet<>();

            for (int[] DIR : DIRECTIONS) {
                int r = index[0] + DIR[0];
                int c = index[1] + DIR[1];

                if (!isValid(n, m, r, c) || grid[r][c] == 0)
                    continue;

                int neighbour = r * m + c;
                parents.add(ds.find(neighbour));
            }

            grid[index[0]][index[1]] = 1;

            if (parents.isEmpty()) {
                groups++;
            } else {
                groups -= parents.size() - 1;
            }

            for (int neighbours : parents) {
                ds.union(neighbours, node);
            }

            ans.add(groups);
        }

        return ans;
    }

    public boolean isValid(int n, int m, int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
