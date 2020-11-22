// https://www.hackerrank.com/contests/gs-codesprint/challenges/bank-accounts

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
        // Complete this function
        double max = 0;
        for (int i = 0; i < n; i++) {
            max += Math.max((double) k, (double) p[i] * (double) x / 100.0);
        }
        if (Double.compare(max, (double) d) <= 0) {
            return "fee";
        }
        else {
            return "upfront";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            int[] p = new int[n];
            for(int p_i = 0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }
}