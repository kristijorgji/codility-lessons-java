package com.kristijorgji.codility.lessons._9_maxSliceProblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxDoubleSliceSumTest {
    private MaxDoubleSliceSum subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new MaxDoubleSliceSum();
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
                        new int[]{
                                3, 2, 6, -1 , 4, 5, -1, 2
                        },
                        17
                ),
                Arguments.of(
                        new int[]{
                                1, 2, 3
                        },
                        0
                ),
                Arguments.of(
                        new int[]{
                                1, 3, 7, 9
                        },
                        7
                ),
                Arguments.of(
                        new int[]{
                                6, 1, 5, 6, 4, 2, 9, 4
                        },
                        26
                ),
                Arguments.of(
                        new int[]{
                                0, 10, -5, -2, 0
                        },
                        10
                )
        );
    }
}
