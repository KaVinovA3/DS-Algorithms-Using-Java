package com.techcrack.dsa.slindingwindowTwoPointer;

public class MinWindowSubsequence {
    public int getMinWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int minLen = Integer.MAX_VALUE;
        int i = 0;

        while (i < n) {
            int j = 0;

            while (i < n) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;

                    if (j == m) break;
                }

                i++;
            }

            int end = i;
            j = m - 1;

            while (i >= 0) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j--;

                    if (j < 0) break;
                }

                i--;
            }

            int start= i;
            int len = end - start + 1;

            minLen = Math.min(minLen, len);

            i = start + 1;
        }

        return minLen;
    }
}
