package algo_knapsack;

import java.util.Arrays;

public class Main {
    static int W; // 최대 무게
    static int[] weights; // 물체의 무게
    static int[] profits; // 물체의 가치
    static int n; // 물체의 수
    static int maxProfit = 0; // 최대 이익
    static int numBest = 0; // 최적 선택 물건 인덱스
    static String[] bestSet; // 최적 선택 집합
    static String[] include; // 선택 여부 기록

    public static void main(String[] args) {
//        // 교재 데이터: Example 5.6
//        W = 16; // 최대 무게
//        weights = new int[]{0, 2, 5, 10, 5}; // 물체의 무게 (0은 더미)
//        profits = new int[]{0, 40, 30, 50, 10}; // 물체의 가치 (0은 더미)
//        n = 4; // 물체의 수

        // 자작 데이터
        W = 10;
        weights = new int[]{0, 5, 6, 4, 5};
        profits = new int[]{0, 100, 60, 20, 10};
        n = 4;

        include = new String[n + 1];
        bestSet = new String[n + 1];

        // 초기화
        Arrays.fill(include, "NO");
        Arrays.fill(bestSet, "NO");

        // 알고리즘 실행
        knapsack(0, 0, 0);

        // 결과 출력
        System.out.println("최대 이익: " + maxProfit);
        System.out.print("최적 선택 집합: ");
        for (int i = 1; i <= n; i++) {
            if (bestSet[i].equals("YES")) {
                System.out.print(i + " ");
            }
        }
    }

    static void knapsack(int i, int profit, int weight) {
        if (weight <= W && profit > maxProfit) { // 현재까지의 최대 이익 갱신
            maxProfit = profit;
            numBest = i;
            bestSet = Arrays.copyOf(include, include.length);
            System.out.println("최대 이익 갱신: " + maxProfit + " at item " + i);
        }

        if (promising(i, profit, weight)) {
            include[i + 1] = "YES"; // 현재 물체 포함
            knapsack(i + 1, profit + profits[i + 1], weight + weights[i + 1]);
            include[i + 1] = "NO"; // 현재 물체 미포함
            knapsack(i + 1, profit, weight);
        }
    }

    static boolean promising(int i, int profit, int weight) {
        int j, k;
        int totalWeight;
        float bound;

        if (weight >= W) return false; // 무게 초과
        else {
            j = i + 1;
            bound = profit;
            totalWeight = weight;

            while (j <= n && totalWeight + weights[j] <= W) {
                totalWeight += weights[j];
                bound += profits[j];
                j++;
            }

            k = j;

            if (k <= n) {
                bound += (W - totalWeight) * (profits[k] / weights[k]); // 부분 물체 포함
            }

            return bound > maxProfit; // promising 여부
        }
    }
}