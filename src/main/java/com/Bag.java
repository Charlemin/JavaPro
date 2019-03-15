package com;

import java.util.Arrays;

public class Bag {
    public static void main(String[] args) {
        int[] v = {0, 8, 10, 6, 3, 7, 2};
        int[] w = {0, 4, 6, 2, 2, 5, 1};
        int n = 6, c = 12;
        int[][] m = new int[15][15];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (j >= w[i])
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + v[i]);
                else
                    m[i][j] = m[i - 1][j];
            }
        }

        int[] x = new int[7];
        for (int k = n; k > 1; k--)
            if (m[k][c] == m[k - 1][c])
                x[k] = 0;
            else {
                x[k] = 1;
                c -= w[k];
            }

        x[1] = (m[1][c] > 0) ? 1 : 0;
        for (int k = 0; k < x.length; k ++)
            System.out.println(x[k] + " ");
    }
}
