package com.techcrack.dsa.graph;

public class FloydWarshall {
    public void shortestDistance(int[][] matrix) {
        int INF = (int)1e9;

        // Unknown as INF
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = INF;
                }
            }
        }

        // For Every Via mode iterate the grid
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                if (matrix[i][k] == INF) {
                    continue;
                }

                for (int j = 0; j < n; ++j) {

                    if (matrix[k][j] == INF) {
                        continue;
                    }

                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }


        // Detect Negative Cycle
        boolean hasNegativeCycle = false;

        for (int i = 0; i < n; ++i) {
            if (matrix[i][i] < 0) {
                hasNegativeCycle = true;
                break;
            }
        }

        // Update non-reachable vertex as -1
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == INF) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
