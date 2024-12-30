package algo_floyd2;

public class Main {
    private static int n;
    private static int[][] W;
    private static int[][] D;
    private static int[][] P;

    public static void main(String[] args) {
        setting();
        floyd2();
        print();

        // 모든 정점 간 최단 경로 출력
        for (int i = 1; i <= n; i++) {
            System.out.println("vertex " + i + "의 최단경로:");
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    System.out.print("v" + i);  // 시작 정점
                    path(i, j);  // 중간 경로 출력
                    System.out.println(" v" + j);  // 도착 정점
                }
            }
            System.out.println();
        }
    }

    private static void setting() {
        int INF = 99999999;
        n = 5;

//        // 교재 데이터
//        W = new int[][]{
//                {0, 1, INF, 1, 5},
//                {9, 0, 3, 2, INF},
//                {INF, INF, 0, 4, INF},
//                {INF, INF, 2, 0, 3},
//                {3, INF, INF, INF, 0}
//        };

                // 임의의 자작 데이터
        W = new int[][]{
                {0, 3, INF, 7, INF},
                {INF, 0, 1, INF, 2},
                {INF, INF, 0, 2, INF},
                {INF, INF, INF, 0, 3},
                {6, INF, INF, INF, 0}
        };

        D = new int[n + 1][n + 1];
        P = new int[n + 1][n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                P[i][j] = 0;
            }
        }
    }

    private static void floyd2() {
        // 초기 거리 행렬 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                D[i][j] = W[i - 1][j - 1];
            }
        }

        // 플로이드 알고리즘 적용
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        P[i][j] = k;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }

    private static void print() {
        // D 배열 출력
        System.out.println("D[i][j]");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (D[i][j] == 99999999) {
                    System.out.print("INF ");
                } else {
                    System.out.print(D[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // P 배열 출력
        System.out.println("P[i][j]");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(P[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void path(int q, int r) {
        if (P[q][r] != 0) {
            path(q, P[q][r]);
            System.out.print(" v" + P[q][r]);  // 중간 경로 출력
            path(P[q][r], r);
        }
    }
}
