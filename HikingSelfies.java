// https://www.hackerrank.com/contests/walmart-codesprint-algo/challenges/emma-and-her-camera

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int combos = 0;
        for (int i = 0; i < n; i++) {
            combos = 2 * combos + 1;
        }
        System.out.println(Math.abs(combos - x));
        in.close();
    }
}