package com.kristijorgji.codility.lessons._7_stackAndQueues;

import java.util.Stack;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/">Nesting</a>
 *
 * A string S consisting of N characters is called properly nested if:
 *
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 *
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 */
public class Nesting {
    public int solution(String S)
    {
        final int length = S.length();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (s.isEmpty()) {
                s.push(c);
            } else {
                if (c == ')') {
                    s.pop();
                } else {
                    s.push('(');
                }
            }
        }

        return s.isEmpty() ? 1 : 0;
    }

    public int solutionWithoutStack(String S)
    {
        final int length = S.length();
        int counter = 0;

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);

            if (c == '(') {
                counter++;
            } else {
                counter--;
                //in the scenario when we have )))(((, or )( etc
                if (counter < 0) {
                    return 0;
                }
            }
        }

        return counter == 0 ? 1 : 0;
    }
}
