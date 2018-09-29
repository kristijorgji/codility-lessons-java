package com.kristijorgji.codility.lessons._10_primeAndComposite;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/">CountFactors</a>
 *
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
 *
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given a positive integer N, returns the number of its factors.
 *
 * For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24.
 * There are no other factors of 24.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..2,147,483,647].
 */
public class CountFactors {
    /**
     * 100% correctness, 92% performance
     * Based on one divisor, we can find the symmetric divisor.
     * Ex: 8 / 2 = 4, 4 is the symmetric divisor.  8/4 = 2
     * Knowing this and the fact that one of the symmetric divisors must be < sqr(n),
     * then we can iterate only sqr(N) times.
     */
    public int solution(int N)
    {
        int factorsNr = 0;
        int i = 1;
        while (i * i < N) {
            if (N % i == 0) {
                factorsNr += 2;
            }
            i++;
        }

        if (i * i == N) {
            ++factorsNr;
        }

        return factorsNr;
    }

    /**
     * 100% correctness and performance
     * Here we calculate beforehand the square root,
     * instead of multiplying i * i in the first solution
     */
    public int optimizedSolution(int N)
    {
        int factorsNr = 0;
        int i = 1;
        int sqrN = (int) Math.sqrt(N);

        while (i <= sqrN) {
            if (N % i == 0) {
                factorsNr += 2;
            }
            i++;
        }

        if (sqrN * sqrN == N) {
            factorsNr--;
        }

        return factorsNr;
    }
}
