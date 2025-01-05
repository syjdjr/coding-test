package boj_0105_11279;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int X;
    private static StringBuilder sb = new StringBuilder();
    private static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        setting();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            X = Integer.parseInt(br.readLine());
            solve(X);
        }

        System.out.println(sb);
    }

    private static void solve(int value) {
        if (X > 0) {
            pq.offer(new Node(value));
        } else {
            Node node = pq.peek();
            if (node == null) {
                sb.append(0);
                sb.append('\n');
            } else {
                sb.append(node.value);
                sb.append('\n');

                pq.poll();
            }
        }
    }

    static class Node implements Comparable<Node> {
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return node.value - this.value;
        }
    }
}
