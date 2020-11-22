// https://www.hackerrank.com/challenges/minimum-swaps-2/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int index = 0;
        int current_value = 1;
        
        while (current_value < arr.length) {
            int arr_value = arr[index];
            while (arr_value != current_value) {
                index++;
                arr_value = arr[index];
            }
            if (arr_value != index + 1) {
                arr[index] = arr[arr_value - 1];
                arr[arr_value - 1] = arr_value;
                swaps++;
            }
            current_value++;
            index = arr_value;
        }
        
        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
