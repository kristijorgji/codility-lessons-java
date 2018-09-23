package com.kristijorgji.codility.lessons._6_sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfDiscIntersectionsTest {
    private NumberOfDiscIntersections subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new NumberOfDiscIntersections();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolution(final int[] A, final int expectedSolution) {
        final int result = subjectUnderTest.solution(A);
        assertEquals(expectedSolution, result);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testOptimizedSolution(final int[] A, final int expectedSolution) {
        final int result = subjectUnderTest.optimizedSolution(A);
        assertEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] {
                                1, 5, 2, 1, 4, 0
                        },
                        11
                ),
                Arguments.of(
                        new int[] {
                                0, 0, 0
                        },
                        0
                ),
                Arguments.of(
                        new int[] {
                                0, 1
                        },
                        1
                )
        );
    }
}
