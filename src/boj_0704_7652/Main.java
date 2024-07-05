package boj_0704_7652;

import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N , startR, startC , targetR, targetC;

    private static int[] dR = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dC = {1, 2, 2, 1, -1, -2, -2, -1};


    public static void main(String[] args) throws IOException {
        setting();
    }
    
    public static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());    //길이
            st = new StringTokenizer(br.readLine());

            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetR = Integer.parseInt(st.nextToken());
            targetC = Integer.parseInt(st.nextToken());

            solve();
        }
        System.out.println(sb);
    }
    
    public static void solve() {
        Queue<Node> q = new LinkedList<>();

        boolean[][] isVisit = new boolean[N][N];
        int[][] Map = new int[N][N];

        q.add(new Node(startR,startC,0));
        isVisit[startR][startC] = true;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if (node.row == targetR && node.col == targetC) {
                sb.append(node.count).append('\n');
                break;
            }

            for (int i = 0; i < 8; i++) {
                int dr = node.row + dR[i];
                int dc = node.col + dC[i];
                
                if (dr < 0 || dc < 0 || dr >= N || dc >= N) {
                    continue;
                }
                
                if (isVisit[dr][dc] == true) {
                    continue;
                }

                isVisit[dr][dc] = true;
                q.add(new Node(dr,dc,node.count+1));
            }
        }
    }

    static class Node {
        int row, col, count;

        public Node(int row, int col,int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
