package boj_0110_2468;

import java.io.*;
import java.util.*;

public class Main1 {
    private static int N;
    private static List<List<Integer>> map = new ArrayList<>();
    private static boolean[][] isVisit;
    private static int max;
    private static int maxCountOfLevel = 1;
    private static int[] X = {0, 0, -1, 1};
    private static int[] Y = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(st.nextToken());
                map.get(i).add(data);
                max = Math.max(map.get(i).get(j), max); //최대 level
            }
        }
    }

    private static void solve() {
        for (int level = 1; level <= max; level++) {
            int countOfLevel = checkSafePlace(level);
            maxCountOfLevel = Math.max(maxCountOfLevel, countOfLevel);
        }
        System.out.println(maxCountOfLevel);
    }

    private static int checkSafePlace(int waterLevel) {
        Queue<Node> q = new LinkedList<>();
        int count = 0;

        isVisit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisit[i][j] && map.get(i).get(j) > waterLevel) {
                    q.offer(new Node(i, j, map.get(i).get(j)));
                    isVisit[i][j] = true;
                    count += 1;

                    while (!q.isEmpty()) {
                        Node node = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = node.colX + X[k];
                            int y = node.rowY + Y[k];

                            if (x < 0 || x >= N || y < 0 || y >= N) {
                                continue;
                            }

                            if (isVisit[x][y] || map.get(x).get(y) <= waterLevel) {
                                continue;
                            }

                            q.offer(new Node(x, y, map.get(x).get(y)));
                            isVisit[x][y] = true;
                        }
                    }
                }
            }
        }

        return count;
    }

    private static class Node {
        int colX, rowY, value;

        public Node(int colX, int rowY, int value) {
            this.colX = colX;
            this.rowY = rowY;
            this.value = value;
        }
    }
}
