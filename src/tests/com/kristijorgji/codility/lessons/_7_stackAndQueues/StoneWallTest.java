package com.kristijorgji.codility.lessons._7_stackAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoneWallTest {
    private StoneWall subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new StoneWall();
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
                                8, 8, 5,
                                7, 9, 8,
                                7, 4, 8
                        },
                        7
                )
        );
    }
}
