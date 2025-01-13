package prg_0113_178870;

import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        long sum = sequence[0];
        int startIdx = 0, endIdx = sequence.length - 1;
        int[] answer = new int[2];
        
        while (left <= right && right < sequence.length) {            
            if (sum == k) {
                if (endIdx - startIdx > right - left) {
                    startIdx = left;
                    endIdx = right;
                }
                if (++right >= sequence.length) {
                    break;
                }
                
                sum += sequence[right];
            } else if (sum < k) {
                if (++right >= sequence.length) {
                    break;
                }
                
                sum += sequence[right];
            } else {
                sum -= sequence[left++];
            }
        }
        
        answer[0] = startIdx;
        answer[1] = endIdx;
        return answer;
    }
}
