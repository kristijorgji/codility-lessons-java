package com.kristijorgji.codility.lessons._7_stackAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestingTest {
    private Nesting subjectUnderTest;

    @BeforeEach
    public void setUp() {
        subjectUnderTest = new Nesting();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolution(String S, int expectedSolution) {
        final int result = subjectUnderTest.solution(S);
        assertEquals(expectedSolution, result);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSolutionWithoutStack(String S, int expectedSolution) {
        final int result = subjectUnderTest.solutionWithoutStack(S);
        assertEquals(expectedSolution, result);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        "(()(())())",
                        1
                ),
                Arguments.of(
                        "",
                        1
                ),
                Arguments.of(
                        "())",
                        0
                ),
                Arguments.of(
                        "(((",
                        0
                ),
                Arguments.of(
                        ")))(((",
                        0
                ),
                Arguments.of(
                        ")(",
                        0
                )
        );
    }
}
