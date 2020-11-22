// https://www.hackerrank.com/contests/hourrank-28/challenges/xorry-queries

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the xorQueries function below.
    static long[] xorQueries(int[] a, int m, int p) {
        // Return an array consisting of the answers of all type-2 queries.
        long[] result = new long[100000];
        int r_index = 0;
        for (int i = 0; i < m; i++) {
            int type = scanner.nextInt();
            int iorl = scanner.nextInt();
            int xorr = scanner.nextInt();
            if (type == 1) {
                a[iorl - 1] ^= xorr;
            }
            else {
                for (int j = iorl - 1; j < xorr - 1; j++) {
                    long curr = a[j];
                    for (int k = j + 1; k < j + p; k++) {
                        if (k < a.length) {
                            curr ^= a[k];
                        }
                        else {
                            curr ^= 0;
                        }
                    }
                    result[r_index] += curr;
                }
                r_index++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmp = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmp[0]);

        int m = Integer.parseInt(nmp[1]);

        int p = Integer.parseInt(nmp[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        long[] result = xorQueries(a, m, p);

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                bufferedWriter.write(String.valueOf(result[i]));
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.close();

        scanner.close();
    }
}
