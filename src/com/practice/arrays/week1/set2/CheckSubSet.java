package com.practice.arrays.week1.set2;

import java.util.Arrays;
import java.util.HashMap;

public class CheckSubSet {
    public static void main(String[] args) {
        int[] input1 = {11, 1, 2, 13, 21, 3, 7};
        int[] input2 = {21, 3, 7, 2};

        method1(input1, input2);

        int[] input3 = {11, 1, 2, 13, 21, 3, 7};
        int[] input4 = {21, 3, 7, 2};

        if (isSubset(input3, input3.length, input4, input4.length)) {
            System.out.println("Input4 is a subset of Input3");
        }else {
            System.out.println("Input4 is not a subset of Input3");
        }
    }

    static boolean isSubset(int[] arr1, int m,int[] arr2, int n){
        HashMap<Integer,Integer> frequency = new HashMap<>();

        for(int i = 0; i < m; i++){
            frequency.put(arr1[i],frequency.getOrDefault(arr1[i], 0) + 1);
        }
        for(int i = 0; i < n; i++){
            if (frequency.getOrDefault(arr2[i], 0) > 0) {
                frequency.put(arr2[i], frequency.get(arr1[i]) - 1);
            }else{
                return false;
            }
        }
        return true;
    }

    private static void method1(int[] input1, int[] input2) {
        Arrays.sort(input1);
        Arrays.sort(input2);
        int i = 0,j = 0;
        while (i < input2.length && j < input1.length) {
            if (input1[j] < input2[i]) {
                j++;
            }else if (input1[j] == input2[i]) {
                j++;
                i++;
            } else if (input1[j] > input2[i]) {
                break;
            }
        }

        if (i < input2.length){
            System.out.println("Input2 is not a subSet of Input1");
        }else{
            System.out.println("Input2 is a subSet of Input1");
        }
    }
}
