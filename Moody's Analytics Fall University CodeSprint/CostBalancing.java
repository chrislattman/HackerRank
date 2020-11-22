// https://www.hackerrank.com/contests/moodys-analytics-fall-university-codesprint/challenges/cost-balancing

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = 0;
        int[] payments = new int[m];
        for(int a0 = 0; a0 < n; a0++){
            int id_number = in.nextInt();
            int amount = in.nextInt();
            payments[id_number - 1] += amount;
            sum += amount;
        }
        int equity = sum / m;
        int diff = sum - (equity * m);
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                System.out.printf("%d %d\n", i + 1, payments[0] - 
                                  (equity + diff));
            }
            else {
                System.out.printf("%d %d\n", i + 1, payments[i] - equity);
            }
        }
        in.close();
    }
}