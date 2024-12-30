package algo_dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] dummyData = {
                {1, 2, 7},
                {1, 3, 4},
                {1, 4, 6},
                {1, 5, 1},
                {3, 2, 2},
                {3, 4, 5},
                {4, 2, 3},
                {5, 4, 1},
        };

        int[][] ownData = {
                {1, 2, 4},
                {1, 3, 2},
                {2, 3, 5},
                {2, 4, 10},
                {3, 4, 3},
                {3, 5, 7},
                {4, 5, 1}
        };

        int[][] nowData = ownData;

        int n = 5;    // 정점의 개수

        int[][] W = new int[n + 1][n + 1]; // 가중치 배열

        for (int i = 1; i <= n; i++) {
            Arrays.fill(W[i], 1_000_000_000);
        }

        for (int[] edge : nowData) {
            int A = edge[0];
            int B = edge[1];
            int val = edge[2];

            W[A][B] = val; // 가중치 배열에 값 저장
        }

        List<Edge> F = new ArrayList<>();
        dijkstra(n, W, F);

        // 결과 출력
        System.out.println("F results");
        for (Edge edge : F) {
            System.out.println("Edge: " + edge.from + " " + edge.to + " with weight " + edge.weight);
        }
    }

    private static void dijkstra(int n, int[][] W, List<Edge> F) {
        int vnear = -1;
        int[] length = new int[n + 1];
        int[] touch = new int[n + 1];

        F.clear();

        Arrays.fill(length, -1);

        // 초기화
        for (int i = 2; i <= n; i++) {
            touch[i] = 1; // 시작 정점
            length[i] = W[1][i]; // 시작 정점에서 각 정점까지의 거리
        }

        // n-1번 반복
        int count = 0;
        while (count < n - 1) {
            int min = Integer.MAX_VALUE;

            // 최단 경로 정점 찾기
            for (int i = 2; i <= n; i++) {
                if (length[i] >= 0 && length[i] <= min) {
                    min = length[i];
                    vnear = i;
                }
            }

            Edge e = new Edge(touch[vnear], vnear, min);
            F.add(e);

            // 거리 업데이트
            for (int i = 2; i <= n; i++) {
                if (length[vnear] + W[vnear][i] < length[i]) {
                    length[i] = length[vnear] + W[vnear][i];
                    touch[i] = vnear;
                }
            }

            length[vnear] = -1;
            count++;
        }
    }

    private static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
