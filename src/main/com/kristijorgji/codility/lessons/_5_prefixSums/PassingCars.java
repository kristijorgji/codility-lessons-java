package com.kristijorgji.codility.lessons._5_prefixSums;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/">Passing cars</a>
 *
 * A non-empty array A consisting of N integers is given.
 * The consecutive elements of array A represent consecutive cars on a road.
 *
 * Array A contains only 0s and/or 1s:
 *
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N,
 * is passing when P is traveling to the east and Q is traveling to the west.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 *
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 *
 * For example, given:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 */
public class PassingCars {
    /**
     * https://app.codility.com/demo/results/trainingYU8AN7-U2T/
     * 100% score
     *
     * The idea here is to use prefix sums in order to keep track of the
     * amount of total zeros until each index.
     *
     * Knowing that the condition for a passing pair is:
     * {
     *     A[P] = 0
     *     A[Q] = 1
     *     0 <= Q < P < N
     * }
     *
     * We are interested in  the total number of zeros found on the left of each one found.
     * Foreach 1 found in [1, N-1], we add the count of zeros found in the interval [0, foundOnesPosition],
     * as that is equal to the possible pairs meeting the conditions above
     *
     */
    public int solution(int[] A)
    {
        final int N = A.length;
        int[] zerosAtIndex = new int[N + 1];
        for (int i = 0; i < N; i++) {
            zerosAtIndex[i + 1] = zerosAtIndex[i] + (A[i] == 0 ? 1 : 0);
        }

        long c = 0;
        for (int i = 1; i < N; i++) {
            if (A[i] == 1) {
                c += zerosAtIndex[i];
            }
        }

        if (c > 1e9) {
            return -1;
        }

        return (int) c;
    }
}
