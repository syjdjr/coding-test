package boj_0710_1654;

import java.util.*;
import java.io.*;

public class Main {

    private static long N;
    private static long K = Integer.MIN_VALUE;
    private static long max;
    private static final List<Integer> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());   //랜선의 개수
        N = Integer.parseInt(st.nextToken());   //필요한 랜선의 개수

        for (int i = 0; i < K; i++) {
           int value = Integer.parseInt(br.readLine());
           data.add(value);

           max = Math.max(max,value);
        }
    }

    public static void solve() {
        long left = 0;
        long right = max + 1;   // count 횟수 더해줄때, mid 로 나누기 과정에서 0으로 나눌 수 없다.
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += data.get(i) / mid;
            }

            if (count >= N) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(right - 1);
    }
}
