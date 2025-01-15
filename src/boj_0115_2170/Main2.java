package boj_0115_2170;

import java.io.*;
import java.util.*;

public class Main2 {
    private static int N;
    private static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Node(x, y));
        }
        Collections.sort(list, (o1, o2) -> {return o1.left - o2.left;});
    }

    private static void solve() {
        int start = list.get(0).left;
        int end = list.get(0).right;
        int length = 0;

        for (int i = 1; i < N; i++) {
            Node node = list.get(i);

            if (node.left <= end) {
                end = Math.max(end, node.right);
            } else {
                length += end - start;

                start = node.left;
                end = node.right;
            }
        }

        length += end - start;
        System.out.println(length);
    }

    private static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
