package com.techcrack.dsa.graph;

import java.util.*;

public class MinimumDistanceToReachEnd {

    static class State {
        public Long value;
        public int step;

        public State(Long value, int step) {
            this.value = value;
            this.step = step;
        }
    }

    public int minMultiUsingDjisktraAlgo(int[] arr, int start, int end) {
        final long MOD = 1_00_000;

        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> b.value.compareTo(a.value));

        queue.offer(new State((long)start, 0));
        Map<Long, Integer> visited = new HashMap<>();

        visited.put((long)start, 0);

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            for (int ar : arr) {
                Long next = ((long)ar * cur.value) % MOD;

                if (next.equals((long)end)) {
                    return cur.step + 1;
                }

                if (next > end) {
                    continue;
                }

                if (!visited.containsKey(next) || visited.get(next) < cur.step + 1) {
                    queue.offer(new State(next, cur.step + 1));
                    visited.put(next, cur.step + 1);
                }
            }

        }

        return -1;
    }

    public int minimumMultiplications(int[] arr, int start, int end) {
        final long MOD = 1_00_000;

        Queue<Long> queue = new ArrayDeque<>();
        queue.offer((long)start);
        Set<Long> visited = new HashSet<>();

        visited.add((long)start);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                Long cur = queue.poll();

                for (int ar : arr) {
                    Long next = ((long)ar * cur) % MOD;

                    if (next.equals((long)end)) {
                        return step ;
                    }

                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumDistanceToReachEnd obj = new MinimumDistanceToReachEnd();

        int[] arr = {2, 5, 7};

        System.out.println(obj.minMultiUsingDjisktraAlgo(arr, 3, 30));
    }
}
