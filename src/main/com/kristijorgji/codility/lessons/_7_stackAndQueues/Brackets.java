package com.kristijorgji.codility.lessons._7_stackAndQueues;

import java.util.Stack;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/">Brackets</a>
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
