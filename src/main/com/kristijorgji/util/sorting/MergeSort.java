package com.kristijorgji.util.sorting;

public class MergeSort
{
    public static int[] sort(int[] A)
    {
        final int length = A.length;
        final int middle = length / 2;

        if (length == 0) {
            return A;
        }

        if (length == 1) {
            return new int[] {A[0]};
        }

        int[] leftSlice = new int[middle];
        System.arraycopy(A, 0, leftSlice, 0, middle);

        int[] rightSlice = new  int[length - middle];
        System.arraycopy(A, middle, rightSlice, 0, length - middle);

        int[] mergedLeft = sort(leftSlice);
        int[] mergedRight = sort(rightSlice);

        int[] result =  new int[mergedLeft.length + mergedRight.length];

        int i = 0;
        int li = 0;
        int ri = 0;

        for (; li < mergedLeft.length && ri < mergedRight.length; i++) {
            if (mergedLeft[li] < mergedRight[ri]) {
                result[i] = mergedLeft[li++];
            } else {
                result[i] = mergedRight[ri++];
            }
        }

        for (; li < mergedLeft.length; li++) {
            result[i++] = mergedLeft[li];
        }

        for (; ri < mergedRight.length; ri++) {
            result[i++] = mergedRight[ri];
        }

        return result;
    }

    public static void inPlaceSort(int A[], int start, int end) {
        int length = end - start;
        int middle = length / 2 + start;

        if (length <= 1) {
            return;
        }

        inPlaceSort(A, start, middle);
        inPlaceSort(A, middle, end);

        int leftSize = middle - start;
        int rightSize = end - middle;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = start; i <  middle; i++) {
            left[i - start] = A[i];
        }
        for (int i = middle; i < end; i++) {
            right[i - middle] = A[i];
        }

        int k = start;
        int li = 0;
        int ri = 0;

        while (li < leftSize && ri < rightSize) {
            if (left[li] < right[ri]) {
                A[k] = left[li];
                li++;
            } else {
                A[k] = right[ri];
                ri++;
            }
            k++;
        }

        while (li < leftSize) {
            A[k] = left[li];
            li++;
            k++;
        }

        while (ri < rightSize) {
            A[k] = right[ri];
            ri++;
            k++;
        }
    }
}
