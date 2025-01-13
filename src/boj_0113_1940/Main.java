package boj_0113_1940;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int element = Integer.parseInt(st.nextToken());
            list.add(element);
        }
        Collections.sort(list);
    }

    private static void solve() {
        int left = 0, right = N - 1;
        int count = 0;

        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum < M) {
                left++;
            } else if (sum > M) {
                right--;
            } else {
                count++;
                left++;
            }
        }

        System.out.println(count);
    }
}
