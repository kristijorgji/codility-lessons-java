package com.kristijorgji.codility.lessons._9_maxSliceProblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSliceSumTest {
    private MaxSliceSum subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new MaxSliceSum();
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
                                3, 2, -6, 4, 0
                        },
                        5
                ),
                Arguments.of(
                        new int[]{
                                10
                        },
                        10
                ),
                Arguments.of(
                        new int[]{
                                -1
                        },
                        -1
                ),
                Arguments.of(
                        new int[]{
                                3, 2, -6, 4, 0, 9, 7, -7, 40
                        },
                        53
                )
        );
    }
}
