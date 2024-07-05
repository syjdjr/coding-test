package boj_0705_1927;

import java.util.*;
import java.io.*;

public class Main {

    private static int x;
    private static List<Integer> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            data.add(x);
        }
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new PriorityQueue<>((Integer int1 , Integer int2) -> int1 - int2);

        for (int i : data) {
            if (i == 0) {
                if (q.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(q.poll()).append('\n');
                }
            } else {
                q.add(i);
            }
        }

        System.out.println(sb);
    }
}
