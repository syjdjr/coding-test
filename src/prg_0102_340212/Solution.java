package prg_0102_340212;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        for (int i : diffs) {
            answer = Math.max(answer, i);
        }

        int left = 1;
        int right = answer;

        // 시간 초과 문제
        while (left <= right) {
            int mid = (left + right) / 2;

            if (solve(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean solve(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0; //결과값 자료형 범위

        for (int i = 0; i < diffs.length; i++) {
            int puzzleLevel = diffs[i];
            int timeCurr = times[i];
            int timePrev = i > 0 ? times[i - 1] : 0;    //index 벗어나는 문제

            if (puzzleLevel <= level) {
                totalTime += timeCurr;
            } else {
                int mistakes = puzzleLevel - level;
                totalTime += mistakes * (timeCurr + timePrev) + timeCurr;
            }

            if (totalTime > limit) {
                return false;
            }
        }

        return true;
    }
}
