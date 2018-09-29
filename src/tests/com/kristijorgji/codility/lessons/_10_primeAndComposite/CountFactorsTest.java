package com.kristijorgji.codility.lessons._10_primeAndComposite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountFactorsTest {
    private CountFactors subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new CountFactors();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolution(int N, final int expectedSolution) {
        final int result = subjectUnderTest.solution(N);
        assertEquals(expectedSolution, result);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testOptimizedSolution(int N, final int expectedSolution) {
        final int result = subjectUnderTest.optimizedSolution(N);
        assertEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(24, 8),
                Arguments.of(16, 5),
                Arguments.of(1, 1),
                Arguments.of(15, 4)

        );
    }
}
