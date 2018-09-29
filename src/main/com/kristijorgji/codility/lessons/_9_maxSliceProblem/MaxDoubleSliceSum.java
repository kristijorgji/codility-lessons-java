package com.kristijorgji.codility.lessons._9_maxSliceProblem;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/">MaxDoubleSliceSum</a>
 *
 * A non-empty array A consisting of N integers is given.
 *
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 *
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 *
 * For example, array A such that:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * contains the following example double slices:
 *
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
public class MaxDoubleSliceSum {
    /**
     * 100% solution
     *
     * We use Kadane's algorithm to find the max contiguous sums from both directions.
     * maxEndingAtIndex[i] contains the max sum of the contiguous sub sequence from 0 up to i
     * maxStartingAtIndex[i] contains the max sum of the contiguous sub sequence from i up to N - 1
     * We can ignore adding the sums at index 0 and N - 1, as those are never going to get used as described by the problem.
     *
     * In the end we iterate, and find the maximum sum of the double slice which is the max of the sum of the sub slices.
     * Also another trick to keep in mind here is that the max of a consecutive slice will never be negative,
     * because at worst case the sum of a consecutive slice (i, i+1, i+2) will be 0 as per the problem definition.
     */
    public int solution(int[] A)
    {
        final int N = A.length;
        int[] maxEndingAtIndex = new int[N];
        int[] maxStartAtIndex = new int[N];

        for (int i = 1; i < N - 1; i++) {
            int fEl = A[i];
            int bEl =  A[N - 1 - i];

            /*
             * Math.max(0, maxEndingAtIndex[i - 1] + fEl) instead of Math.max(fel, 0, maxEndingAtIndex[i - 1] + fEl)
             * as the empty double-slice (n, n+1, n+2) with sum 0 is always better than any double slice with a negative sum.
             */
            maxEndingAtIndex[i] = Math.max(0, maxEndingAtIndex[i - 1] + fEl);
            maxStartAtIndex[N - 1 - i] = Math.max(0, maxStartAtIndex[N - i] + bEl);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N - 1; i++) {
             int maxContiguousSumSoFar = maxEndingAtIndex[i - 1];
             int maxCountiguousSumStaringFrom = maxStartAtIndex[i + 1];
             max = Math.max(max, maxContiguousSumSoFar + maxCountiguousSumStaringFrom);
        }

        return max;
    }
}
