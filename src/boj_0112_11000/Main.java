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
        }
    }

    private static void solve() {
        Queue<Integer> room = new PriorityQueue<>();
        int countRoom = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            room.offer(node.endTime);

            if (!room.isEmpty() && node.startTime < room.peek()) {
                countRoom += 1;
            } else {
                room.poll();
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
}
}
