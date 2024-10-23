package algo_practice;

public class BinomialCoefficientDC {
    public static void main(String[] args) {
        int result = binomialCoefficient(5, 2);

        System.out.println(result);
    }

    // 시간복잡도 통한 성능 확인하기
    private static int binomialCoefficient(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        } else {
            return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
        }
    }
}
