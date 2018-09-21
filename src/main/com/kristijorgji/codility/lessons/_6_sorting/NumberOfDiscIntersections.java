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

        for (int i = 0; i < A.length - 1; i++) {
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
     * 100% solution
     * Credits go to https://rafal.io/posts/codility-intersecting-discs.html
     * I am adding more explanations and refactoring the code
     *
     * Two circles intersect if the following predicate holds true
     * j - i <= A[i] + A[j]
     * A[i] + i >= -(A[j] - j)
     *
     * The solution is the number of times which the following
     * predicate holds true
     * {
     *     A[i] + i >= -(A[j] - j)
     *     j > i
     * }
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

        Arrays.sort(A1); //We can also skip sorting this one, not necessary
        Arrays.sort(A2); //We need to sort this one in O(Nlog(N)), in order to perform binary search on it later

        long cnt = 0;

        /*
         *  We will count how many times the predicate
         *  A[i] + i >= -(A[j] - j) holds true
         *  We are comparing all N^2 (i,j) pairs,
         *  later we will need to subtract the degenerate solutions
         *
         *  We care only for the cases when j > i, like we would do in
         *  a O(N^2) solution in which we would nest two for loops, to
         *  compare any tuple between A1 and A2 only once
         *
         */
        for(int i = 0; i < N; i++){
            int pos = Arrays.binarySearch(A2, A1[i]);

            if(pos >= 0) {
                while(pos < N && A2[pos] == A1[i]){
                    pos++;
                }
                cnt += pos;
            } else {
                /*
                 * element not found in A[2]
                 * returned value from binarySearch is
                 * (-(insertion point) – 1)
                 */
                int insertionPoint = -(pos + 1);
                cnt += insertionPoint; //A1[i] is >= {insertionPoint} number of elements in A[2]
            }
        }

        long sub = (long)N*((long)N+1)/2;
        /*
          We have N^2 (i,j) pairs, but we only care about those where j > i,
          as otherwise my predicate trivially holds.
          That means we have to eliminate all pairs where (j <= i).
          Say you have the list [x_1,x_2,x_3,...,x_k], you want to eliminate the tuples
          {(x_1,x_1),(x_1,x_2),(x_1,x_3),...(x_1,x_n)} for x_1.
          There is N of those. For x_2, you have (N-1).
          For x_k, you only have to ignore x_k, so 1 pair. You get N + (N-1) + (N-2) + ... + 1
          tuples you have to eliminate – this is known to be N(N+1)/2.
          The above is an Arithmetic Progression that's why the sum is N(N+1)/2
         */
        cnt = cnt - sub;

        if(cnt > 1e7) return -1;

        return (int) cnt;
    }
}
