package boj_0624_1966;

import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, M;
    private static List<Node> data;

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void setting() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //문서의 개수
        M = Integer.parseInt(st.nextToken());   //찾는 문서 idx

        data = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());

            data.add(new Node(val, i));
        }
    }

    public static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            setting();
            int count = 0;

            while(!data.isEmpty()) {
                Node first = data.remove(0);
                boolean isMoved = false;

                for (Node node : data) {
                    if (first.val < node.val) {
                        data.add(first);

                        isMoved = true;
                        break;
                    }
                }

                if (!isMoved) {
                    count++;

                    if (first.idx == M) {
                        sb.append(count).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }

    private static class Node {
        int val, idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
