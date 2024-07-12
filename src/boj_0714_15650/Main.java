package boj_0714_15650;

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] data;
    private static boolean[] isVisit;

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
        backTracking(0, 1);

        System.out.println(sb);
    }
    public static void backTracking(int count, int start) {
        isVisit = new boolean[N + 1];

        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(data[i]).append(' ');
            }
            sb.append('\n');
            return;
        }


        for (int i = start; i <= N; i++) {
            if (isVisit[i]) {
                continue;
            }

            data[count] = i;
            isVisit[i] = true;

            backTracking(count + 1, i + 1);
            isVisit[i] = false;

        }
    }
}
