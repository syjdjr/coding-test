package algo_practice;

public class FibonacciIterative {
    private static int n;
    private static int[] f;

    public static void main(String[] args) {
        n = 3;
        f = new int[n + 1]; //f[0 ... n] 까지 처리해야하기 때문이다.

        int result = fibonacci(n);
        System.out.println(result);
    }

    private static int fibonacci(int n) {
        f[0] = 0;

        if (n > 0) {
            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
        }
        return f[n];
    }
}
