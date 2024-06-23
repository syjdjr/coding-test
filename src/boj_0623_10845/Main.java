package boj_0623_10845;

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static final List<String> command = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            command.add(br.readLine());
        }
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(command.get(i));

            switch (st.nextToken()) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;

                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        int poll = q.poll();
                        sb.append(poll).append("\n");
                    }
                    break;

                case "size":
                    int size = q.size();
                    sb.append(size).append("\n");
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;

                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
