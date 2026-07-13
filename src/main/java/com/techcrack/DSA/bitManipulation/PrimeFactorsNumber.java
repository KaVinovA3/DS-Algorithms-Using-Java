package com.techcrack.dsa.bitManipulation;

import java.util.ArrayList;
import java.util.List;

class PrimeFactorsNumber {
    public List<List<Integer>> primeFactors(int[] queries) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int query : queries) {
            List<Integer> cur = new ArrayList<>();
            int n = query;

            for (int i = 2; i * i <= n; ++i) {
                while (n % i == 0) {
                    cur.add(i);

                    n /= i;
                }
            }

            if (n != 1) cur.add(n);

            ans.add(cur);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PrimeFactorsNumber().primeFactors(new int[]{7, 12, 18}));
    }
}