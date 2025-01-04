package prg_0104_154539;

import java.util.*;

class Solution2 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((nowNum, newNum) -> nowNum[1] - newNum[1]);

        for (int i = 0; i <  numbers.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[1] < numbers[i]) {
                int[] top = minHeap.poll();
                answer[top[0]] = numbers[i];
            }

            int[] node = new int[2];
            node[0] = i;
            node[1] = numbers[i];

            minHeap.offer(node);
        }

        return answer;
    }
}
