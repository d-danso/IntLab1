package org.example.AdvancedAlgorithms.Exercise2;

class LongestCommonSubsequence {

    static int lcs(char[] X, char[] Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        char[] X = {'A', 'G', 'G', 'T', 'A', 'B'};
        char[] Y = {'G', 'X', 'T', 'X', 'A', 'Y', 'B'};

        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is " + lcs(X, Y, m, n));
    }
}
