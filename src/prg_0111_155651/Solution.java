package prg_0111_155651;

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        List<Node> list = new ArrayList<>();
        PriorityQueue<Node> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int min = 0;
        int count = 1;

        for (String[] bookTime : book_time) {
            int startHour = Integer.parseInt(bookTime[0].split(":")[0]);
            int startMinute = Integer.parseInt(bookTime[0].split(":")[1]);
            int startValue = startHour * 60 + startMinute;

            int endHour = Integer.parseInt(bookTime[1].split(":")[0]);
            int endMinute = Integer.parseInt(bookTime[1].split(":")[1]);
            int endValue = endHour * 60 + endMinute;

            pq1.offer(new Node(startValue, endValue));
        }

        while (!pq1.isEmpty()) {
            Node node = pq1.poll();

            if (!pq2.isEmpty()) {
                pq2.offer(node.endValue + 10);
                count += 1;

                if (node.startValue >= pq2.peek()) {
                    pq2.poll();
                }
            } else {
                pq2.offer(node.endValue + 10);
                count += 1;
            }

        }

        answer = pq2.size();
        return answer;
    }

    public class Node implements Comparable<Node> {
        int startValue;
        int endValue;

        public Node(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public int compareTo(Node node) {
            return this.startValue - node.startValue;
        }

        @Override
        public String toString() {
            return "Start:" + startValue + ", End: " + endValue;
        }
    }
}