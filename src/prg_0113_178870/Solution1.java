package prg_0113_178870;

class Solution1 {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        long sum = 0;
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;

        while (right < sequence.length) {
            sum += sequence[right++];

            while (sum >= k) {
                if (sum == k) {
                    int length = right - left;
                    if (length < minLength) {
                        minLength = length;

                        answer[0] = left;
                        answer[1] = right - 1;
                    }
                }
                sum -= sequence[left++];
            }
        }

        return answer;
    }
}
