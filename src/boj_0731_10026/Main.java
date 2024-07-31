package boj_0731_10026;

import java.io.*;
import java.util.*;

public class Main {

    private static char[][] RGB;
    private static char[][] RB;
    private static int N;

    private static StringBuilder sb = new StringBuilder();

    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        RGB = new char[N][N];
        RB = new char[N][N];

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for ( int j = 0; j < N; j++) {
                char c = st.charAt(j);
                RGB[i][j] = c;

                if(c == 'G') {
                    RB[i][j] = 'R';
                } else {
                    RB[i][j] = c;
                }

            }
        }
    }

    public static void solve() {
        bfs(RGB);
        bfs(RB);

        System.out.println(sb);
    }

    static void bfs(char[][] map) {
        Queue<Node> q = new LinkedList<>();

        boolean[][] visited;
        visited = new boolean[N][N];

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < 0) {
                    continue;
                }

                if (visited[i][j] == true) {
                    continue;
                }

                q.add(new Node(i, j));
                visited[i][j] = true;

                count += 1;

                while (!q.isEmpty()) {
                    Node node = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int dR = dr[k] + node.row;
                        int dC = dc[k] + node.col;

                        if (dR < 0 || dC < 0 || dR >= N || dC >= N) {
                            continue;
                        }

                        if (visited[dR][dC] == true) {
                            continue;
                        }

                        if (map[node.row][node.col] != map[dR][dC]) {
                            continue;
                        }

                        q.add(new Node(dR, dC));
                        visited[dR][dC] = true;
                    }
                }
            }
        }
        sb.append(count).append(" ");
    }

    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
