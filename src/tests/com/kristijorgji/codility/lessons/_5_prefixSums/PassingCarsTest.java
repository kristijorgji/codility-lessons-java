package com.kristijorgji.codility.lessons._5_prefixSums;

import com.kristijorgji.codility.lessons._6_sorting.Distinct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassingCarsTest {
    private PassingCars subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new PassingCars();
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
                                0, 1, 0, 1, 1
                        },
                        5
                ),
                Arguments.of(
                        new int[] { 1 },
                        0
                ),
                Arguments.of(
                        new int[] {},
                        0
                )
        );
    }
}
