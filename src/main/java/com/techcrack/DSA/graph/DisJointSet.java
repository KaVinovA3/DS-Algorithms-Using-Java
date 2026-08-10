package com.techcrack.dsa.graph;

public class DisjointSet {
    private final int[] parent, size, rank;

    public DisjointSet(int n) {
        this.parent = new int[n + 1];
        this.size = new int[n + 1];
        this.rank = new int[n + 1];

        initialize(n);
    }

    public void initialize(int n) {
        for (int i = 1; i <= n; ++i) {
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }


    public boolean find(int u, int v) {
        return find(u) == find(v);
    }

    public int find(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }

    public void unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}
