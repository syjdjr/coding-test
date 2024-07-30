package boj_0724_18352;

import java.util.*;
import java.io.*;

public class Main {

    private static int K;
    private static int X;
    private static final List<List<Integer>> map = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++){
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map.get(A).add(B);
        }
    }

    public static void solve() {
        List<Integer> result = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(X, 0));
        visited[X] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.dist == K) {
                result.add(node.edge);
            }

            for (int next : map.get(node.edge)) {
                if (visited[next])
                    continue;

                q.offer(new Node(next, node.dist + 1));
                visited[next] = true;
            }
        }


        if (result.size() == 0) {
            result.add(-1);
        }

        Collections.sort(result);

        for (int i : result) {
            System.out.println(i);
        }
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
