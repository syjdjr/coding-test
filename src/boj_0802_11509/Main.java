package boj_0802_11509;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer> data = new ArrayList<>();
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }

        isVisit = new boolean[N];
    }

    static void solve() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (!isVisit[i]) {
                count++;
                int now = data.get(i);

                for (int j = i + 1; j < N; j++) {
                    if (data.get(j) == now - 1 && !isVisit[j]) {
                        now = data.get(j);
                        isVisit[j] = true;

                    }
                }
            }
        }
        System.out.println(count);
    }
}
