package boj_0624_1966;

import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Node> q;

    private static int N, M;

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void setting() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        q = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            q.add(new Node(value, i));
        }
    }

    public static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int count = 0;
            setting();

            while (!q.isEmpty()) {
                Node first = q.remove(0);
                boolean isMoved = false;

                for (Node node : q) {
                    if (first.value < node.value) {
                        q.add(first);

                        isMoved = true;
                        break;
                    }
                }
                if (!isMoved) {
                    count++;

                    if (first.index == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }

    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
