package boj_0709_2805;

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, max;
    private static List<Integer> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));

            max = Math.max(max, data.get(i));
        }
    }

    public static void solve() {
        int left = 0;
        int right = max;
        int height = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int i : data) {
                if (i > mid) {
                    sum += (i - mid);
                }
            }

            if (M <= sum) {
                left = mid + 1;
                height = mid;

            } else {
                right = mid - 1;
            }
        }

        System.out.println(height);
    }
}
