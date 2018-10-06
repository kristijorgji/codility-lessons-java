package com.kristijorgji.util.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolution(final int[] A, final int[] expectedArray) {
        int[] t = MergeSort.sort(A);
        assertArrayEquals(expectedArray, t);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testInPlaceSolution(int[] A, final int[] expectedArray) {
        MergeSort.inPlaceSort(A, 0, A.length);
        assertArrayEquals(expectedArray, A);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] {
                                -3, 1, 2, -2, 5, 6
                        },
                        new int[] {
                                -3, -2, 1, 2, 5, 6
                        }
                ),
                Arguments.of(
                        new int[] {
                                1, 1, 1, 2, 1, 1
                        },
                        new int[] {
                                1, 1, 1, 1, 1,  2
                        }
                ),
                Arguments.of(
                        new int[] {
                                4, 2, 2, 5, 1, 5, 8
                        },
                        new int[] {
                                1, 2, 2, 4, 5, 5, 8
                        }
                ),
                Arguments.of(
                        new int[] {
                                -3
                        },
                        new int[] {
                                -3
                        }
                ),
                Arguments.of(
                        new int[] {},
                        new int[] {}
                ),
                Arguments.of(
                        new int[] {
                                -3, 1, 2, -2, 5
                        },
                        new int[] {
                                -3, -2, 1, 2, 5
                        }
                )
        );
    }
}
