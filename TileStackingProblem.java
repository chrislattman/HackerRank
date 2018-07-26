// https://www.hackerrank.com/contests/moodys-analytics-fall-university-codesprint/challenges/tile-stacking-problem/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int tileStackingProblem(int n, int m, int k) {
        // Complete this function
        if (k > n) {
            k = n;
        }
        long[][] dp = new long[m + 1][n + 1];
        long sum = 0;
        dp[0][0] = 1;
        for (int a = 0; a <= k; a++) {
            dp[1][a] = 1;
        }
        for (int b = 1; b < m; b++) {
            sum = 0;
            for (int c = 0; c <= k; c++) {
                sum += dp[b][c];
                dp[b + 1][c] = sum % 1000000007;
            }
        }
        for (int d = 2; d <= m; d++) {
            for (int e = k + 1; e <= n; e++) {
                long val = dp[d][e - 1] - dp[d - 1][e - k - 1] + dp[d - 1][e];
                val %= 1000000007;
                while (val < 0) {
                    val += 1000000007;
                }
                dp[d][e] = val;
            }
        }
        return (int) dp[m][n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int result = tileStackingProblem(n, m, k);
        System.out.println(result);
        in.close();
    }
}