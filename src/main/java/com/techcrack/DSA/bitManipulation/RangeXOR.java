package com.techcrack.dsa.bitManipulation;

class RangeXOR {
    public int findRangeXOR(int l, int r) {
        return findXor(r) ^ findXor(l - 1);
    }

    public int findXor(int x) {
        return switch (x % 4) {
            case 0 ->  x;
            case 1 ->  1;
            case 2 -> x + 1;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(new RangeXOR().findRangeXOR(1, 3));
    }
}