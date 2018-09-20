package com.kristijorgji.codility.lessons._5_prefixSums;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/">Count div</a>
 *
 * The number of integers divisible by K in the interval [0, B] is B / K (*1)
 * The number of integers divisible by K in the interval [0, A] is A / K (*2)
 * The diference between (*1) and (*2) gives the number of integers
 * divisible by K in the interval (A, B]. Thus, we only have to add one more
 * to that difference only if A itself can be divided by K.
 *
 */
public class CountDiv {
    public int solution(int A, int B, int K)
    {
        return B/K - A/K + (A % K == 0 ? 1 : 0);
    }
}
