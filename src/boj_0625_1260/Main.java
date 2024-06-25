package boj_0625_1260;

import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer> dfsAnswer = new ArrayList<>();
    private static List<Integer> bfsAnswer = new ArrayList<>();

    private static Queue<Integer> q = new LinkedList<>();

    private static int[][] edgeMap;

    private static boolean[] isVisitedDfs;
    private static boolean[] isVisitedBfs;

    private static int N,M,V;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        V = Integer.parseInt(st.nextToken());   // 시작 정점의 번호

        edgeMap = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st1.nextToken());
            int B = Integer.parseInt(st1.nextToken());

            edgeMap[A][B] = 1;
            edgeMap[B][A] = 1;
        }
    }

    public static void solve() {
        isVisitedDfs = new boolean[N+1];
        isVisitedBfs = new boolean[N+1];

        isVisitedDfs[V] = true;
        dfsAnswer.add(V);
        dfs(V);

        isVisitedBfs[V] = true;
        q.add(V);
        bfsAnswer.add(V);
        bfs();


        for (int i : dfsAnswer) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : bfsAnswer) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static void dfs(int startV) {

        for (int i = 1; i <= N; i++) {
            if (edgeMap[startV][i] == 1 && !isVisitedDfs[i]) {
                isVisitedDfs[i] = true;
                dfsAnswer.add(i);
                dfs(i);
            }
        }
    }

    public static void bfs() {

        while(!q.isEmpty()){
            int index = q.remove();

            for (int i = 1; i <= N; i++) {

                if (edgeMap[index][i] == 1 && !isVisitedBfs[i]) {
                    isVisitedBfs[i] = true;
                    bfsAnswer.add(i);
                    q.add(i);
                }
            }
        }
    }
}
