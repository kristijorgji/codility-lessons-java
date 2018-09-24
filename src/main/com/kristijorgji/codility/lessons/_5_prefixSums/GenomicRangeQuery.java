package com.kristijorgji.codility.lessons._5_prefixSums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/">Genomic range query</a>
 *
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence.
 * Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
 * You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 *
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
 * There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
 * The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 *
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 *
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 *
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 *
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers,
 * returns an array consisting of M integers specifying the consecutive answers to all queries.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */
public class GenomicRangeQuery {
    private static final Map<Character, Integer> DNA_MAP = createMap();
    private static Map<Character, Integer> createMap() {
        Map<Character, Integer> result = new HashMap<>();
        result.put('A', 1);
        result.put('C', 2);
        result.put('G', 3);
        result.put('T', 4);
        result = Collections.unmodifiableMap(result);
        return result;
    }

    public int[] solution(String S, int[] P, int[] Q)
    {
        final int M = P.length;
        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = P[i];  j <= Q[i]; j++) {
                final int nucleotidImpact = DNA_MAP.get(S.charAt(j));
                if (min > nucleotidImpact) {
                    min = nucleotidImpact;
                }
            }

            result[i] = min;
        }

        return result;
    }

    /**
     * 100% score solution
     */
    public int[] optimizedSolution(String S, int[] P, int[] Q)
    {
        final int M = P.length;
        final int N = S.length();

        int[][] genomes = new int[3][N+1];

        byte a, c, g;

        for (int i = 0; i < N; i++){
            a = 0;
            c = 0;
            g = 0;

            if (S.charAt(i) == 'A') {
                a = 1;
            }

            if (S.charAt(i) == 'C') {
                c = 1;
            }

            if (S.charAt(i) == 'G') {
                g = 1;
            }

            genomes[0][i+1] = genomes[0][i] + a;
            genomes[1][i+1] = genomes[1][i] + c;
            genomes[2][i+1] = genomes[2][i] + g;
        }

        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int startIndex = P[i];
            int endIndex = Q[i] + 1;

            if (genomes[0][endIndex] - genomes[0][startIndex] > 0) {
                result[i] = 1;
            } else if (genomes[1][endIndex] - genomes[1][startIndex] > 0) {
                result[i] = 2;
            } else if (genomes[2][endIndex] - genomes[2][startIndex] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }
}