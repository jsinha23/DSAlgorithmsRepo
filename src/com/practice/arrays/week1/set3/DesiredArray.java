package com.practice.arrays.week1.set3;

public class DesiredArray {
    public static void main(String[] args) {
        int[] input = {2,3};
        System.out.println("Minimum number of steps required to get the given target array is: " + getToTargetArray(input));
    }

    private static int getToTargetArray(int[] input) {
        int result = 0;
        while (true) {
            int zero_count = 0;
            int i;
            for (i = 0; i < input.length; i++) {
                if (input[i] % 2 == 1) {
                    break;
                } else if (input[i] == 0)
                    zero_count++;
            }

            if (zero_count == input.length){
                return result;
            }
            if (i == input.length) {
                for (int j=0; j<input.length; j++) {
                    input[j] = input[j] / 2;
                }
                result++;
            }
            for (int j=i; j<input.length; j++) {
                if (input[j] %2 == 1) {
                    input[j]--;
                    result++;
                }
            }
        }
    }
}
