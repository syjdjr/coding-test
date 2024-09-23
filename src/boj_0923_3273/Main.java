package boj_0923_3273;

import java.util.*;
import java.io.*;

public class Main {
    private static int N, X;
    private static int count = 0;
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
        for(int i = 0; i < N; i++) {
            cal(i);
        }
        System.out.println(count);
    }

    private static void cal(int index) {
        int low = index + 1;
        int high = N - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (data.get(mid) == X - data.get(index)) {
                count += 1;
                break;
            } else if (data.get(mid) < X - data.get(index)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }


        }
    }
}
