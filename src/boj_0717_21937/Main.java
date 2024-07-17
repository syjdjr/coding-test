package boj_0717_21937;

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, start, count;
    private static List<Integer>[] map;
    private static Queue<Integer> q = new LinkedList<>();
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //작업할 개수
        M = Integer.parseInt(st.nextToken());   //작업 순서 정보 개수

        isVisit = new boolean[N + 1];

        map = new LinkedList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map[B].add(A);
        }

        start = Integer.parseInt(br.readLine());    //시작 정점
    }

    static void solve() {

        q.add(start);
        isVisit[start] = true;
        count = 0;

        while (!q.isEmpty()) {
            int vertex = q.poll();

            for (int i : map[vertex]) {

                if (isVisit[i]) {
                    continue;
                }

                q.add(i);
                isVisit[i] = true;
                count ++;
            }
        }

        System.out.println(count);
    }
}