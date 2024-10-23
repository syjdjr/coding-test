package algo_practice;

import java.util.Arrays;

public class MergeSortNoSpace {
    private static int[] S;

    public static void main(String[] args) {
        S = new int[] {2, 11, 4, 3, 9, 1}; // 배열 초기화
        int n = S.length; // n을 배열의 길이로 설정

        mergeSort(0, n - 1); // 병합 정렬 호출

        System.out.println(Arrays.toString(S)); // 정렬된 배열 출력
    }

    private static void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2; // 중간 인덱스 계산

            mergeSort(low, mid); // 왼쪽 부분 정렬
            mergeSort(mid + 1, high); // 오른쪽 부분 정렬
            merge(low, mid, high); // 병합
        }
    }

    private static void merge(int low, int mid, int high) {
        int[] U = new int[high - low + 1]; // 지역 배열 U 생성

        int i = low; // 왼쪽 부분의 시작 인덱스
        int j = mid + 1; // 오른쪽 부분의 시작 인덱스
        int k = 0; // U 배열의 인덱스

        // 두 부분을 병합
        while (i <= mid && j <= high) {
            if (S[i] < S[j]) {
                U[k] = S[i];
                i++;
            } else {
                U[k] = S[j];
                j++;
            }
            k++;
        }

        // 왼쪽 부분이 남아있는 경우
        while (i <= mid) {
            U[k] = S[i];
            i++;
            k++;
        }

        // 오른쪽 부분이 남아있는 경우
        while (j <= high) {
            U[k] = S[j];
            j++;
            k++;
        }

        // U의 값을 S에 복사
        for (int m = 0; m < U.length; m++) {
            S[low + m] = U[m];
        }
    }
}
