package com.kristijorgji.codility.lessons._6_sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctTest {
    private Distinct subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new Distinct();
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
                                2, 1, 1, 2, 3, 1
                        },
                        3
                ),
                Arguments.of(
                        new int[] {
                                1
                        },
                        1
                ),
                Arguments.of(
                        new int[] {},
                        0
                )
        );
    }
}
