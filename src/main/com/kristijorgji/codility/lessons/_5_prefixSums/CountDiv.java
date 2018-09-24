package com.kristijorgji.codility.lessons._5_prefixSums;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/">Count div</a>
 *
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 *
 */
public class CountDiv {
    /**
     * 100% score
     * The number of integers divisible by K in the interval [0, B] is B / K (*1)
     * The number of integers divisible by K in the interval [0, A] is A / K (*2)
     * The diference between (*1) and (*2) gives the number of integers
     * divisible by K in the interval (A, B]. Thus, we only have to add one more
     * to that difference only if A itself can be divided by K.
     */
    public int solution(int A, int B, int K)
    {
        return B/K - A/K + (A % K == 0 ? 1 : 0);
    }
}
