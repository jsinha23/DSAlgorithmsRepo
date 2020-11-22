package com.practice.arrays.week1;

/*search, insert and delete operation in a sorted array*/
//Time Complexity:O(n)-insert delete,search  O(log n)
public class CrudOperationsArrays {
	public static void main(String args[]) {
		int arr[] = new int[20];
		arr[0] = 10;
		arr[1] = 16;
		arr[2] = 20;
		arr[3] = 30;
		arr[4] = 50;
		arr[5] = 70;

		int n = 6;
		int key = 30;

		System.out.println(binarySearch(arr, 0, n, key));
		insert(arr, 80,n);
		
		delete(arr, 10,n+1);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i]+" ");
	}

	public static void insert(int arr[], int key,int n) {
		int i;
		for (i = n-1; (i >= 0 && arr[i] > key); i--)
			arr[i + 1] = arr[i];
		arr[i + 1] = key;

	}

	public static void delete(int arr[], int key,int n) {
		int pos = binarySearch(arr, 0, n, key);

		if (pos == -1) {
			System.out.println("Element not found");

		}
		for (int i = pos; i < n- 1; i++)
			arr[i] = arr[i + 1];

	}

	public static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;

		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}
}
