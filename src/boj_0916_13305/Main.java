package boj_0916_13305;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long sum = 0;
    private static long[] data_M;
    private static long[] data_L;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    //도시의 개수
        data_M = new long[N];
        data_L = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            data_L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data_M[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        long min = data_M[0];
        sum = min * data_L[0];

        for (int i = 1; i < N - 1; i++) {
            min = Math. min(min, data_M[i]);
            sum += min * data_L[i];
        }
        System.out.println(sum);
    }
}