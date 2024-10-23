package algo_practice;

public class BinomialCoefficientDP {
    private static int n;
    private static int[][] B;

    public static void main(String[] args) {
        n = 5;
        B = new int[n][n];

        int result = binomialCoefficient(4, 2);
//        int result = binomialCoefficient(5, 2);   //array index out of bounds Exception 발생한다.
        System.out.println(result);
    }

    private static int binomialCoefficient(int n, int k) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i,k); j++) {  // Math.min(i,k) 주의하기.
                if (j == 0 || j == i) {
                    B[i][j] = 1;
                } else {
                    B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
                }
            }
        }
        return B[n][k];
    }
}
// //계산 가능한 다른 코드
//private static int binomialCoefficient(int n, int k) {
//    if (k > n) return 0;
//
//    for (int i = 0; i <= n; i++) {
//        for (int j = 0; j <= i; j++) {
//            if (j == 0 || j == i) {
//                B[i][j] = 1;
//            } else {
//                if (j <= k) { // j가 k보다 작거나 같은 경우에만 계산
//                    B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
//                }
//            }
//        }
//    }
//    return B[n][k];
//}
//}