package com.kristijorgji.codility.lessons._6_sorting;

import java.util.Arrays;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/">NumberOfDiscIntersections</a>
 */
public class NumberOfDiscIntersections {
    /**
     * 55% solution O(N^2)
     */
    public int solution(int[] A)
    {
        long nrIntersections = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if ((long) (A[j] + A[i]) >= (long) (j - i)) {
                    nrIntersections++;
                }
            }
        }

        if (nrIntersections > 1e7) return -1;
        return (int) nrIntersections;
    }

    /**
     * TODO
     * 100% solution
     * https://rafal.io/posts/codility-intersecting-discs.html
     *
     * j - i <= A[i] + A[j]
     * A[i] + i >= -(A[j] - j)
     */
    public int optimizedSolution(int[] A)
    {
        final int N = A.length;

        long[] A1 = new long[N];
        long[] A2 = new long[N];

        for(int i = 0; i < N; i++){
            A1[i] = (long) A[i] + i;
            A2[i] = -((long) A[i] - i);
        }

        Arrays.sort(A1);
        Arrays.sort(A2);

        long cnt = 0;

        for(int i = 0; i < N; i++){
            int pos = Arrays.binarySearch(A2, A1[i]);

            if(pos >= 0) {
                while(pos < N && A2[pos] == A1[i]){
                    pos++;
                }
                cnt += pos;
            } else { // element not there
                int insertionPoint = -(pos + 1);
                cnt += insertionPoint;
            }
        }

        long sub = (long)N*((long)N+1)/2;
        cnt = cnt - sub;

        if(cnt > 1e7) return -1;

        return (int) cnt;
    }
}
