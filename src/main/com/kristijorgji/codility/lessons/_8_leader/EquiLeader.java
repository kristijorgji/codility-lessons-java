package com.kristijorgji.codility.lessons._8_leader;

/**
 * @see <a href="https://app.codility.com/programmers/lessons/8-leader/equi_leader/">EquiLeader</a>
 *
 * A non-empty array A consisting of N integers is given.
 *
 * The leader of this array is the value that occurs in more than half of the elements of A.
 *
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * we can find two equi leaders:
 *
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 *
 * For example, given:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */
public class EquiLeader {
    /**
     * 100% Correctness
     * 100% Performance
     *
     * The main idea here is that if an equi leader exists between the two slices,
     * that same leader is also the leader of the big slice composed of the smaller two.
     * An element is a leader if it occurs more then N/2 times in an array of length N.
     * If the left slice [0, i] has leader A, it means that the occurrences of A are > i/2
     * If the right slice [i+1, N-1] has leader B, it means that the occurrences of B are > (N - i) / 2
     * The equi leader definition is that, A = B in this case.
     * If we the occurrences of the leader in both sides, we get i/2 + (N-i)/2 = N/2
     * If the occurrences of the leader in the big slice > N/2, then => A=B is the leader of the big slice also
     *
     *
     * Knowing this, first we check if array A has a leader.
     * Then we compute the leader frequency in all indexes
     *
     * Then we iterate from 0 up to N-1, count how many times the equi leader predicate holds true.
     * {
     *     0 <= S <= N - 1
     *     leaderOf(0, S) = leaderOf(S+1, N-1)
     * }
     *
     */
    public int solution(int[] A)
    {
        final int N = A.length;
        int stackCounter = 0;
        int leaderCandidate = -1;

        for (int value : A) {
            if (stackCounter == 0) {
                leaderCandidate = value;
                stackCounter++;
            } else {
                if (value == leaderCandidate) {
                    stackCounter++;
                } else {
                    stackCounter--;
                }
            }
        }

        if (stackCounter == 0) {
            return 0; //we did not find any leader in the array A
        }

        int leaderCandidateFrequency = 0;
        //will store the count of leader occurrences from index 0 up to index i
        int[] leaderIndexToFrequencyMap = new int[N];

        for (int i = 0; i < N; i++) {
            if (A[i] == leaderCandidate) {
                leaderCandidateFrequency++;
            }
            leaderIndexToFrequencyMap[i] = leaderCandidateFrequency;
        }

        if (!(leaderCandidateFrequency > N / 2)) {
            return 0; //we did not find any leader in the entire Array
        }

        //so here we have a leader in array A, namely leaderCandidate
        int equiLeadersCount = 0;

        /*
            At this point leaderCandidateFrequency stores the number of total occurrences of the leader in array A,
            it is = leaderIndexToFrequencyMap[N-1]

            So, if we want to find the occurrence of the leader in another interval, we can use the prefix sums
            technique and make the difference of frequencies between the two points.

            leaderIndexToFrequencyMap[i] is the number of leader occurrences in the first half, from 0 up to i, including i
            leaderCandidateFrequency - leaderIndexToFrequencyMap[i] is the number of leader occurrences from i+1 up to N-1
         */
        for (int i = 0; i < N - 1; i++) {
            int leadersInSecondHalf = leaderCandidateFrequency - leaderIndexToFrequencyMap[i];
            if (leaderIndexToFrequencyMap[i] > (i + 1) / 2 && leadersInSecondHalf > (N - i - 1) / 2) {
                equiLeadersCount++;
            }
        }

        return equiLeadersCount;
    }

    /**
     * 100% correctness
     * 50% performance
     */
    public int slowSolution(int[] A)
    {
        final int length = A.length;
        int forwardLeaders[] = new int[length]; // stores the leader element from 0 up to index
        int reverseLeaders[] = new int[length]; // stores the leader element from N-1 up to index

        /*
            Finding leaders both forward direction and in reverse direction, for each index
            Reverse leaders array has index 0, for position N-1, and so on
            The last element is not necessary to be included, as the condition is S separates the two sequences
            One sequence can have only one leader, ex [0, B] can have only one leader value, or none
         */
        for (int i = 0; i < length - 1; i++) {
            forwardLeaders[i] = findLeader(A, 0, i);
            reverseLeaders[i] = findLeader(A, length - 1 - i, length  - 1);
        }

        int equiLeadersCount = 0;

        for (int i = 0; i < length - 1; i++) {
            //  0 <= S < N-1, S is included in first sequence A[0],...,A[S], A[S+1],...,A[N-1]
            // comparing fL[0] with rL[1], fL[2] with rL[3] and so on until fL[N-2] with rL[0]
            if (forwardLeaders[i] != Integer.MIN_VALUE
                    && forwardLeaders[i] == reverseLeaders[length - 2 - i]) {
                equiLeadersCount++;
            }
        }

        return equiLeadersCount;
    }

    private int findLeader(int[] v, int startIndex, int endIndex)
    {
        final int length = endIndex - startIndex + 1;
        int candidate = -1;
        int stackCounter = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            if (stackCounter == 0) {
                candidate = v[i];
                stackCounter++;
            } else {
                if (v[i] == candidate) {
                    stackCounter++;
                } else {
                    stackCounter--;
                }
            }
        }

        if (stackCounter == 0) {
            return Integer.MIN_VALUE;
        }

        int candidateFrequency = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (v[i] == candidate) {
                candidateFrequency++;
            }
        }

        if (candidateFrequency > length / 2) {
            return candidate;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
