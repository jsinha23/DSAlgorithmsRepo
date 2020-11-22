package com.practice.arrays.week1;

/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers
which has the largest sum
Lets take the example:
    {-2, -3, "4, -1, -2, 1, 5", -3}
    above example quoted will get us max sum 7
 */

import java.util.stream.IntStream;

public class MaxSumSeqInArray {
    public static void main(String[] args) {
        // input
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};

        // sum each element in loop
        // if sum is less than 0, set sum = 0
        // if max < sum, then set max = sum

        int max = 0;
        int max_end = 0;
        for (int data : input) {
            max_end = max_end + data;
            if(max_end < 0){
                max_end = 0;
            }
            if(max < max_end){
                max = max_end;
            }
        }
        System.out.println("Max sum: " + max);
    }
}
