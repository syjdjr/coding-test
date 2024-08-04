package boj_0804_2170;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<Node> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            data.add(new Node(x, y));
        }
    }

    static void solve() {
        int length = 0;

        Collections.sort(data);

        int nowStart = data.get(0).start;
        int nowEnd = data.get(0).end;

        for (int i = 1; i < N; i++) {
           Node now = data.get(i);


           if (now.start <= nowEnd) {
               nowEnd = Math.max(nowEnd, now.end);
           } else {
               length += nowEnd - nowStart;

               nowStart = now.start;
               nowEnd = now.end;
           }
        }
        length += nowEnd - nowStart;
        System.out.println(length);
    }

    static class Node implements Comparable<Node>{
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node node) {
            return this.start - node.start;
        }

    }
}
