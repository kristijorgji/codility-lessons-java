package com.kristijorgji.codility.lessons._7_stackAndQueues;

import java.util.Stack;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/">Stone wall</a>
 */
public class StoneWall {
    /**
     * 100% solution
     * Every time the new height is higher, put that height into the stack
     * Every time the new height is lower then the last one,  pop from stack until is equal, or lower
     * When we reach a lower height, increase the block count and push that current height to the stack
     */
    public int solution(int[] H)
    {
        Stack<Integer> s = new Stack<>();
        int blocksNr = 0;

        for (int i = 0; i < H.length; i++) {
            while (!s.isEmpty() && H[i] < s.peek()) {
                s.pop();
            }

            if (s.isEmpty()) {
                s.push(H[i]);
                blocksNr++;
            } else {
                int topBlockHeight = s.peek();

                if (H[i] == topBlockHeight) {
                    continue;
                } else if (H[i] > topBlockHeight) {
                    blocksNr++;
                    s.push(H[i]);
                }
            }
        }

        return blocksNr;
    }
}
