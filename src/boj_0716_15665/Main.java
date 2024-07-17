package boj_0716_15665;

import java.io.*;
import java.util.*;

public class Main  {

    private static int N, M;
    private static int[] data;
    private static int[] arr;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N + 1];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
    }

    static void solve() {
        Tracking(0);

        System.out.println(sb);
    }

    static void Tracking(int count) {

        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        int before = 0;
        for (int i = 1 ; i <= N; i++) {

            if (before != data[i]) {
                arr[count] = data[i];
                before = data[i];

                Tracking(count + 1);
            }
        }
    }
}
