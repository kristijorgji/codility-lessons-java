package com.kristijorgji.codility.lessons._5_prefixSums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GenomicRangeQueryTest {

    private GenomicRangeQuery genomicRangeQueryUnderTest;

    @BeforeEach
    public void setUp() {
        genomicRangeQueryUnderTest = new GenomicRangeQuery();
    }

    @ParameterizedTest(name = "\"{0}\" should give result {3}")
    @MethodSource("dataProvider")
    public void testSolution(final String S, final int[] P, final int[] Q, final int[] expectedSolution) {
        final int[] result = genomicRangeQueryUnderTest.solution(S, P, Q);
        assertArrayEquals(expectedSolution, result);
    }

    @ParameterizedTest(name = "\"{0}\" should give result {3}")
    @MethodSource("dataProvider")
    public void testOptimizedSolution(final String S, final int[] P, final int[] Q, final int[] expectedSolution) {
        final int[] result = genomicRangeQueryUnderTest.optimizedSolution(S, P, Q);
        assertArrayEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        "CAGCCTA",
                        new int[]{ 2, 5, 0 },
                        new int[]{ 4, 5, 6 },
                        new int[]{ 2, 4, 1 }
                )
        );
    }
}
