package boj_0724_18352;

import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, K, X;
    private static List<Node> map = new LinkedList<>();
    private static boolean[] isVisit;
    private static Queue<Integer> q = new LinkedList<>();

    public static void main() throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //도시의 개수
        M = Integer.parseInt(st.nextToken());   //도로의 개수
        K = Integer.parseInt(st.nextToken());   //거리
        X = Integer.parseInt(st.nextToken());   //출발 도시의 번호

        isVisit = new boolean[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

        }
    }

    static void solve() {

        q.add(X);
        isVisit[X] = true;

        for(int i = 0; i < K; i++) {

            while(!q.isEmpty()) {
                int vertex = q.poll();

            }
        }
    }

    static class Node {
        int value, dist;

        public Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }
    }

}

