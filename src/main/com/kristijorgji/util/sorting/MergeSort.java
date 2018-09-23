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

//    private int[] sort(int[] A, int start, int end)
//    {
//        final int length = (end - start);
//        final int middle = end / 2 + start;
//
//        if (length == 1) {
//            return new int[] {A[0]};
//        }
//
//        int[] mergedLeft = sort(A, start, middle);
//        int[] mergedRight = sort(A, middle, end);
//
//        int[] result =  new int[mergedLeft.length + mergedRight.length];
//
//        int i = 0;
//        int li = 0;
//        int ri = 0;
//
//        for (; i < mergedLeft.length; i++) {
//            if (mergedLeft[i] < mergedRight[i]) {
//                result[i] = mergedLeft[li++];
//            } else {
//                result[i] = mergedRight[ri++];
//            }
//        }
//
//        for (; li < mergedLeft.length; li++) {
//            result[i++] = mergedLeft[li];
//        }
//
//        for (; ri < mergedRight.length; ri++) {
//            result[i++] = mergedRight[ri];
//        }
//
//        return result;
//    }
}
