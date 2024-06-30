package boj_0630_1012;

import java.util.*;
import java.io.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static int[][] edgeMap;
    private static boolean[][] isVisit;

    private static final int[] dR = new int[]{0, 0, 1, -1};
    private static final int[] dC = new int[]{1, -1, 0, 0};

    private static int N, M, K;

    public static void main(String[] args) throws IOException {
        setting();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    //테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());   //가로길이
            N = Integer.parseInt(st.nextToken());   //세로길이
            K = Integer.parseInt(st.nextToken());   //위치개수

            edgeMap = new int[N][M];
            isVisit = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());

                edgeMap[row][col] = 1;
            }

            solve();
        }

        System.out.print(sb);
    }

    static void solve() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (edgeMap[i][j] == 0) {
                    continue;
                }
                if (isVisit[i][j]) {
                    continue;
                }

                count++;

                Queue<Node> q = new LinkedList<>();
                q.add(new Node(i, j));
                isVisit[i][j] = true;

                while (!q.isEmpty()) {
                    Node node = q.poll();

                    for (int loop = 0; loop < 4; loop++) {
                        int dr = node.row + dR[loop];
                        int dc = node.col + dC[loop];

                        if (dr < 0 || dc < 0 || dr >= N || dc >= M)
                            continue;
                        if (isVisit[dr][dc])
                            continue;
                        if (edgeMap[dr][dc] == 0)
                            continue;

                        q.offer(new Node(dr, dc));
                        isVisit[dr][dc] = true;
                    }
                }
            }
        }

        sb.append(count).append("\n");
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
