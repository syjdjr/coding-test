package boj_0724_18352;

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, K, X;
    private static List<Node>[] map;
    private static boolean[] visited;
    private static int[] dist;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++){
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map[A].add(new Node(B,0));
        }
    }

    public static void solve() {
        Queue<Node> q = new PriorityQueue<>();

        Node node = new Node(X, 0);
        q.add(node);
        visited[X] = true;
        dist[X] = 0;
        int distance = 0;

        while (!q.isEmpty()) {
            Node vertex = q.poll();
            int nowNode = vertex.edge;
            int nowDist = vertex.dist;

            if (nowDist == K) {
                sb.append(nowNode).append("\n");
            }

            for (Node next : map[nowNode]) {
                int nextNode = next.edge;
                int nextDist = distance + next.dist;

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        q.add(new Node(nextNode, nextDist));
                    }
                }
            }
        }


        if (sb.isEmpty()) {
            sb.append(-1);
        }

        System.out.println(sb);
    }


    static class Node implements Comparable<Node> {
        int edge, dist;

        public Node(int edge, int dist) {
            this.edge = edge;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {

            return this.dist - node.dist;
        }
    }
}
