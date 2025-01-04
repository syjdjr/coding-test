package prg_0104_154539;

import java.util.*;

// 시간초과 발생
class Solution1 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        for (int i = 0; i < numbers.length; i++) {
            int[] canCompare = new int[numbers.length];

            for (int j = i + 1; j < numbers.length; j++) {
                canCompare[j] = numbers[j];
            }
            Arrays.sort(canCompare);

            if (numbers[i] < canCompare[numbers.length - 1]) {
                for(int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] < numbers[j]) {
                        answer[i] = numbers[j];
                        break;
                    }
                }
            }
        }

        return answer;
    }
}