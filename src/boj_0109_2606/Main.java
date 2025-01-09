package boj_0109_2606;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;   //컴퓨터의 수
    private static int M;   //컴퓨터 쌍의 수
    private static boolean[][] map;
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new boolean[N + 1][N + 1];
        isVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map[A][B] = true;
            map[B][A] = true;
        }
    }

    public static void solve() {
        Queue<Integer> q = new LinkedList<>();
        isVisit[1] = true;

        int count = 0;

        for (int i = 1; i <= N; i++) {

            if (map[1][i] && !isVisit[i]) {
                q.offer(i);
                isVisit[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            System.out.println(now);

            isVisit[now] = true;
            count += 1;

            for (int j = 1; j <= N; j++) {
                if (map[now][j] && !isVisit[j]) {
                    q.offer(j);
                }
            }
        }

        System.out.println(count);
    }
}
