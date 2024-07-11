package boj_0711_10026;

import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static Node[] data;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //물품의 수
        K = Integer.parseInt(st.nextToken());   // 준서가 버틸 수 있는 무게

        data = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            data[i] = new Node(W, V);
        }
    }

    public static void solve() {
        int[][] dp = new int[N + 1][K + 1];

        for (int index = 1; index <= N; index++) {
            for (int weight = 1; weight <= K; weight++) {
                // 새로 들어오는 물건
                if (weight >= data[index].weight) {
                    dp[index][weight] = Math.max(Math.max(dp[index - 1][weight], dp[index][weight - 1]),
                            dp[index - 1][weight - data[index].weight] + data[index].value);
                } else {
                    dp[index][weight] = Math.max(dp[index - 1][weight], dp[index][weight - 1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }

    static class Node {
        int value, weight;

        public Node(int weight, int value) {
            this.value = value;
            this.weight = weight;
        }
    }
}
