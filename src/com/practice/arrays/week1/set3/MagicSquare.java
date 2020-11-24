package com.practice.arrays.week1.set3;

/*
Input : n = 3
  2   7   6
  9   5   1
  4   3   8
Output : Magic matrix
Explanation:In matrix sum of each
row and each column and diagonals sum is
same = 15.
 */

public class MagicSquare {
    public static void main(String[] args) {
        int[][] input = {{ 2, 7, 6 },
                { 9, 5, 1 },
                { 4, 3, 8 }};
        boolean res = isMagicMatrix(input);
        if(res){
            System.out.println("Magic matrix");
        }else{
            System.out.println("Not a magic matrix");
        }
    }

    private static boolean isMagicMatrix(int[][] input) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < input.length; i++) {
            sum1 = sum1 + input[i][i];
            sum2 = sum2 + input[i][input.length - 1 -i];
        }
        if(sum1 != sum2){

            return false;
        }
        for (int i = 0; i < input.length; i++){
            int rowSum = 0;
            int columnSum = 0;
            int size = input.length;
            while (size > 0){
                rowSum = rowSum + input[i][size - 1];
                columnSum = columnSum + input[size - 1][i];
                size--;
            }
            if(rowSum != sum1 || columnSum != sum1){
                return false;
            }
        }
        return true;
    }
}