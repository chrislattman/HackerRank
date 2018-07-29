// https://www.hackerrank.com/contests/moodysuniversityhackathon/challenges/learning-from-the-past

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long max = 0;
        long first, second, third;
        for (int i = 0; i < n; i++) {
            first = in.nextLong();
            second = in.nextLong();
            third = in.nextLong();
            if (first + second > max) {
                max = first + second;
            }
            if (first + third > max) {
                max = first + third;
            }
            if (second + third > max) {
                max = second + third;
            }
        }
        System.out.println(max);
    }
}