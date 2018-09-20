package com.kristijorgji;

import com.kristijorgji.codility.lessons._5_prefixSums.GenomicRangeQuery;

import java.util.Arrays;

/**
 *  Each solution has it's test cases under tests/
 *  This file is redundant and used only for fast prototyping.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println((long) (Integer.MAX_VALUE) + 1011);
        GenomicRangeQuery solution = new GenomicRangeQuery();
        int[] result = solution.solution(
                "CAGCCTA",
                new int[] {
                        2, 5, 0
                },
                new int[] {
                        4, 5, 6
                }
        );

        System.out.println(Arrays.toString(result));
    }
}
