package com.practice.arrays.week1.set3;

//Time Complexity: O(Logn)
//Programming Paradigm: Divide & Conquer
public class FrequencyK {
    /* if x is present in arr[] then returns the
       index of FIRST occurrence of x in arr[0..n-1],
       otherwise returns -1 */
    static int first(int[] input, int low, int high, int x) {
        if(high >= low) {
            /*low + (high - low)/2;*/
            int mid = (low + high)/2;
            if( ( mid == 0 || x > input[mid-1]) && input[mid] == x)
                return mid;
            else if(x > input[mid])
                return first(input, (mid + 1), high, x);
            else
                return first(input, low, (mid -1), x);
        }
        return -1;
    }

    /* if x is present in arr[] then returns the
       index of LAST occurrence of x in arr[0..n-1],
       otherwise returns -1 */
    static int last(int[] input, int low, int high, int x, int n) {
        if(high >= low) {
            /*low + (high - low)/2;*/
            int mid = (low + high)/2;
            if( ( mid == n-1 || x < input[mid+1]) && input[mid] == x )
                return mid;
            else if(x < input[mid])
                return last(input, low, (mid -1), x, n);
            else
                return last(input, (mid + 1), high, x, n);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 3, 3, 3, 3};
        int x =  3;
        int i;
        int j;

        /* get the index of first occurrence of x */
        i = first(input, 0, input.length-1, x);

        /* If x doesn't exist in arr[] then return -1 */
        if(i == -1) {
            System.out.println(x+" occurs "+i+" times");
            return;
        }
      /* Else get the index of last occurrence of x.
         Note that we are only looking in the
         subarray after first occurrence */
        j = last(input, i, input.length-1, x, input.length);

        System.out.println(x+" occurs "+ (j-i+1) +" times");
    }
}
