package boj_0114_1337;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int element = Integer.parseInt(br.readLine());
            list.add(element);
        }
        Collections.sort(list);
    }

    private static void solve() {
        int answer = 4;

        int right = N - 1;
        int left = 0;

        while (left < right) {
            if (list.get(right) - list.get(left) > 4) {
                right--;
            } else {
                answer = Math.min(answer, 4 - (right - left));
                left++;
            }
        }

        System.out.println(answer);
    }
}
