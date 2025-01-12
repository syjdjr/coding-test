package boj_0112_11000;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static Queue<Node> q = new PriorityQueue<>();

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

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            q.offer(new Node(a, b));
//            System.out.println(q.poll());
        }
    }

    private static void solve() {
        Queue<Integer> room = new PriorityQueue<>();
        int countRoom = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            Integer firstFinishRoom = room.peek();
            if (firstFinishRoom == null) {
                room.offer(node.endTime);
            } else {
                room.offer(node.endTime);

                if (node.startTime < firstFinishRoom) {
                    countRoom += 1;
                } else {
                    room.poll();
                }
            }
        }

        System.out.println(countRoom);
    }

    private static class Node implements Comparable<Node> {
        int startTime, endTime;

        public Node(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Node node) {
            return this.startTime - node.startTime;
        }

//        @Override
//        public String toString() {
//            return "start : " + startTime + "end : " + endTime;
//        }
    }
}
