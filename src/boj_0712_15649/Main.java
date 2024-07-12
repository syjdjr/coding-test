package boj_0712_15649;

import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] data;
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[M + 1];
        isVisit = new boolean[N + 1];
    }

    static void solve() {
        backTracking(0);

        System.out.println(sb);
    }

    static void backTracking(int count) {

        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(data[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isVisit[i]) {
                continue;
            }

            data[count] = i;
            isVisit[i] = true;

            backTracking(count + 1);
            isVisit[i] = false;

        }
    }
}

