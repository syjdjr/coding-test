package algo_practice;

public class ExchangeSort {
    public static void main(String[] args) {
        int[] S = {2,11, 4, 3, 9, 1};
        exchangeSort(5, S);
    }

    private static void exchangeSort(int n, int[] S) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (S[j] < S[i]) {
                    int temp = S[j];
                    S[j] = S[i];
                    S[i] = temp;
                }
                // 과정 확인용
                for(int k : S) {
                    System.out.print(k + " ");
                }
                System.out.println();
            }
        }
    }
}
