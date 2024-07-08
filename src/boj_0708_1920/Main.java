package boj_0708_1920;

import java.util.*;
import java.io.*;

public class Main {

    private static int x, N;
    private static List<Integer> A = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        setting();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            x = Integer.parseInt(st.nextToken());
            solve(x);
        }

        System.out.println(sb);
    }

    public static void solve(int x) {
        int result = Collections.binarySearch(A, x);

        if (result >= 0) {
            sb.append(1).append('\n');
        } else {
            sb.append(0).append('\n');
        }
    }
}

//Collections 의 binarySearch 는 찾는 값이 없으면 음수를 반환한다.
