package com.practice.arrays.week1;

/*
Given an unsorted array of non negative integers, find a continuous subarray which adds to a given number.
Examples :

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Output: Sum found between indexes 1 and 4
Sum of elements between indices
1 and 4 is 4 + 0 + 0 + 3 = 7

Input: arr[] = {1, 4}, sum = 0
Output: No sub array found
There is no sub array with 0 sum
 */

public class FindSumInArray {
    public static void main(String[] args) {
        // input
        int[] input = {1, 4, 0, 0, 3, 10, 5};
        int sum = 7;

        int start = 0;
        int end = 0;
        int temp = 0;
        boolean found = false;
        for (int i = 0; i < input.length; i++){
            end = i;
            temp = temp + input[i];
            while (temp > sum && start < i){
                temp = temp - input[start];
                start++;
            }
            if(temp == sum){
                found = true;
                break;
            }
        }
        if (found){
            System.out.println("Sum found between indexes " + start + " and " + end);
        }else{
            System.out.println("No sub array found");
        }
    }
}
