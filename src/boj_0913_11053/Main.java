package boj_0913_11053;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] data;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        data = new int[N];
        dp = new int[N];

        Arrays.fill(dp, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, tracking(i));
        }

        System.out.println(max);
    }

    static int tracking(int depth) {
        int max = 1;

        if (dp[depth] != -1) {  //이 부분 제외하면, N^2 시간복잡도 => 시간 초과 발생
            return dp[depth];
        }

        for (int i = depth + 1; i < N; i++) {
            if (data[i] > data[depth]) {
                max = Math.max(max, tracking(i) + 1);
            }
        }
        dp[depth] = max;
        return max;
    }
}
