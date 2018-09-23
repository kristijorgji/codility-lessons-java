package com.kristijorgji.codility.lessons._7_stackAndQueues;

import java.util.Stack;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/">Fish</a>
 */
public class Fish {
    /**
     * 100% solution
     * Fishes meet each other when P < Q and B[P] = 1 and B[Q] = 0
     * If one  fish meet another one, one will always get eaten.
     * The trick is here that the fish that eats the other one,
     * is the one facing also the other ones of the left (P < Q)
     */
    public int solution(int[] A, int[] B)
    {
        final int N = A.length;
        int fishesAlive = N;
        Stack<Integer> downstreamFishesPositions = new Stack<>(); // direction 1

        for (int i = 0; i < N; i++) {
            if (B[i] == 0) {
                while (!downstreamFishesPositions.isEmpty()) {
                    fishesAlive--;
                    if (A[downstreamFishesPositions.peek()] < A[i]) {
                        downstreamFishesPositions.pop();
                    } else {
                        break;
                    }
                }
            } else {
                downstreamFishesPositions.push(i);
            }
        }

        return fishesAlive;
    }
}
