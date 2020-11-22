package com.practice.arrays.week1;

import java.util.Arrays;
import java.util.HashMap;

public class SortMinSwaps {

	public static void main(String args[]) {
		int arr[] = { 101, 758, 315, 730, 472, 619, 460, 479 };
		int n = arr.length;
		int count = 0;
		int[] tempArray = Arrays.copyOfRange(arr, 0, n);
		Arrays.sort(tempArray);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], i);
		}
		for (int i = 0; i < n; i++) {

			if (arr[i] != tempArray[i]) {
				count++;
				int init = arr[i];
				swap(arr, i, map.get(tempArray[i]));
				map.put(init, map.get(tempArray[i]));
				map.put(tempArray[i], i);
			}
		}
		System.out.println(count);

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
