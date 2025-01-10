package boj_0110_2468;

import java.io.*;
import java.util.*;

public class Main2 {
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
                max = Math.max(map.get(i).get(j), max);
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
        int count = 0;
        isVisit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisit[i][j] && map.get(i).get(j) > waterLevel) {
                    dfs(i, j, waterLevel);
                    count += 1;
                }
            }
        }

        return count;
    }

    private static void dfs(int colX, int rowY, int waterLevel) {
        isVisit[colX][rowY] = true;

        for (int k = 0; k < 4; k++) {
            int x = colX + X[k];
            int y = rowY + Y[k];

            if (x < 0 || x >= N || y < 0 || y >= N) {
                continue;
            }

            if (isVisit[x][y] || map.get(x).get(y) <= waterLevel) {
                continue;
            }

            dfs(x, y, waterLevel);
            isVisit[x][y] = true;
        }
    }
}
