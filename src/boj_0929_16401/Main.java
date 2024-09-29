package boj_0929_16401;

import java.io.*;
import java.util.*;

public class Main {
    private static int M, N;
    private static List<Integer> data = new ArrayList<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(data);
    }

    static void solve() {
        int low = 1;
        int high = data.get(N - 1);
        int mid = 0;
        int length = 0;

        while(low <= high) {
            mid = (high + low) / 2;
            int count = 0;

            for (int i = 0; i < N; i++) {
                count += data.get(i) / mid;
            }

            if (count >= M) {  //count == M이더라도, 더 긴 길이가 존재할 수 있음.
                length = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        sb.append(length);
        System.out.println(sb);
    }
}

