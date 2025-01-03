package boj_0103_2805;

import java.util.*;
import java.io.*;

public class Main {
    public static int N;  //나무의 수
    public static long H;  //높이의 최대값
    public static int M;  //집으로 가져가려고 하는 나무의 길이
    public static int[] trees;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
    }

    private static void solve() {
        long left = 0;
        long right = trees[N - 1];

        while (left <= right) {
            long middle = ((left + right) / 2);

            if (sum(middle) >= M) {
                H = Math.max(H, middle);
                left = middle + 1;
            } else {
                right = middle - 1;

            }
//            System.out.print("left = " + left + ", right = " + right);
//            System.out.println();
        }

        System.out.println(H);
    }

    private static long sum(long H) {
        long sum = 0;
        for (int i : trees) {
            if (i > H) {
                sum += i - H;
            }
        }

        return sum;
    }
}
