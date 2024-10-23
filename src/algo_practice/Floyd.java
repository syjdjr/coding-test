package algo_practice;

import java.util.Arrays;

public class Floyd {
    private static int[][] W = {
            {0, 1, 3, 999, 999},
            {1, 0, 3, 6, 999},
            {3, 3, 0, 4, 2},
            {999, 6, 4, 0, 5},
            {999, 999, 2, 5, 0}
    };

    private static int n = 5;
    private static int[][] D;
    private static int[][] P;

    public static void main(String[] args) {
        D = new int[n][n];
        P = new int[n][n];

        floyd(W, n, D, P);
    }

    private static void floyd(int[][] W, int n, int[][] D, int[][] P) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                P[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = W[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        P[i][j] = k;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }

        System.out.println("D 배열 확인하기:");
        for (int[] row : D) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        System.out.println("P 배열 확인하기:");
        for (int[] row : P) {
            System.out.println(Arrays.toString(row));
        }
    }
}
