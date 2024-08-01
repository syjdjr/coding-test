package boj_0801_12865;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, K, W, V;
    private static List<Node> data = new ArrayList<>();
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //물품의 수
        K = Integer.parseInt(st.nextToken());   //버틸 수 있는 무게

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());   //물건 하나의 무게
            V = Integer.parseInt(st.nextToken());   //물건 하나의 가치

            data.add(new Node(W, V));
        }
    }


    static void solve() {

        for (int i = 1; i <= N; i++) {
            int weight = data.get(i - 1).weight;
            int value = data.get(i - 1).value ;

            for (int j = 1; j <= K; j++) {
                if (j - weight >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }

    static class Node {
        int weight, value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
