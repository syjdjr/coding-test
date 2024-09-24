package boj_0923_3273;

import java.util.*;
import java.io.*;

public class Main {
    private static int N, X;
    private static List<Integer> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }
        X = Integer.parseInt(br.readLine());

        Collections.sort(data);
    }

    private static void solve() {
        int count = 0;

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = data.get(left) + data.get(right);

            if (sum == X) {
                count++;
                left++;
            } else if (sum < X) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
