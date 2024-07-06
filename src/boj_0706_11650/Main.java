package boj_0706_11650;

import java.util.*;
import java.io.*;

public class Main {
    private static List<Node> data = new ArrayList<>();
    private static int N, x, y;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            data.add(new Node(x, y));
        }
    }

    public static void solve() {
        Collections.sort(data);

        for (Node n : data) {
            System.out.println(n);
        }
    }

    static class Node implements Comparable<Node>{
        int x , y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node node) {
            if (this.x - node.x == 0) {
                return this.y - node.y;
            } else {
                return this.x - node.x;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
