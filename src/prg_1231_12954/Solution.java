package prg_1231_12954;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = (long)x * (i + 1);
        } 
        // 10,000,000
        return answer;
    }
}