package boj_0809_16928;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static boolean[] isVisit;
    private static List<Map> ladder = new ArrayList<>();    //사다리
    private static List<Map> snake = new ArrayList<>();     //뱀

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //사다리의 수
        M = Integer.parseInt(st.nextToken());   //뱀의수

        //사다리 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());   //x번 칸에 도착시
            int y = Integer.parseInt(st.nextToken());   //y번 칸으로 이동

            ladder.add(new Map(x, y));
        }

        //뱀의 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());   //u번 칸에 도착시
            int v = Integer.parseInt(st.nextToken());   //v번 칸으로 이동

            snake.add(new Map(u, v));
        }

        isVisit = new boolean[101];
    }

    static void solve() {
        Queue<Node> q = new LinkedList<>();

        isVisit[1] = true;
        q.add(new Node(1, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int now = node.now;

            if (now == 100) {
                System.out.println(node.dist);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100){
                    continue;
                }

                for (Map map1 : ladder) {
                    if (next == map1.before) {
                        next = map1.after;
                        break;
                    }
                }

                for (Map map2 : snake) {
                    if (next == map2.before) {
                        next = map2.after;
                        break;
                    }
                }

                q.add(new Node(next, node.dist + 1));
                isVisit[next] = true;
            }
        }
    }

    static class Map {
        int before, after;

        public Map (int before, int after) {
            this.before = before;
            this.after = after;
        }
    }

    static class Node {
        int now, dist;

        public Node(int now, int dist) {
            this.now = now;
            this.dist = dist;
        }
    }
}
