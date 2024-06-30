package boj_0625_2606;

import java.io.*;
import java.util.*;

public class Main {

    private static StringTokenizer st;
    private static int[][] edgeMap;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        edgeMap = new int[V][V];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            edgeMap[A][B] = 1;
            edgeMap[A][B] = 1;

        }
    }

    public static void solve() {


    }

    public static void dfs(int start) {

    }
}
