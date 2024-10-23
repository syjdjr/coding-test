package algo_practice;

public class FibonacciRecursive {
    private static int n;
    private static int[] f;

    public static void main(String[] args) {
        n = 3;
        f = new int[n + 1];

        int result = fibonacci(n);
        System.out.println(result);

    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
