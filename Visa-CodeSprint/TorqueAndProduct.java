import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/contests/visa-codesprint/challenges/torque-and-product

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        for (long i = (long) Math.sqrt(n); i > 0; i--) {
            if (n % (i * i) == 0) {
                System.out.printf("%d ", n / (i * i));
            }
        }
    }
}