package boj_0722_11279;

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static StringBuilder sb = new StringBuilder();

    private static Queue<Node> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        setting();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    //연산의 개수

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            solve(x);
        }
        System.out.println(sb);
    }

    static void solve(int x) {

        Node node = new Node(x);

        if (x != 0) {
            q.add(node);
        } else {
            if (!q.isEmpty()) {
                sb.append(q.poll().value).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
    }

    static class Node implements Comparable<Node>{
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
