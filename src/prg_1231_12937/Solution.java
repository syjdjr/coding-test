package prg_1231_12937;

class Solution {
    public String solution(int num) {
        String answer = "";
        
        if (num % 2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }
        
        return answer;
    }
}