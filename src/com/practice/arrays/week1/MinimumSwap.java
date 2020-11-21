package com.practice.arrays.week1;

/*
Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.

Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
Output: 1

Explanation:
To bring elements 2, 1, 3 together, swap
element '5' with '3' such that final array
will be-
arr[] = {2, 1, 3, 6, 5}
 */


import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MinimumSwap {
    public static void main(String[] args){

        // constraints: array will contain only +ve integer

        // input 1
        int[] input1 = {2,1,5,6,3};
        int k1 = 3;
        System.out.println("No of swap required: " + minSwap(input1,k1));

        // input 2
        int[] input2 = {2, 7, 9, 5, 8, 7, 4};
        int k2 = 5;
        System.out.println("No of swap required: " + minSwap(input2,k2));
    }

    private static int minSwap(int[] input, int k){
        // get the count of values less than or equal to k
        int inRange = (int) IntStream.range(0,input.length)
                .filter(i -> input[i] <= k)
                .count();

        // get the count of values which are greater than k of input length found above
        int outRange = (int) IntStream.range(0, inRange)
                .filter(i -> input[i] > k)
                .count();

        int result = outRange;
        for (int i = 0, j = inRange; j < input.length; ++i, ++j) {
            // decrement if swap is required
            if (input[i] > k) {
                --outRange;
            }
            // increment if swap is not needed
            if (input[j] > k) {
                ++outRange;
            }
            result = Math.min(result, outRange);
        }
        return result;
    }
}
