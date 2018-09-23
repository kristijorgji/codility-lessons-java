package com.kristijorgji.codility.lessons._6_sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProductOfThreeTest {
    private MaxProductOfThree subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new MaxProductOfThree();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolution(final int[] A, final int expectedSolution) {
        final int result = subjectUnderTest.solution(A);
        assertEquals(expectedSolution, result);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testImprovedSolution(final int[] A, final int expectedSolution) {
        final int result = subjectUnderTest.improvedSolution(A);
        assertEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] {
                                -3, 1, 2, -2, 5, 6
                        },
                        60
                ),
                Arguments.of(
                        new int[] {
                                -5, 5, -5, 4
                        },
                        125
                ),
                Arguments.of(
                        new int[] {
                                -10, -2, -4
                        },
                        -80
                )
        );
    }
}
