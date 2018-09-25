package com.kristijorgji.codility.lessons._9_maxSliceProblem;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/">MaxSliceSum</a>
 *
 * A non-empty array A consisting of N integers is given.
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
 * The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 *
 * For example, given array A such that:
 *
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 *
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 */
public class MaxSliceSum {

    public int solution(int[] A)
    {
        int maxSoFar = -1_000_001;
        int maxSliceSum = -1_000_001;
        for (int v : A) {
            maxSoFar = Math.max(v, maxSoFar + v);
            maxSliceSum = Math.max(maxSliceSum, maxSoFar);
        }

        return maxSliceSum;
    }

    /**
     * I provide a solution which also finds the start and end index of the
     * slice with maximum sum for completeness.
     */
    public int solutionFindingAlsoIndexes(int[] A)
    {
        int maxSoFar = -1_000_001;
        int maxSliceSum = -1_000_001;
        int startIndexCandidate = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            if (maxSoFar + v > v) {
                maxSoFar = maxSoFar + v;
            } else {
                maxSoFar = v;
                startIndexCandidate = i;
            }

            if (maxSliceSum < maxSoFar) {
                endIndex = i;
                startIndex = startIndexCandidate;
                maxSliceSum = maxSoFar;
            }
        }

        System.out.printf("Slice with maximum sum %d starts at %s and ends at %s\n",  maxSliceSum, startIndex, endIndex);
        return maxSliceSum;
    }
}
