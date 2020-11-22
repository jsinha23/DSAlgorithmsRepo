package com.practice.arrays.week1;

/*
Input : 1 3 5
        2 6 9
        3 6 9
Output : Median is 5
If we put all the values in a sorted
array A[] = 1 2 3 3 5 6 6 9 9)

Input: 1 3 4
       2 5 6
       7 8 9
Output: Median is 5
 */

import java.util.Arrays;

public class FindMedianInSortedArray {
    public static void main(String[] args) {
        int row = 3, column = 3;
        int[][] input= { {1,3,5}, {2,6,9}, {3,6,9} };

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++){
            if(input[i][0] < min){
                min = input[i][0];
            }
            if(input[0][column - 1] > max) {
                max = input[0][column - 1];
            }
        }

        int midIndex = (1+(row*column)/2);

        while(min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get;
            for(int i = 0; i < row; ++i){
                get = Arrays.binarySearch(input[i],mid);
                if(get < 0) {
                    get = Math.abs(get) - 1;
                }else {
                    while(get < input[i].length && input[i][get] == mid){
                        get += 1;
                    }
                }
                place = place + get;
            }
            if (place < midIndex) {
                min = mid + 1;
            }else {
                max = mid;
            }
        }
        System.out.println("Median: " + min);
    }
}
