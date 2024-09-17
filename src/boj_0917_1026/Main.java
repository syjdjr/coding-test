package boj_0917_1026;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer> A = new ArrayList<>();
    private static List<Integer> B = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        int S = 0;

        Collections.sort(A);
        Collections.sort(B);

        for (int i = 0; i < N; i++) {
            S += A.get(i) * B.get(N - i - 1);
        }
        System.out.println(S);
    }
}
