package algo_practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] S = {2, 11, 4, 3, 9, 1}; // 배열 초기화
        int n = S.length; // 배열의 길이를 n으로 설정

        mergeSort(n, S); // 병합 정렬 호출

        System.out.println(Arrays.toString(S)); // 정렬된 배열 출력
    }

    private static void mergeSort(int n, int[] S) {
        if (n > 1) {
            int h = n / 2; // 중간 인덱스
            int m = n - h; // 오른쪽 부분의 크기

            // 임시 배열 생성
            int[] U = new int[h]; // 왼쪽 부분 배열
            int[] V = new int[m]; // 오른쪽 부분 배열

            // 배열을 두 부분으로 나누기
            for (int i = 0; i < h; i++) {
                U[i] = S[i]; // 왼쪽 부분 배열에 값 복사
            }
            for (int i = 0; i < m; i++) {
                V[i] = S[h + i]; // 오른쪽 부분 배열에 값 복사
            }

            // 재귀 호출
            mergeSort(h, U); // 왼쪽 부분 정렬
            mergeSort(m, V); // 오른쪽 부분 정렬
            merge(h, m, U, V, S); // 두 부분 병합
        }
    }

    private static void merge(int h, int m, int[] U, int[] V, int[] S) {
        int i = 0, j = 0, k = 0; // 인덱스 초기화

        // 두 배열을 병합
        while (i < h && j < m) {
            if (U[i] <= V[j]) {
                S[k++] = U[i++]; // U의 값 추가
            } else {
                S[k++] = V[j++]; // V의 값 추가
            }
        }

        // 남은 요소가 있을 경우 U에서 복사
        while (i < h) {
            S[k++] = U[i++];
        }

        // 남은 요소가 있을 경우 V에서 복사
        while (j < m) {
            S[k++] = V[j++];
        }
    }
}
