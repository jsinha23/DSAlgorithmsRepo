package com.practice.arrays.week1.set2;

import java.util.Arrays;
/*Merge two sorted arrays with O(1) extra space*/
// Time Complexity :O(m*n)
public class Merge2SortedArrays {

	public static void sortArrays(int[] arr1, int[] arr2, int m, int n) {
		for (int i = n - 1; i >= 0; i--) {

			int j, last = arr1[m - 1];
			for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--)
				arr1[j + 1] = arr1[j];
			if (j != m - 2 || last > arr2[i]) {
				arr1[j + 1] = arr2[i];
				arr2[i] = last;
			}
		}
	}

	public static void main(String args[]) {
		int ar1[] = { 1, 5, 9, 10, 15, 20 };
		int ar2[] = { 2, 3, 8, 13 };
		sortArrays(ar1, ar2, ar1.length, ar2.length);
		System.out.println("Sorted array1:"+Arrays.toString(ar1));
		System.out.println("Sorted array2:"+Arrays.toString(ar2));
		
	}
}
