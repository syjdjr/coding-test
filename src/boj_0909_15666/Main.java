package boj_0909_15666;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;

    private static final ArrayList<Integer> list = new ArrayList<>();
    private static int[] dp;

    private static final StringBuffer sb = new StringBuffer();


    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M];
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        for (int i : set) {
            list.add(i);
        }

        Collections.sort(list);
    }

    static void solve() {

        track(0, 0);

        System.out.println(sb);
    }

    static void track(int depth, int start) {
        if (depth == M) {
            for (int num : dp) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < list.size(); i++) {
            dp[depth] = list.get(i);
            track(depth + 1, i);
        }
    }
}
