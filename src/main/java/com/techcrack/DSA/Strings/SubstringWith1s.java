package com.techcrack.DSA.Strings;

class SubstringWith1s {
    public int numSub1(String s) {
        long MOD = 1_000_000_007;
        long chanceOfSubstring = 0;
        long n = 0;

        char[] sArray = s.toCharArray();
        boolean zeros = true;

        for (char ch : sArray) {
            if (zeros && ch == '1') 
                zeros = false;

            if (! zeros && ch == '0') {
                zeros = true;
                chanceOfSubstring += ((n + 1) * n / 2); 
                n = 0;
            }
            if (! zeros && ch == '1') 
                n++;
        }

        chanceOfSubstring += ((n + 1) *n / 2);

        return (int) (chanceOfSubstring % MOD);

    }


    // Sliding Window
    public int numSub(String s) {
        int i = 0, j = 0;
        long sum = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '0') {
                i++;
                j = i;
            }
            else {
                sum += (i - j + 1);
                i++;
            }
        }

        return (int) (sum % 1_000_000_007);
    }
}