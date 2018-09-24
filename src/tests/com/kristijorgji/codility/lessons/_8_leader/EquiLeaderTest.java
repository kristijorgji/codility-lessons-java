package com.kristijorgji.codility.lessons._8_leader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquiLeaderTest {
    private EquiLeader subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new EquiLeader();
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
                                4, 3, 4, 4, 4, 2
                        },
                        2
                )
        );
    }
}
