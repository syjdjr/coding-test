package boj_0812_7576;

import java.io.*;
import java.util.*;

public class Main {
    private static int M, N;
    private static int[][] map;
    private static boolean[][] isVisit;
    private static final int[] dX = {0, 0, -1, 1};
    private static final int[] dY = {1, -1, 0, 0};
    private static final Queue<Node> q = new LinkedList<>();

    public static void main (String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   //상자의 가로
        N = Integer.parseInt(st.nextToken());   //상자의 세로

        map = new int[N][M];
        isVisit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    isVisit[i][j] = true;
                }
            }
        }

        int count = bfs();

        boolean check = true;  //토마토가 익었는지 여부
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    check = false;   //토마토가 익지 않았다
                    break;
                }
            }
            if (!check) {
                break;
            }
        }

        if (!check) {
            System.out.println("-1");   //토마토가 모두 익지 못하는 경우
        } else {
            System.out.println(count);
        }
    }

    static int bfs() {
        int count = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int dR = dX[i] + node.row;
                int dC = dY[i] + node.col;

                if (dR < 0 || dC < 0 || dR >= N || dC >= M) {
                    continue;
                }

                if (map[dR][dC] == -1) {
                    continue;
                }

                if (isVisit[dR][dC]) {
                    continue;
                }

                q.add(new Node(dR, dC, node.count + 1));
                isVisit[dR][dC] = true;
                map[dR][dC] = 1;
                count = node.count + 1;     //마지막 토마토까지 익어야함
            }
        }
        return count;
    }

    static class Node {
        int row, col, count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
