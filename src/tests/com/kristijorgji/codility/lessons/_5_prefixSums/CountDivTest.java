package com.kristijorgji.codility.lessons._5_prefixSums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDivTest {

    private CountDiv countDivUnderTest;

    @BeforeEach
    public void setUp() {
        countDivUnderTest = new CountDiv();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolution(int A, int B, int K, int expectedSolution) {
        final int result = countDivUnderTest.solution(A, B, K);
        assertEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        6,
                        11,
                        2,
                        3
                ),
                Arguments.of(
                        6,
                        12,
                        2,
                        4
                ),
                Arguments.of(
                        5,
                        12,
                        2,
                        4
                ),
                Arguments.of(
                        5,
                        11,
                        2,
                        3
                )
        );
    }
}
