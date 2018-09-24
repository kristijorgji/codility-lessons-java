package com.kristijorgji.codility.lessons._8_leader;

import java.util.HashMap;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/8-leader/dominator/">Dominator</a>
 *
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 *
 * For example, consider array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 *
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs.
 * The function should return −1 if array A does not have a dominator.
 *
 * For example, given array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
public class Dominator {
    /**
     * 100% solution, O(N) time complexity, O(1) space complexity
     * Check the lecture on Leader.pdf provided by Codility for the explanation
     * Basically, if we remove pairs of different elements, the leader in the sequence
     * will still be the same element
     */
    public int optimizedSolution(int[] A)
    {
        int candidate = -1;
        int position = -1;
        int stackCounter = 0;

        for (int i = 0; i < A.length; i++) {
            if (stackCounter == 0) {
                candidate = A[i];
                stackCounter++;
                position = i;
            } else {
                if (A[i] == candidate) {
                    stackCounter++;
                } else {
                    stackCounter--;
                }
            }
        }

        if (stackCounter == 0) {
            return -1;
        }

        int freq = 0;
        for (int value : A) {
            if (value == candidate) {
                ++freq;
                if (freq > A.length / 2) {
                    return position;
                }
            }
        }

        return -1;
    }

    /**
     * 100% score solution with O(N) time complexity
     * But I am not satisfied with space complexity being worst case O(N)
     * Will resolve later with O(N) time, and O(1) space complexity
     */
    public int solution(int[] A)
    {
        final int length = A.length;
        if (length == 0) {
            return -1;
        }

        FrequencyMap map = new FrequencyMap();

        for (int i = 0; i  < length; i++) {
            int val = A[i];
            map.addOrUpdate(val, i);
        }

        final int leaderCondition = length / 2;
        for (int val : A) {
            FrequencyMap.FrequencyTuple t = map.get(val);
            if (t.getFrequency() > leaderCondition) {
                return t.getLastFoundAt();
            }
        }

        return -1;
    }
}

class FrequencyMap {
    private HashMap<Integer, FrequencyTuple> map = new HashMap<>();

    void addOrUpdate(int value, int position) {
        if (!map.containsKey(value)) {
            map.put(value, new FrequencyTuple(1, position));
        } else {
            FrequencyTuple t = map.get(value);
            t.incrementFrequency();
            t.setLastFoundAt(position);
        }
    }

    FrequencyTuple get(int value)
    {
        return map.get(value);
    }

    class FrequencyTuple {
        private int frequency;
        private int lastFoundAt;

        FrequencyTuple(int frequency, int lastFoundAt) {
            this.frequency = frequency;
            this.lastFoundAt = lastFoundAt;
        }

        int getFrequency() {
            return frequency;
        }

        int getLastFoundAt() {
            return lastFoundAt;
        }

        private void incrementFrequency() {
            ++frequency;
        }

        private void setLastFoundAt(int position) {
            lastFoundAt = position;
        }
    }
}

