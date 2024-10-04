package boj_1004_14430;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] data;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = data[i - 1][j - 1] + Math.max(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        System.out.println(dp[N][M]);
    }
}

