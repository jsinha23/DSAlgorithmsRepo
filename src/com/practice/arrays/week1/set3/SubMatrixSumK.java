package com.practice.arrays.week1.set3;

import java.util.Arrays;

//Time Complexity: O(n^3).
//Auxiliary Space: O(n).
public class SubMatrixSumK {
    static int subCount(int[] arr, int n, int k) {
        // create auxiliary hash array to
        // count frequency of remainders
        int[] temp = new int[k];
        // Traverse original array and compute cumulative
        // sum take remainder of this current cumulative
        // sum and increase count by 1 for this remainder
        // in temp[] array
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];

            // as the sum can be negative,
            // taking modulo twice
            temp[((cumSum % k) + k) % k]++;
        }

        // Initialize result
        int result = 0;

        // Traverse temp[]
        for (int i = 0; i < k; i++) {

            // If there are more than one prefix subarrays
            // with a particular temp value.
            if (temp[i] > 1)
                result += (temp[i] * (temp[i] - 1)) / 2;
        }
        // add the subarrays starting from the arr[i]
        // which are divisible by k itself
        result += temp[0];

        return result;
    }

    // function to count all sub-matrices
// having sum divisible by the value 'k'
    static int countSubmatrix(int[][] input, int n, int k) {
        // Variable to store the final output
        int tot_count = 0;

        int left, right, i;
        int[] temp = new int[n];

        // Set the left column
        for (left = 0; left < n; left++) {

            // Initialize all elements of temp as 0
            Arrays.fill(temp, 0);

            // Set the right column for the left column
            // set by outer loop
            for (right = left; right < n; right++) {

                // Calculate sum between current left
                // and right for every row 'i'
                for (i = 0; i < n; ++i)
                    temp[i] += input[i][right];

                // Count number of subarrays in temp[]
                // having sum divisible by 'k' and then
                // add it to 'tot_count'
                tot_count += subCount(temp, n, k);
            }
        }
        return tot_count;
    }

    public static void main(String[] args)
    {
        int[][] input = {{5, -1, 6},
                {-2, 3, 8},
                {7, 4, -9}};
        int n = 3, k = 4;
        System.out.print("Count = " + countSubmatrix(input, n, k));
    }
}
