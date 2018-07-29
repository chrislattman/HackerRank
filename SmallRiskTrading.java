// https://www.hackerrank.com/contests/moodysuniversityhackathon/challenges/small-risk-trading

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        double[] prob = new double[n];
        for (int a = 0; a < n; a++) {
            prob[a] = in.nextDouble();
        }
        double[] profit = new double[n];
        double[] loss = new double[n];
        for (int b = 0; b < n; b++) {
            profit[b] = in.nextDouble();
        }
        for (int c = 0; c < n; c++) {
            loss[c] = in.nextDouble();
        }
        double[] expected = new double[n];
        for (int d = 0; d < n; d++) {
            expected[d] = prob[d] * profit[d] - (1.0 - prob[d]) * loss[d];
        }
        Arrays.sort(expected);
        double max = 0;
        for (int e = n - 1; e >= n - k; e--) {
            if (expected[e] > 0) {
                max += expected[e];
            }
        }
        System.out.printf("%.2f", max);
        in.close();
    }
}