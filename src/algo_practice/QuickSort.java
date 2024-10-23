package algo_practice;

public class QuickSort {
    private static int[] S;
    private static int n;

    public static void main(String[] args) {
        S = new int[] {2, 11, 4, 3, 9, 1}; // 배열 초기화
        n = S.length; // n을 배열의 길이로 설정

        quickSort(0, n - 1); // 퀵 정렬 호출

        for (int i : S) {
            System.out.print(i + " "); // 정렬된 배열 출력
        }
    }

    private static void quickSort(int low, int high) {
        if (high > low) {
            int pivotpoint = partition(low, high); // 파티션을 호출하여 피벗 포인트 반환
            quickSort(low, pivotpoint - 1); // 왼쪽 부분 정렬
            quickSort(pivotpoint + 1, high); // 오른쪽 부분 정렬
        }
    }

    private static int partition(int low, int high) {
        int pivotitem = S[low]; // 피벗 아이템 설정
        int j = low; // 피벗 위치 초기화

        for (int i = low + 1; i <= high; i++) {
            if (S[i] < pivotitem) {
                j++;
                // 스와핑
                int temp = S[i];
                S[i] = S[j];
                S[j] = temp;
            }
        }
        // 피벗을 올바른 위치로 이동
        int temp = S[low];
        S[low] = S[j];
        S[j] = temp;

        // privotpoint = j;
        return j; // 새로운 피벗 포인트 반환
    }
}
