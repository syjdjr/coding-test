package prg_0104_154539;

import java.util.*;

class Solution2 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (int i = 0; i <  numbers.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().value < numbers[i]) {
                Node node = minHeap.poll();
                answer[node.index] = numbers[i];
            }

            minHeap.offer(new Node(i, numbers[i]));
        }

        return answer;
    }

    static class Node implements Comparable<Node> {
        int index, value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node newNode){
            return this.value - newNode.value;
        }
    }
}
