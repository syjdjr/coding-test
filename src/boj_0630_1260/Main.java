package boj_0630_1260;

import java.io.*;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static int N, M, V;
    private static int[][] data;
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //정점의 개수
        M = Integer.parseInt(st.nextToken());   //간선의 개수
        V = Integer.parseInt(st.nextToken());   //정점의 번호

        data = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            data[A][B] = 1;
            data[B][A] = 1;
        }
    }

    private static void solveProblem() {
        isVisit = new boolean[N + 1];
        dfs(V);

        sb.append("\n");

        isVisit = new boolean[N + 1];
        bfs();

        System.out.println(sb);
    }

    private static void dfs(int vertex) {
        isVisit[vertex] = true;
        sb.append(vertex).append(" ");

        for (int i = 1; i <= N; i++) {
            if (data[vertex][i] == 0)
                continue;
            if (isVisit[i])
                continue;

            dfs(i);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        isVisit[V] = true;
        sb.append(V).append(" ");

        while (!q.isEmpty()) {
            int vertex = q.poll();

            for (int i = 1; i <= N; i++) {
                if (data[vertex][i] == 0)
                    continue;
                if (isVisit[i])
                    continue;

                q.offer(i);
                isVisit[i] = true;
                sb.append(i).append(" ");
            }
        }
    }
}
