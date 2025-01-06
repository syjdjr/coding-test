package prg_0106_154540;

import java.util.*;

class Solution {
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
        Queue<Node> queue = new LinkedList<>();
        int[] Y = {1, -1, 0, 0};
        int[] X = {0, 0, -1, 1};
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mapsOfInt[i][j] != -1 && !canVisit[i][j]) {
                    queue.add(new Node(i, j));
                    canVisit[i][j] = true;
                    int sum = mapsOfInt[i][j];

                    while (!queue.isEmpty()) {
                        Node nowNode = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int xRow = nowNode.x + X[k];
                            int yCol = nowNode.y + Y[k];

                            if (xRow < 0 || xRow >= row || yCol < 0 || yCol >= col) {
                                continue;
                            }
                            if (mapsOfInt[xRow][yCol] == -1 || canVisit[xRow][yCol]) {
                                continue;
                            }

                            canVisit[xRow][yCol] = true;
                            sum += mapsOfInt[xRow][yCol];
                            queue.add(new Node(xRow, yCol));
                        }
                    }
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
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
