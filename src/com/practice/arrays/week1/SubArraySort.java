package com.practice.arrays.week1;

/* find the minimum length subarray arr[s..e] such that sorting this subarray makes the whole array sorted
ex: If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be able to find that the subarray lies between the indexes 3 and 8*/

//Time Complexity: O(n ) 


public class SubArraySort {

	public static void printUnsorted(int arr[], int n) {

		int start = 0, end = n - 1, i, max, min;

		for (start = 0; start < n - 1; start++) {
			if (arr[start] > arr[start + 1])
				break;
		}
		if (start == n - 1) {
			System.out.println("Already sorted");
			return;
		}

		for (end = n - 1; end > 0; end--) {
			if (arr[end] < arr[end - 1])
				break;
		}

		max = arr[start];
		min = arr[start];
		for (i = start + 1; i <= end; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}

		for (i = 0; i < start; i++) {
			if (arr[i] > min) {
				start = i;
				break;
			}
		}

		for (i = n - 1; i >= end + 1; i--) {
			if (arr[i] < max) {
				end = i;
				break;
			}
		}

		System.out.println(" The unsorted subarray which" + " makes the given array sorted lies"
				+ "  between the indices " + start + " and " + end);

	}

	public static void main(String args[]) {
		int arr[] = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		int arr_size = arr.length;
		printUnsorted(arr, arr_size);
	}
}
