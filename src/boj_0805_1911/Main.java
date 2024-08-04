package boj_0805_1911;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, L;
    private static List<Node> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            data.add(new Node(x, y));
        }
    }

    static void solve() {
        Collections.sort(data);

        int count = 0;
        int nowEnd = 0;

        for (int i = 0; i < N; i++) {
            Node node = data.get(i);

            if (nowEnd >= node.y) {
                continue;
            }

            if (nowEnd < node.x) {
                nowEnd = node.x;
            }

            while (nowEnd < node.y) {
                nowEnd += L;
                count++;
            }
        }
        System.out.println(count);
    }

    static class Node implements Comparable<Node> {
        int x, y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo (Node node) {
            return this.x - node.x;
        }
    }
}
