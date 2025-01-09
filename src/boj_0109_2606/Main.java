package boj_0109_2606;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;   //컴퓨터의 수
    private static int M;   //컴퓨터 쌍의 수
    private static List<List<Integer>> list = new ArrayList<>();
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        isVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            list.get(B).add(A);
        }
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        isVisit[1] = true;

        for (int i : list.get(1)) {
            q.offer(i);
            isVisit[i] = true;
            count += 1;
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i : list.get(now)) {
                if (!isVisit[i]) {
                    q.offer(i);
                    isVisit[i] = true;
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}
