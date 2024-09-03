package boj_0902_14501;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static Node[] data;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        data = new Node[N + 1];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());  //상담기간
            int P = Integer.parseInt(st.nextToken());   //금액

            data[i] = new Node(T, P);
        }
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            if (i + data[i].T <= N + 1) {
                dp[i + data[i].T] = Math.max(dp[i] + data[i].P, dp[i + data[i].T]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N + 1]);
    }

    static class Node {
        int T, P;

        public Node(int T, int P) {
            this.T = T;
            this.P = P;
        }
    }
}