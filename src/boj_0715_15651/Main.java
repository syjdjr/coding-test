package boj_0715_15651;

import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] data;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[M];
    }

    public static void solve() {
        tracking(0);

        System.out.println(sb);
    }

    public static void tracking(int count) {

        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(data[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            data[count] = i;

            tracking(count + 1);
        }
    }
}
