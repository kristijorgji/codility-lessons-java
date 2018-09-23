package com.kristijorgji.codility.lessons._6_sorting;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/">MaxProductOfThree</a>
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
