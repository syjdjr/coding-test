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

        N = Integer.parseInt(st.nextToken());       //나무의 수
        M = Integer.parseInt(st.nextToken());       //자른 나무의 최소값

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));

            max = Math.max(max, data.get(i));
        }
    }

    public static void solve() {
        int left = 0;
        int right = max;

        while (left < right) {

            int mid = (left + right) / 2;
            long sum = 0;        //자른 나무의 총합

            for (int i = 0; i < N; i++) {
                if (data.get(i) - mid > 0) {
                    sum += data.get(i) - mid;
                }
            }

            if (sum >= M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left-1);
        //upper bound 당연히 출력할때 right - 1, left - 1
    }
}
// 최솟값 구하는 경우 아니면 upper bound 를 사용해준다.