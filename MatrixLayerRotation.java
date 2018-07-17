// https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the matrixRotation function below.
    static void matrixRotation(int[][] matrix, int rotations) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = 0;
        if (rows > cols) {
            min = cols;
        }
        else {
            min = rows;
        }
        for (int r = 0; r < rotations; r++) {
            for (int i = 0; i < min / 2; i++) {
                rows = matrix.length - i;
                cols = matrix[0].length - i;
                int origin = matrix[matrix.length - rows][matrix[0].length - cols];
                for (int a = i; a < cols - 1; a++) {
                    matrix[i][a] = matrix[i][a + 1];
                }
                for (int b = i; b < rows - 1; b++) {
                    matrix[b][cols - 1] = matrix[b + 1][cols - 1];
                }
                for (int c = cols - 1; c > i; c--) {
                    matrix[rows - 1][c] = matrix[rows - 1][c - 1];
                }
                for (int d = rows - 1; d > i; d--) {
                    matrix[d][i] = matrix[d - 1][i];
                }
                matrix[i + 1][i] = origin;
            }
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mnr = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }
        matrixRotation(matrix, r);

        scanner.close();
    }
}
