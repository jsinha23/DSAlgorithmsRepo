package com.practice.arrays.week1.set2;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int N = 4;

        int[][] input = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println("Before rotating 90 degree anti colockwise: " + Arrays.deepToString(input));
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = input[x][y];

                // Move values from right to top
                input[x][y] = input[y][N - 1 - x];

                // Move values from bottom to right
                input[y][N - 1 - x] = input[N - 1 - x][N - 1 - y];

                // Move values from left to bottom
                input[N - 1 - x][N - 1 - y] = input[N - 1 - y][x];

                // Assign temp to left
                input[N - 1 - y][x] = temp;
            }
        }

        System.out.println("After rotating 90 degree anti colockwise: " + Arrays.deepToString(input));
    }
}
