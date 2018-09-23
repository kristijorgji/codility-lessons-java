package com.kristijorgji.codility.lessons._7_stackAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishTest {
    private Fish subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new Fish();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolution(final int[] A, final int[] B, final int expectedSolution) {
        final int result = subjectUnderTest.solution(A, B);
        assertEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] {
                                4, 3, 2, 1, 5
                        },
                        new int[] {
                                0, 1, 0, 0, 0
                        },
                        2
                ),
                Arguments.of(
                        new int[] {
                                4, 3, 2, 1, 5
                        },
                        new int[] {
                                1, 1, 1, 1, 1
                        },
                        5
                ),
                Arguments.of(
                        new int[] {
                                4, 3, 2, 1, 5
                        },
                        new int[] {
                                0, 0, 0, 0, 0
                        },
                        5
                ),
                Arguments.of(
                        new int[] {
                                4, 3, 2, 1, 5
                        },
                        new int[] {
                                1, 0, 0, 0, 0
                        },
                        1
                ),
                Arguments.of(
                        new int[] {
                                4
                        },
                        new int[] {
                                1
                        },
                        1
                ),
                Arguments.of(
                        new int[] {
                                4, 3, 2, 1, 5, 7, 9, 11, 60, 20
                        },
                        new int[] {
                                0, 1, 0, 0, 1, 0, 0, 1, 0, 1
                        },
                        5
                )
        );
    }
}
