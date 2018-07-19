// https://www.hackerrank.com/contests/gs-codesprint/challenges/trader-profit

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int traderProfit(int k, int n, int[] A) {
        // Complete this function
        int curr = A[0];
        int profit = 0;
        int trans = 0;
        int i = 0;
        boolean sold = false;
        while (i < n - 1 && trans < k) {
            if (A[i] == A[i + 1] || (A[i] > A[i + 1] && sold) || (A[i] < A[i + 1] && !sold)) {
                //nothing
            }
            else if (A[i] > A[i + 1] && !sold) {
                profit += A[i] - curr;
                sold = true;
                trans++;
            }
            else { //A[i] < A[i + 1] && sold
                curr = A[i];
                sold = false;
            }
            i++;
        }
        return profit;
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