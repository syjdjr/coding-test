package boj_0906_1912;

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] data;
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        data = new int[n + 1];
        dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        int max = data[1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + data[i], data[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
