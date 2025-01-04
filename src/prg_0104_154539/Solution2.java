package prg_0104_154539;

import java.util.*;

class Solution2 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((nowNum, newNum) -> nowNum[0] - newNum[0]);

        for (int i = 0; i <  numbers.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] < numbers[i]) {
                int[] top = minHeap.poll();
                answer[top[1]] = numbers[i];
            }

            int[] element = new int[2];
            element[0] = numbers[i];
            element[1] = i;

            minHeap.offer(element);

            //minHeap.offer(new int[]{numbers[i], i});
        }

        return answer;
    }
}
