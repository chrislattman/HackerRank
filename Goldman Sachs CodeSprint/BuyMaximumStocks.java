// https://www.hackerrank.com/contests/gs-codesprint/challenges/buy-maximum-stocks

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long buyMaximumProducts(int n, long k, int[] a) {
        // Complete this function
        TreeMap<Integer, Integer> stocks = new TreeMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
            if (stocks.containsKey(a[i - 1])) {
                stocks.replace(a[i - 1], stocks.get(a[i - 1]) + i);
            }
            else {
                stocks.put(a[i - 1], i);
            }
        }
        long numstocks = 0L;
        long price = 0L;
        int size = stocks.size();
        for (int i = 1; i <= size; i++) {
            long maxshares = (long) stocks.get(stocks.firstKey());
            if (Long.compare(price + ((long) stocks.firstKey() * maxshares), k) <= 0) {
                price += ((long) stocks.firstKey()) * maxshares;
                numstocks += maxshares;
            }
            else {
                for (int j = 1; j < maxshares; j++) {
                    price += (long) stocks.firstKey();
                    if (Long.compare(price, k) > 0) {
                        return numstocks;
                    }
                    numstocks++;
                }
            }
            stocks.remove(stocks.firstKey());
        }
        return numstocks;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}