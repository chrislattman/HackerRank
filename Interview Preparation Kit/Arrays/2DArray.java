// https://www.hackerrank.com/challenges/2d-array/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 16; i++) {
            int first = arr[i / 4][i % 4];
            int second = arr[i / 4][(i % 4) + 1];
            int third = arr[i / 4][(i % 4) + 2];
            int fourth = arr[(i / 4) + 1][(i % 4) + 1];
            int fifth = arr[(i / 4) + 2][i % 4];
            int sixth = arr[(i / 4) + 2][(i % 4) + 1];
            int seventh = arr[(i / 4) + 2][(i % 4) + 2];

            int sum = first + second + third + fourth + fifth + sixth + seventh;
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
