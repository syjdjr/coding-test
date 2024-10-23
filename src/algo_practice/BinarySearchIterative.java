package algo_practice;

public class BinarySearchIterative {
    private static int n;
    private static int findX;
    private static int[] S;

    public static void main(String[] args) {
        findX = 5;
        n=10;
//        S = new int[]{10,3,2,7,11,5,1,9,6,8};
        S = new int[]{1,2,3,5,6,7,8,9,10,11};

        binarySearch();
    }

    private static void binarySearch() {
        int location = 0;
        int low;
        int high;
        int mid;

        low = 0;
        high = n-1;

        while (low <= high && location == 0) {
            mid = (low + high) / 2;
            if (findX == S[mid]) {
                location = mid;
            }else if (findX < S[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(location);
    }
}
