package com.practice.arrays.week1;

import java.util.Arrays;

// space O(n log n), time O(n^2)
public class QuickSort {
    public static void main(String[] args) {
        int[] input = {10, 7, 8, 9, 1, 5};
        quickSort(input,0,input.length - 1);
        System.out.println("Quick sort: " + Arrays.toString(input));
    }

    private static void quickSort(int[] input, int min, int max) {
        if(min < max){
            int pivot = partition(input,min,max);
            quickSort(input,min,pivot - 1);
            quickSort(input,pivot + 1, max);
        }
    }

    private static int partition(int[] input, int min, int max) {
        int pivot = input[max];
        int i = (min-1);
        for (int j=min; j<max; j++) {
            if (input[j] < pivot) {
                i++;
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        int temp = input[i+1];
        input[i+1] = input[max];
        input[max] = temp;
        return i+1;
    }
}
