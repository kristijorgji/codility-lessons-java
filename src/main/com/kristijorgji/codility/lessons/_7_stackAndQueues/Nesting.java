package com.kristijorgji.codility.lessons._7_stackAndQueues;

import java.util.Stack;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/">Nesting</a>
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
