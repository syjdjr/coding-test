package prg_0106_154540;

import java.util.*;

class Solution2 {
    public List<Integer> solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        int[][] mapsOfInt = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) == 'X') {
                    mapsOfInt[i][j] = -1;
                } else {
                    mapsOfInt[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }

        return find(mapsOfInt, row, col);
    }

    public List<Integer> find(int[][] mapsOfInt, int row, int col) {
        boolean[][] canVisit = new boolean[row][col];
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mapsOfInt[i][j] != -1 && !canVisit[i][j]) {
                    int sum = dfs(mapsOfInt, canVisit, i, j, row, col);
                    answerList.add(sum);
                }
            }
        }
        if (answerList.isEmpty()) {
            answerList.add(-1);
        } else {
            Collections.sort(answerList);
        }

        return answerList;
    }

    public int dfs(int[][] mapsOfInt, boolean[][] canVisit, int x, int y, int row, int col) {
        int[] xRow = {0, 0, -1, 1};
        int[] yCol = {1, -1, 0, 0};

        if (x < 0 || x >= row || y < 0 || y >= col) {
            return 0;
        }

        if (mapsOfInt[x][y] == -1 || canVisit[x][y]) {
            return 0;
        }

        canVisit[x][y] = true;
        int sum = mapsOfInt[x][y];

        for (int i = 0; i < 4; i++) {
            sum += dfs(mapsOfInt, canVisit, x + xRow[i], y + yCol[i], row, col);
        }

        return sum;
    }
}
