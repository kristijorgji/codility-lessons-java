package com.kristijorgji.codility.lessons._5_prefixSums;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/">Min avg two slice</a>
 */
public class MinAvgTwoSlice {
    /**
     * 100% Correctness
     * 60% Performance
     */
    public int solution(int[] A)
    {
        final int N = A.length;
        int[] prefixSums = new int[N + 1];

        for (int i = 0; i < N; i++) {
            prefixSums[i + 1] = prefixSums[i] + A[i];
        }

        float min = Float.MAX_VALUE;
        int minPosition = -1;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                float sliceAverage =  (float) (prefixSums[j + 1] - prefixSums[i])  / (j - i + 1);

                if (min > sliceAverage) {
                    minPosition = i;
                    min = sliceAverage;

                }
            }
        }

        return minPosition;
    }

    /**
     * TODO 100% performance solution
     */
    public int optimizedSolution(int[] A) {
        return 0;
    }
}
