package boj_0921_11399;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<Node> data = new ArrayList<>();
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int P = Integer.parseInt(st.nextToken());
            data.add(new Node(i, P));
        }

        Collections.sort(data);

        Arrays.fill(dp, -1);
    }

    private static void solve() {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            tracking(i);
            sum = sum + dp[i];
        }
        System.out.println(sum);
    }

    private static int tracking(int count) {

        if (dp[count] != -1) {
            return dp[count];
        }

        if (count == 0) {
            return 0;
        }

        dp[count] = data.get(count - 1).time + tracking(count - 1);
        return dp[count];
    }

    static class Node implements Comparable<Node>{
        int index, time;
        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.time, node.time);
        }
    }
}
