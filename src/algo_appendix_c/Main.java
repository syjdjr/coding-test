package algo_appendix_c;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static NodeType[] U;

    public static void main(String[] args) {
        int[][] dummyData = {
                {1, 2, 1},
                {3, 5, 2},
                {1, 3, 3},
                {2, 3, 3},
                {3, 4, 4},
                {4, 5, 5},
                {2, 4, 6}
        };

        int[][] ownData = {
                {1, 2, 2},
                {1, 3, 5},
                {2, 3, 3},
                {2, 4, 4},
                {3, 4, 6},
                {3, 5, 7},
                {4, 5, 1}
        };

        int[][] nowData = ownData;

        int n = 5;  // 정점의 개수
        int m = nowData.length;  // 간선의 개수

        List<Edge> E = new ArrayList<>();

        for (int[] data : nowData) {
            int A = data[0];
            int B = data[1];
            int val = data[2];

            E.add(new Edge(A, B, val));
        }

        List<Edge> F = new ArrayList<>();

        kruskal(n, m, E, F);

        for (Edge edge : F) {
            System.out.println("Edge: " + edge.A + " " + edge.B + " with weight " + edge.val);
        }
    }

    private static void kruskal(int n, int m, List<Edge> E, List<Edge> F) {
        E.sort(Comparator.comparingInt(edge -> edge.val)); // 간선을 가중치에 따라 오름차순 정렬
        F.clear();
        initial(n);

        int cnt = 0;
        int loop = 0;
        while (cnt < n - 1 && loop < m) {
            Edge e = E.get(loop);
            int i = e.A;
            int j = e.B;
            int p = find(i);
            int q = find(j);

            if (!equal(p, q)) {
                merge(p, q);
                F.add(e);

                cnt++;
            }

            loop++;
        }
    }

    private static void initial(int n) {
        U = new NodeType[n + 1];

        for (int i = 1; i <= n; i++) {
            makeset(i);
        }
    }

    private static boolean equal(int a, int b) {
        return a == b;
    }

    private static void makeset(int i) {
        U[i] = new NodeType(i, 0); // 노드를 초기화
    }

    static int find(int i) {
        int j = i;

        while (U[j].parent != j) {
            j = U[j].parent;
        }

        return j;
    }

    static void merge(int p, int q) {
        if (U[p].depth == U[q].depth) {
            U[p].depth++;
            U[q].parent = p;
        } else if (U[p].depth < U[q].depth) {
            U[p].parent = q;
        } else {
            U[q].parent = p;
        }
    }

    static class NodeType {
        int parent; // 부모 노드
        int depth;  // 깊이

        // 생성자
        NodeType(int parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }

    static class Edge {
        int A, B, val;

        Edge(int A, int B, int val) {
            this.A = A;
            this.B = B;
            this.val = val;
        }
    }
}
