package prg_1231_12944;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        for (int i : arr) {
            answer += i;
        }
        answer = answer / arr.length;
        
        return answer;
    }
}