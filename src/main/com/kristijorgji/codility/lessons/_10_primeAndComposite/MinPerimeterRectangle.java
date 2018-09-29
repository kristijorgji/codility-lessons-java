package com.kristijorgji.codility.lessons._10_primeAndComposite;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/">MinPerimeterRectangle</a>
 *
 * An integer N is given, representing the area of some rectangle.
 *
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
 *
 * The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.
 *
 * For example, given integer N = 30, rectangles of area 30 are:
 *
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 *
 * For example, given an integer N = 30, the function should return 22, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000,000].
 */
public class MinPerimeterRectangle {
    /**
     * 100% solution
     * We have to iterate only up to the square root of N,
     * this because of the symmetric divisors.
     * If we are at i = 2, we find the other side being 10 / 2 = 5.
     * This means that is not necessary for us to do the same calculation for i = 5.
     * By iterating until sqrt(N), we find all the possible distinct pairs of sides.
     */
    public int solution(int N)
    {
        int sqrtN = (int) Math.sqrt(N);
        int minSumOfSides = Integer.MAX_VALUE;
        int i = 1;

        while (i <= sqrtN) {
            if (N % i == 0) { //make sure the side is integer as the problem description requires
                int otherSide = N / i;
                minSumOfSides = Math.min(minSumOfSides, i + otherSide);
            }
            i++;
        }

        return 2 * minSumOfSides;
    }

    /**
     * http://codility-lessons.blogspot.com/2015/03/lesson-8-minperimeterrectangle.html
     *
     * If we start from the sqrt(N) until 1, by decrementing always with 1 is way faster.
     * The proof is given below.*
     * We assume 1 <= x < y <= sqrt(N), both x and y are integers.
     * We want to know is if the following is true:
     *  2 * (y + N / y) < 2 * (x + N / x)
     * (y + N / y) < (x + N / x)
     * (y + N / y) - (x + N / x) < 0
     * (y - x) + (N / y - N / x) < 0
     * (y - x) < -(N / y - N / x)
     * (y - x) < -N / y + N / x
     * (y - x) < N / x - N / y
     * (y - x) < (Ny - Nx) / xy
     * (y - x) < N(y - x) / xy
     * 1 < N / xy
     * Since 1 <= x < y <= sqrt(N), 0 < xy < N. (even when y is equal to sqrt(N), x is smaller, so xy is always less than sqrt(N) * sort(N) = N.)
     * This means, if N is larger, the perimeter can be minimized when Y is the largest possible value that is less than or equal to sqrt(N)
     *
     *
     */
    public int optimizedSolution(int N)
    {
        int i = (int) Math.sqrt(N);

        while (i >= 1) {
            if (N % i == 0) {
                break;
            }
            i--;
        }

        return 2 * (N / i + i);
    }
}
