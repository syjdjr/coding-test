package boj_0910_1182;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, S;
    private static int count = 0;
    private static List<Integer> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void solve() {
        tracking(0,0);

        if (S == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void tracking(int start, int sum) {

        if (sum == S) {
            count++;
        }

        for (int i = start; i < data.size(); i++) {
            tracking(i + 1, sum + data.get(i));
        }
    }
}
