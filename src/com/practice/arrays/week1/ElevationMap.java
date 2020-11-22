package com.practice.arrays.week1;
/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
*/
public class ElevationMap {

	public static int countUnitsOfWater(int[] arr, int n) {
		int res = 0;
		for (int i = 1; i < n - 1; i++) {
			int left = arr[i];
			for (int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}
			int right = arr[i];
			for (int j = i + 1; j < n; j++) {
				right = Math.max(right, arr[j]);
			}
			res += Math.min(left, right) - arr[i];
		}
		return res;
	}

	public static void main(String args[]) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;
		System.out.print(countUnitsOfWater(arr, n));

	}
}
