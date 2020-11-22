package com.practice.arrays.week1;

import java.util.Arrays;
/*
 * Given an array of n integers, divide it into k segments and find the maximum of the minimums of k segments. Output the maximum integer that can be obtained among all ways to segment in k subarrays.
 */
//Time Complexity:O(n)
public class ArraykSegments {

	public static int maxofSegs(int[] arr, int k, int n) {
		if (k == 2) {
			return Math.max(arr[0], arr[n - 1]);
		} else if (k == 1) {
			Arrays.sort(arr);
			return arr[0];

		} else {

			return arr[n - 1];
		}

	}

	public static void main(String args[]) {
		int[] a = { -10, -9, -8, 2, 7, -6, -5 };
		int n = a.length;
		int k = 2;

		System.out.println(maxofSegs(a, k, n));
	}
}
