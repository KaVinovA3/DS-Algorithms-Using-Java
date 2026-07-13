package com.techcrack.dsa.slindingwindowTwoPointer;

public class BasketFruits {
    public int countFruits(int[] fruits) {
        int lastFruit = -1, secondLastFruit = -1;
        int lastCount = 0, curLen = 0, max = 2;

        for (int fruit : fruits) {
            if (lastFruit == fruit || secondLastFruit == fruit) curLen++;
            else curLen = lastCount + 1;

            if (lastFruit == fruit) lastCount++;
            else {
                lastCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, curLen);
        }

        return max;
    }

    public static void main(String[] args) {
        var res = new BasketFruits().countFruits(new int[]{1, 2, 3, 2, 2});
    }
}
