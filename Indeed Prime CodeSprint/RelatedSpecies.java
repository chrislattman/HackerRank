// https://www.hackerrank.com/contests/indeed-prime-codesprint/challenges/divyam-and-sorted-list

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            long[] c = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextLong();
            }
            for (int k = 0; k < n; k++) {
                b[k] = in.nextLong();
            }
            c[0] = Math.min(a[0], b[0]);
            for (int m = 1; m < n - 1; m++) {
                if (a[m] >= c[m - 1] && b[m] >= c[m - 1]) {
                    c[m] = Math.min(a[m], b[m]);
                }
                else if (a[m] >= c[m - 1]) {
                    c[m] = a[m];
                }
                else {
                    c[m] = b[m];
                }
            }
            c[n - 1] = Math.max(a[n - 1], b[n - 1]);
            boolean ordered = true;
            for (int p = 0; p < n - 1; p++) {
                if (c[p] > c[p + 1]) {
                    System.out.println("NO");
                    ordered = false;
                    break;
                }
            }
            if (ordered) {
                System.out.println("YES");
            }
        }
        in.close();
    }
}