package prg_1229_12928;

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
    
        for (int j = 1; j <= Math.sqrt(n); j++) {
            if (n % j == 0) {
                answer += n / j + j;
                
                if (n / j == j) {
                    answer -= j;
                }
            }
        }
        
        return answer;
    }
}