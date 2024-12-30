package algo_practice;

public class BinarySearchRecursive {
    private static int n;
    private static int[] S;
    private static int findX;

    public static void main(String[] args) {
        findX = 5;
        S = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        n = 10;

        binarySearch(1, n);
    }

    private static void binarySearch(int low, int high) {
        int mid = 0;

        if (low > high) {
            System.out.println(0);
        } else {
            mid = (low + high) / 2;
            if (findX == S[mid]) {
                System.out.println(mid);    //index 확인
            } else if (findX < S[mid]) {
                binarySearch(low, mid - 1);
            } else {
                binarySearch(mid + 1, high);
            }
        }
        ;
    }
}
