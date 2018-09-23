package com.kristijorgji.codility.lessons._8_leader;

import java.util.HashMap;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/8-leader/dominator/">Dominator</a>
 */
public class Dominator {
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

