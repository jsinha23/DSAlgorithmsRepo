package com.practice.arrays.week1;

import java.util.Arrays;

/*Pairs with Difference less than K
  Input : a[] = {1, 10, 4, 2}
        K = 3
  Output : 2
  We can make only two pairs 
  with difference less than 3.
  (1, 2) and (4, 2)

 */
//Time Complexity: O(nlogn)
public class CountPairsDifference {

	public static int countPairs(int[] arr, int n, int k) {

		int leftPointer = 0, rightPointer = 0, count = 0;
		Arrays.sort(arr);
		while (rightPointer < n) {
			if (arr[rightPointer] - arr[leftPointer] == k) {
				count++;
				rightPointer++;
				leftPointer++;
			} else if (arr[rightPointer] - arr[leftPointer] < k) {
				rightPointer++;
			} else
				leftPointer++;

		}

		return count;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 5, 3, 4, 2 };
		int n = arr.length;
		int k = 3;
		System.out.println("Count of pairs with given diff is " + countPairs(arr, n, k));

	}
}
