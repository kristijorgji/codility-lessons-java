package com.kristijorgji.codility.lessons._14_binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/">MinMaxDivision</a>
 *
 * You are given integers K, M and a non-empty array A consisting of N integers.
 * Every element of the array is not greater than M.
 *
 * You should divide this array into K blocks of consecutive elements.
 * The size of the block is any integer between 0 and N. Every element of the array should belong to some block.
 *
 * The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.
 *
 * The large sum is the maximal sum of any block.
 *
 * For example, you are given integers K = 3, M = 5 and array A such that:
 *
 *   A[0] = 2
 *   A[1] = 1
 *   A[2] = 5
 *   A[3] = 1
 *   A[4] = 2
 *   A[5] = 2
 *   A[6] = 2
 * The array can be divided, for example, into the following blocks:
 *
 * [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
 * [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
 * [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
 * [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
 * The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
 *
 * Write a function:
 *
 * class Solution { public int solution(int K, int M, int[] A); }
 *
 * that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.
 *
 * For example, given K = 3, M = 5 and array A such that:
 *
 *   A[0] = 2
 *   A[1] = 1
 *   A[2] = 5
 *   A[3] = 1
 *   A[4] = 2
 *   A[5] = 2
 *   A[6] = 2
 * the function should return 6, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and K are integers within the range [1..100,000];
 * M is an integer within the range [0..10,000];
 * each element of array A is an integer within the range [0..M].
 */
public class MinMaxDivision {
    /**
     * 100% solution
     * We know that the max possible of a block is N * M (1 block containing all elements)
     * We use binary search to assume different block sizes until we find the lowest
     * one that fulfills the given criteria of having K blocks.
     * If the condition is met, then we repeat the same algorithm on the left part to see if we can find
     * some other possible sum of block value, which is lower that still fulfills the required conditions.
     */
    public int optimizedSolution(int K, int M, int[] A)
    {
        int length = A.length;
        int end = length * M;
        int start = 0;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            //int mid = start + (end - start) / 2;
            if (findRequiredBlocksNumber(A, mid, K) <= K) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private int findRequiredBlocksNumber(int[] A, int maxBlockSum, int K) {
        int sum = 0;
        int requiredBlocks = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > maxBlockSum) {
                return K + 1;
            }

            sum += A[i];
            if (sum > maxBlockSum) {
                requiredBlocks++;
                sum = A[i];
            }
        }

        if (sum > 0) {
            requiredBlocks++;
        }

        return requiredBlocks;
    }

    /**
     * TODO brute force slow solution
     */
    public int solution(int K, int M, int[] A)
    {
        int length = A.length;
        int[] prefixSums = new int[length + 1];
        ArrayList<Integer> minLargestSums = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            prefixSums[i + 1] = prefixSums[i] + A[i];
        }

        for (int groupsNr = K; groupsNr >= 1; groupsNr--) {
            int groupStartIndex = 0;
            int[] sums = new int[K];
            int groupsCaptured = 0;
            int membersNr = length / groupsNr;

            for (int j = 0; j < length && groupsCaptured <= groupsNr; j++) {
                if (groupsCaptured == groupsNr - 1) {
                    sums[groupsCaptured] = prefixSums[j + 1] - prefixSums[groupStartIndex];
                } else {
                    sums[groupsCaptured] = prefixSums[j + 1] - prefixSums[groupStartIndex];
                    if (j != 0 && j % membersNr == 0) {
                        groupStartIndex = j + 1;
                        groupsCaptured++;
                    }
                }
            }

            int largestSums = IntStream.of(sums).max().orElse(Integer.MIN_VALUE);
            minLargestSums.add(largestSums);
        }

        return Collections.min(minLargestSums);
    }
}
