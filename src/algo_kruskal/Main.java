package algo_kruskal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] U;

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

        //여기만 변경하고 싶은 데이터로 변경
        int[][] nowDataSet = ownData;

        int n = 5;  //정점의 개수
        int m = nowDataSet.length;  //간선의 개수

        List<Edge> E = new ArrayList<>();

        for (int[] data : nowDataSet) {
            int A = data[0];
            int B = data[1];
            int val = data[2];

            E.add(new Edge(A, B, val));
        }

        List<Edge> F = new ArrayList<>();

        kruskal(n, m, E, F);

        System.out.println("F results");
        for (Edge edge : F) {
            System.out.println(edge.A + " " + edge.B + " " + edge.val);
        }
    }

    private static void kruskal(int n, int m, List<Edge> E, List<Edge> F) {
        E.sort((v1, v2) -> v1.val - v2.val);    //간선을 가중치에 따라 오름차순 정렬
        F.clear();
        initial(n);

        System.out.println("loop: " + 0);
        for (int o = 1; o <= n; o++) {
            int i1 = U[o];
            System.out.print(i1 + " ");
        }
        System.out.println();

        int cnt = 0;
        int loop = 0;
        while (cnt < n - 1) {
            Edge e = E.get(loop);

            int i = e.A;
            int j = e.B;
            int p = find(i);
            int q = find(j);

            if (!equal(p, q)) {
                merge(i, j);
                F.add(e);

                cnt++;
            }

            loop++;

            System.out.println("loop: " + loop);
            for (int o = 1; o <= n; o++) {
                int i1 = U[o];
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
    }

    private static void initial(int n) {
        U = new int[n + 1];
        for (int i = 1; i <= n; i++)
            makeSet(i);
    }

    private static void makeSet(int i) {
        U[i] = i;
    }

    private static boolean equal(int a, int b) {
        return a == b;
    }

    static int find(int A) {
        if (U[A] == A)
            return A;
        else
            return find(U[A]);
    }

    static void merge(int A, int B) {
        int a = find(A);
        int b = find(B);

        if (a != b)
            U[b] = a;
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
