package boj_0730_14728;

import java.io.*;
import java.util.*;

public class Main {

    public static int N, T;
    public static List<Node> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            data.add(new Node(time, score));
        }
    }

    static void solve() {
        int[] dp = new int[T + 1];

        for (Node i : data) {
            for (int j = T; j >= i.time; j--) {
                dp[j] = Math.max(dp[j], dp[j - i.time] + i.score);
            }
        }
        System.out.println(dp[T]);
    }

    static class Node {
        int time, score;

        public Node(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
}

