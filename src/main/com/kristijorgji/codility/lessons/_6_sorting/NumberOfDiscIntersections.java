package com.kristijorgji.codility.lessons._6_sorting;

public class NumberOfDiscIntersections {
    public int solution(int[] A)
    {
        int nrIntersections = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if ((long) (A[j] + A[i]) >= (long) (j - i)) {
                    nrIntersections++;
                }
            }
        }

        return nrIntersections > 10_000_000 ? -1 : nrIntersections;
    }
}
