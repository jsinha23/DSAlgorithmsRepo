package com.practice.arrays.week1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CURDArray {

    public static void main(String[] args) {
        int[] input = {1,4,3};

        // search array
        int search = 3;
        System.out.println("Data present in index: " + search(input,search));
        
        // add to array
        int add = 5;
        System.out.println("Data before adding: " + Arrays.toString(input));
        System.out.println("Data after adding: " + Arrays.toString(add(input,add)));

        // update an value in index
        int newValue = 10;
        int index = 1;
        System.out.println("Data before updating: " + Arrays.toString(input));
        update(input,newValue,index);
        System.out.println("Data after updating: " + Arrays.toString(input));

        // delete an value
        int deleteValue = 1;
        System.out.println("Data before deleting: " + Arrays.toString(input));
        System.out.println("Data after deleting: " + Arrays.toString(delete(input,deleteValue)));
    }

    private static int[] delete(int[] input, int deleteValue) {
        int position = search(input,deleteValue);
        for (int i = position; i< input.length - 1; i++) {
            input[i] = input[i + 1];
        }
        return Arrays.copyOf(input,input.length - 1);
    }

    private static void update(int[] input, int newValue, int index) {
        input[index] = newValue;
    }

    private static int[] add(int[] input, int add) {
        int[] result = Arrays.copyOf(input,input.length + 1);
        result[input.length] = add;
        return result;
    }

    private static int search(int[] input, int search) {
        for (int i = 0; i < input.length; i++){
            if (input[i] == search){
                return i;
            }
        }
        return -1;
    }
}
