package com.practice.arrays.week1.set2;

/* Find Two Missing Numbers in an array with O(n) time complexity and O(1) Extra Space*/

public class MissingNumbers {
	public static int sum(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static void main(String args[]) {

		int arr[] = { 1, 3, 5, 6 };
		int n = 2 + arr.length;
		int total = (n * (n + 1)) / 2 - sum(arr, n - 2);
		int avg = total / 2;
		int sumSmallerHalf = 0;
		for (int i = 0; i < n - 2; i++) {
			if (arr[i] <= avg)
				sumSmallerHalf += arr[i];

		}
		int first = (avg * (avg + 1)) / 2 - sumSmallerHalf;
		int second = total - first;
		System.out.println(first + " " + second);
	}
}
