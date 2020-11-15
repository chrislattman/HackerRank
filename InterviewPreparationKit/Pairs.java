// https://www.hackerrank.com/challenges/pairs/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int binarysearch(int[] arr, int left, int right, int val) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == val) {
            return mid;
        }
        else if (arr[mid] > val) {
            return binarysearch(arr, left, mid - 1, val);
        }
        else {
            return binarysearch(arr, mid + 1, right, val);
        }
    }

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int result = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (binarysearch(arr, 0, arr.length - 1, arr[i] + k) >= 0) {
                result++;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
