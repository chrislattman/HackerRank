// https://www.hackerrank.com/contests/gs-codesprint/challenges/trader-profit

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int traderProfit(int k, int n, int[] A) {
        // Complete this function
        int[][] profit = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            profit[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            profit[0][j] = 0;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int max_so_far = 0;
                for (int m = 0; m < j; m++) {
                    max_so_far = Math.max(max_so_far, A[j] - A[m] + profit[i - 1][m]);
                }
                profit[i][j] = Math.max(profit[i][j - 1], max_so_far);
            }
        }
        return profit[k][n - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }
}