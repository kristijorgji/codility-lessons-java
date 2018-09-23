package com.kristijorgji.codility.lessons._8_leader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DominatorTest {
    private Dominator subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new Dominator();
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
                                3, 1, 3, 2, 3, -1, 3, 3
                        },
                        7
                ),
                Arguments.of(
                        new int[] {
                                1
                        },
                        0
                ),
                Arguments.of(
                        new int[] {},
                        -1
                ),
                Arguments.of(
                        new int[] {
                                1, 2, 3, 4, 5
                        },
                        -1
                ),
                Arguments.of(
                        new int[] {
                                1, 2, 2, 4, 5
                        },
                        -1
                )
        );
    }
}
