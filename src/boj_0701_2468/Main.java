package boj_0701_2468;

import java.util.*;
import java.io.*;

public class Main {

    private static int[][] edgeMap;
    private static boolean[][] isVisit;
    private static int N;

    private static int[] dR = new int[]{0,0,1,-1};
    private static int[] dC = new int[]{-1,1,0,0};

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 행과 열의 수

        edgeMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                edgeMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {

        int max = 0;

        for (int t = 0; t <= 100; t++) {
            isVisit = new boolean[N][N];
            int count = 0;

            for (int i = 0; i <N; i++) {
                for (int j = 0; j < N; j++) {

                    if (edgeMap[i][j] <= t) {
                        continue;
                    }
                    if (isVisit[i][j]) {
                        continue;
                    }

                    count++;

                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i,j));
                    isVisit[i][j] = true;

                    while (!q.isEmpty()) {
                        Node node = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int dr = node.row + dR[k];
                            int dc = node.col + dC[k];

                            if (dr < 0 || dr >= N || dc < 0 || dc >= N ) {
                                continue;
                            }
                            if (isVisit[dr][dc]) {
                                continue;
                            }
                            if (edgeMap[dr][dc] <= t) {
                                continue;
                            }

                            q.add(new Node(dr,dc));
                            isVisit[dr][dc] = true;
                        }
                    }
                }
            }
            max = Math.max(max,count);
        }

        System.out.print(max);
    }

    static class Node {
        int row, col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
