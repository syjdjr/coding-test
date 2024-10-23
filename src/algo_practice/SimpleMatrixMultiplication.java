package algo_practice;

public class SimpleMatrixMultiplication {
    private static int n = 3;
    private static int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static int[][] B = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public static void main(String[] args) {

        int[][] C = new int[n][n];

        simpleMatrixMultiplication(n, A, B, C);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void simpleMatrixMultiplication(int n, int[][] A, int[][] B, int[][] C) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
    }
}
