package boj_0623_10866;

import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int X;
    public static List<String> command = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            command.add(br.readLine());
        }
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> dq = new LinkedList<>();

        // command 리스트 순회하는 for문
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(command.get(i));

            switch(st.nextToken()) {
                case "push_front":
                    X= Integer.parseInt(st.nextToken());
                    dq.offerFirst(X);
                    break;

                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    dq.offerLast(X);
                    break;

                case "pop_front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        X = dq.pollFirst();
                        sb.append(X).append("\n");
                    }
                    break;

                case "pop_back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        X = dq.pollLast();
                        sb.append(X).append("\n");
                    }
                    break;

                case "size":
                    sb.append(dq.size()).append("\n");
                    break;

                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;

            }
        }

        System.out.print(sb);
    }
}
