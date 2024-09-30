package boj_0930_30804;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer> data = new ArrayList<>();
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < N) {
            map.put(data.get(right), map.getOrDefault(data.get(right), 0) + 1); //map.get()하면 null일경우 exception발생. map.getOrDefault( , ) 는 null일경우 지정한 값으로 대체.
            right = right + 1;

            while(map.size() >= 3) {
                map.put(data.get(left), map.get(data.get(left)) - 1);
                if (map.get(data.get(left)) == 0) {
                    map.remove(data.get(left));
                }
                left = left + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        System.out.println(maxLength);
    }
}