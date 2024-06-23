package boj_0623_1874;

import java.io.*;
import java.util.*;

public class Main {

    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();

        Stack<Integer> s = new Stack<>();
        int lastMaxNum = 0;

        for (int num : list) {
            if (s.isEmpty()) {
                if (lastMaxNum < num) {
                    for (int i = lastMaxNum + 1; i <= num; i++) {
                        s.add(i);
                        sb.append("+").append("\n");
                    }
                    s.remove(s.size() - 1);
                    sb.append("-").append("\n");

                    lastMaxNum = num;
                }
            } else {
                if (lastMaxNum < num) {
                    for (int i = lastMaxNum + 1; i <= num; i++) {
                        s.add(i);
                        sb.append("+").append("\n");
                    }
                    s.remove(s.size() - 1);
                    sb.append("-").append("\n");

                    lastMaxNum = num;
                } else {
                    if (s.peek() == num) {
                        s.remove(s.size() - 1);
                        sb.append("-").append("\n");

                    } else {
                        sb.delete(0,sb.length());
                        sb.append("NO");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
