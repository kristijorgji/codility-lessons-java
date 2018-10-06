package com.kristijorgji.codility.lessons._14_binarySearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxDivisionTest {
    private MinMaxDivision subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new MinMaxDivision();
    }

//    @ParameterizedTest
//    @MethodSource("dataProvider")
//    public void testSolution(int K, int M, int[] A,  int expectedSolution) {
//        final int result = subjectUnderTest.solution(K, M, A);
//        assertEquals(expectedSolution, result);
//    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testOptimizedSolution(int K, int M, int[] A,  int expectedSolution) {
        final int result = subjectUnderTest.optimizedSolution(K, M, A);
        assertEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        3,
                        5,
                        new int[]{
                                2, 1, 5, 1, 2, 2, 2
                        },
                        6
                ),
                Arguments.of(
                        2,
                        5,
                        new int[]{
                                3, 5
                        },
                        5
                ),
                Arguments.of(
                        3,
                        6,
                        new int[]{
                                5, 2, 3, 4, 6
                        },
                        7
                )
        );
    }
}
