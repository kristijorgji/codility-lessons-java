package com.kristijorgji.codility.lessons._6_sorting;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/">MaxProductOfThree</a>
 *
 * A non-empty array A consisting of N integers is given.
 * The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 *
 * For example, array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * contains the following example triplets:
 *
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 *
 * For example, given array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
public class MaxProductOfThree {
    /**
     * 100%
     * Can be done by using less space (without storing possible values). See improvedSolution
     */
    public int solution(int[] A)
    {
        final int length = A.length;
        Arrays.sort(A);

        ArrayList<Integer> possible = new ArrayList<>();
        // the product of two negative numbers is positive, so we need to consider that possibility
        if (A[0] < 0 && length > 3) {
            possible.add(A[0] * A[1] * A[2]);
            possible.add(A[1] * A[2] * A[3]);
            possible.add(A[0] * A[1] * A[length - 1]);
            possible.add(A[1] * A[2] * A[length - 1]);
        }
        possible.add(A[length - 1] * A[length - 2] * A[length - 3]);

        possible.sort(Collections.reverseOrder());
        return possible.get(0);
    }

    /**
     * 100% solution
     * After sorting there are only three possible candidates for max product
     * First three (in case of two negative, and one positive)
     * Last three
     * Two  first ones (in case of being both negative, will give positive number) * last one
     */
    public int improvedSolution(int[] A)
    {
        final int length = A.length;
        Arrays.sort(A);

        return Math.max(
                Math.max(
                        A[0] * A[1] * A[2],
                        A[length - 1] * A[length - 2] * A[length - 3]
                ),
                A[0] * A[1] *  A[length - 1]
        );
    }
}
