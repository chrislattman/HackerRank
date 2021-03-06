// https://www.hackerrank.com/contests/101hack54/challenges/weather-forecast-quality

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the totalForecastInaccuracy function below.
    static int totalForecastInaccuracy(int[] t, int[] f) {
        // Return the sum of the weather forecast inaccuracies across all 7 days.
        int result = 0;
        for (int i = 0; i < t.length; i++) {
            result += Math.abs(t[i] - f[i]);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] t = new int[7];

        String[] tItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < 7; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr]);
            t[tItr] = tItem;
        }

        int[] f = new int[7];

        String[] fItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int fItr = 0; fItr < 7; fItr++) {
            int fItem = Integer.parseInt(fItems[fItr]);
            f[fItr] = fItem;
        }

        int result = totalForecastInaccuracy(t, f);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
