// https://www.hackerrank.com/challenges/candies/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[n - 1] = 1;
        long result = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                up[i] = up[i - 1] + 1;
            }
            else {
                up[i] = 1;
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            if (arr[j] > arr[j + 1]) {
                down[j] = down[j + 1] + 1;
            }
            else {
                down[j] = 1;
            }
        }
        for (int k = 0; k < n; k++) {
            result += (long) Math.max(up[k], down[k]);
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
