package com.kristijorgji.codility.lessons._7_stackAndQueues;

import java.util.Stack;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/">Brackets</a>
 *
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
public class Brackets {
    public int solution(String S)
    {
        final int length = S.length();

        if (length == 0) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            char sTop = stack.peek();
            if ((c == '}' && sTop == '{')
                || (c == ')' && sTop == '(')
                || (c == ']' && sTop == '[')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.empty() ? 1 : 0;
    }
}
