// https://www.hackerrank.com/contests/gs-codesprint/challenges/time-series-queries

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] t = new int[n];
        for(int t_i = 0; t_i < n; t_i++){
            t[t_i] = in.nextInt();
        }
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int _type = in.nextInt();
            int v = in.nextInt();
            if (_type == 1) {
                boolean found = false;
                for (int i = 0; i < p.length; i++) {
                    if (p[i] >= v) {
                        System.out.println(t[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(-1);
                }
            }
            else {
                boolean foundtime = false;
                int timeindex = 0;
                for (int i = 0; i < t.length; i++) {
                    if (t[i] >= v) {
                        timeindex = i;
                        foundtime = true;
                        break;
                    }
                }
                if (!foundtime) {
                    System.out.println(-1);
                    continue;
                }
                int max = p[timeindex];
                for (int j = timeindex; j < p.length; j++) {
                    if (p[j] > max) {
                        max = p[j];
                    }
                }
                System.out.println(max);
            }
        }
        in.close();
    }
}