package boj_0702_heap;

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, startR, startC, targetR, targetC;
    private static int[][] map;

    private static int[] dR = new int[]{0, 0, 1, -1};
    private static int[] dC = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       //가로의 길이
        M = Integer.parseInt(st.nextToken());       //세로의 길이

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        targetR = Integer.parseInt(st.nextToken());
        targetC = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        int answer = 0;

        Queue<Node> q = new PriorityQueue<>();

        q.offer(new Node(startR, startC, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            System.out.println(node.row + " " + node.col + " " + node.dist);

            if (node.row == targetR && node.col == targetC) {
                answer = node.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dr = node.row + dR[i];
                int dc = node.col + dC[i];

                if (dr < 1 || dc < 1 || dr > N || dc > M)
                    continue;

                q.offer(new Node(dr, dc, node.dist + map[dr][dc]));
            }
        }

        System.out.println(answer);
    }

    private static class Node implements Comparable<Node> {
        int row, col, dist;

        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return this.dist - node.dist;
        }
    }
}

// 논점1) Comparator -> compare 과 Comparable -> compareTo
// 논점2) LinkedList 와 PriorityQueue 사용 ( 힙정렬을 이유로 )