package com.practice.arrays.week1;

public class SplitArrayFromK {
	
	public static void main(String args[]) {
		int[] splitArray = { 12, 10, 5, 6, 52, 36 }; 
	    int n = splitArray.length; 
	    int k = 2; 
	    reverseArray(splitArray,0,n-1);
	    reverseArray(splitArray,0,n-k-1);
	    reverseArray(splitArray,n-k,n-1);
	    for(int i=0;i<n;i++)
	   System.out.println(splitArray[i]);
	}

	public static void reverseArray(int[] splitArray , int i ,int n) {
		while (i < n) { 
	        int temp = splitArray[i]; 
	        splitArray[i] = splitArray[n]; 
	        splitArray[n] = temp; 
	        i++; 
	        n--; 
	    } 
		
	}
}
