package prg_0108_154538;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisit = new boolean[y + 1];

        pq.offer(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.sum == y) {
                return node.count;
            }

            if (isVisit[node.sum]) {
                continue;
            }

            isVisit[node.sum] = true;

            if (isPromising(node.sum + n, y, isVisit)) {
                pq.offer(new Node(node.sum + n, node.count + 1));
            }
            if (isPromising(node.sum * 2, y, isVisit)) {
                pq.offer(new Node(node.sum * 2, node.count + 1));
            }
            if (isPromising(node.sum * 3, y, isVisit)) {
                pq.offer(new Node(node.sum * 3, node.count + 1));
            }
        }

        return -1;
    }

    public boolean isPromising(int nodeNumIsSum, int y, boolean[] isVisit) {
        if (nodeNumIsSum > y || isVisit[nodeNumIsSum]) {
            return false;
        }
        return true;
    }

    public class Node implements Comparable<Node> {
        int sum;
        int count;

        public Node(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }

        @Override
        public int compareTo(Node node) {
            return this.count - node.count;
        }
    }
}
