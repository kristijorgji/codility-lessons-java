package com.kristijorgji.codility.lessons._5_prefixSums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/">Genomic range query</a>
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