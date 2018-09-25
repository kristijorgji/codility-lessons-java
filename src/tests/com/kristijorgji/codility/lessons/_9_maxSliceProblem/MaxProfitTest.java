package com.kristijorgji.codility.lessons._9_maxSliceProblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProfitTest {
    private MaxProfit subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new MaxProfit();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testOptimizedSolution(final int[] A, final int expectedSolution) {
        final int result = subjectUnderTest.optimizedSolution(A);
        assertEquals(expectedSolution, result);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolution(final int[] A, final int expectedSolution) {
        final int result = subjectUnderTest.solution(A);
        assertEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] {
                                23171, 21011, 21123, 21366, 21013, 21367
                        },
                        356
                ),
                Arguments.of(
                        new int[] {
                                10
                        },
                        0
                ),
                Arguments.of(
                        new int[] {},
                        0
                ),
                Arguments.of(
                        new int[] {
                                1, 7
                        },
                        6
                ),
                Arguments.of(
                        new int[] {
                                10, 20, 4, 2, 3, 30, 1
                        },
                        28
                )
        );
    }
}
