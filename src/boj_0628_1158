package boj_0628_1158;

import java.util.*;
import java.io.*;

public class Main {

    private static int N,K;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        System.out.print("<");
        while (!q.isEmpty()) {

            for (int i = 1; i <= K; i++) {

                if (i != K) {
                    q.add(q.poll());

                } else {
                    System.out.print(q.poll());

                    if (!q.isEmpty()) {
                        System.out.print(", ");
                    }
                }
            }
        }

        System.out.print(">");
    }
}
