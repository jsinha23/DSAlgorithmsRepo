package com.practice.arrays.week1;

import java.util.Arrays;

// space O(n), time O(n log n)
public class MergeSort {
    public static void main(String[] args) {
        int[] input = { 12, 11, 13, 5, 6, 7 };
        sort(input,0,input.length - 1);
        System.out.println("sorted array: " + Arrays.toString(input));
    }

    private static void sort(int[] input, int min, int max) {
        if(min < max){
            int median = (min + max)/2;
            sort(input, min, median);
            sort(input, median + 1, max);
            merge(input, min, median, max);
        }
    }

    private static void merge(int[] input, int min, int median, int max) {
        int n1 = median - min + 1;
        int n2 = max - median;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = input[min + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = input[median + 1 + j];
        }
        int i = 0, j = 0;
        int k = min;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            }else {
                input[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            input[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            input[k] = right[j];
            j++;
            k++;
        }
    }
}
