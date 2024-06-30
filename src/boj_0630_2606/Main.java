package boj_0630_2606;

import java.util.*;
import java.io.*;

public class Main {
    private static int[][] connection;
    private static boolean[] isVisited;

    private static int count;

    private static int N,M;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M = Integer.parseInt(br.readLine()); // 직접 연결되어 있는 컴퓨터 쌍의 수

        connection = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
           st = new StringTokenizer(br.readLine());

           int A = Integer.parseInt(st.nextToken());
           int B = Integer.parseInt(st.nextToken());

           connection[A][B] = 1;
           connection[B][A] = 1;
        }
    }

    public static void solve() {
        isVisited = new boolean[N+1];

        isVisited[1] = true;
        dfs(1);

        System.out.print(count);

    }

    public static void dfs(int vertex) {
        for (int i = 1; i <= N; i++) {
            if (connection[vertex][i] == 0) {
                continue;
            }
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            dfs(i);
            count++;
        }
    }
}
