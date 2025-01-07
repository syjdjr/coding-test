package boj_0107_1012;

import java.io.*;
import java.util.*;

public class Main {
    private static int T;
    private static int M;   //가로
    private static int N;   //세로
    private static int K;
    private static int[][] map;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        setting();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for (int r = 0; r < N; r++) {
                Arrays.fill(map[r], 0);
            }

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }
            solve();
        }

        System.out.println(sb);
    }

    private static void solve() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] canVisit = new boolean[N][M];
        int[] X = {0, 0, -1, 1};
        int[] Y = {1, -1, 0, 0};
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !canVisit[i][j]) {
                    q.add(new Node(i, j));
                    canVisit[i][j] = true;
                    count += 1;

                    while (!q.isEmpty()) {
                        Node node = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int xCol = node.x + X[k];
                            int yRow = node.y + Y[k];

                            if (xCol < 0 || xCol >= N || yRow < 0 || yRow >= M) {
                                continue;
                            }

                            if (canVisit[xCol][yRow] || map[xCol][yRow] != 1) {
                                continue;
                            }

                            q.add(new Node(xCol, yRow));
                            canVisit[xCol][yRow] = true;
                        }
                    }
                }
            }
        }
        sb.append(count);
        sb.append('\n');
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
