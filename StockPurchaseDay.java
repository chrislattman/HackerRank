// https://www.hackerrank.com/contests/moodys-analytics-fall-university-codesprint/challenges/stock-purchase-day

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int stockPurchaseDay(int[] A, int xi, int low, int high) {
        // Complete this function
        int middle = (high + low) / 2;
        if (xi == A[middle] && xi < A[middle + 1]) {
            return middle + 1;
        }
        else if (xi >= A[middle]) {
            if (middle == A.length - 2 && xi >= A[middle + 1]) {
                return A.length;
            }
            if (middle == A.length - 2 && xi < A[middle + 1]) {
                return A.length - 1;
            }
            if (high - middle < 2) {
                return middle + 1;
            }
            return stockPurchaseDay(A, xi, middle, high);
        }
        else {
            if (middle == 1 && xi == A[0]) {
                return 1;
            }
            if (middle == 1 && xi < A[0]) {
                return -1;
            }
            return stockPurchaseDay(A, xi, low, middle);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] orderedmin = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        orderedmin[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            orderedmin[i] = Math.min(orderedmin[i + 1], A[i]);
        }
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int xi = in.nextInt();
            int result = stockPurchaseDay(orderedmin, xi, 0, n - 1);
            System.out.println(result);
        }
        in.close();
    }
}