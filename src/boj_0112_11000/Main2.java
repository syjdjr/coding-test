package boj_0112_11000;

import java.io.*;
import java.util.*;

public class Main2 {
    private static int N;
    private static List<int[]> list = new ArrayList<>();

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

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            list.add(new int[]{startTime, endTime});
        }

        list.sort((a, b) -> a[0] - b[0]);
    }

    private static void solve() {
        Queue<Integer> room = new PriorityQueue<>();
        int countRoom = 0;

        for (int i = 0; i < N; i++) {
            room.offer(list.get(i)[1]);

            if (!room.isEmpty() && list.get(i)[0] < room.peek()) {
                countRoom += 1;
            } else {
                room.poll();
            }
        }

        System.out.println(countRoom);
    }
}
