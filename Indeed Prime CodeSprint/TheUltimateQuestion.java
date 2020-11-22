// https://www.hackerrank.com/contests/indeed-prime-codesprint/challenges/the-ultimate-question

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int sum = a + b + c;
        int mixed1 = a + b * c;
        int mixed2 = a * b + c;
        int product = a * b * c;
        if (sum == 42) {
            System.out.println(a + "+" + b + "+" + c);
        }
        else if (mixed1 == 42) {
            System.out.println(a + "+" + b + "*" + c);
        }
        else if (mixed2 == 42) {
            System.out.println(a + "*" + b + "+" + c);
        }
        else if (product == 42) {
            System.out.println(a + "*" + b + "*" + c);
        }
        else {
            System.out.println("This is not the ultimate question");
        }
        in.close();
    }
}