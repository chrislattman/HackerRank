// https://www.hackerrank.com/contests/indeed-prime-challenge-june-2015/challenges/soyuz-11

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        System.out.println("  /\\");
        for (int i = 0; i < size; i++) {
            System.out.println("  ||");
        }
        System.out.println(" /||\\");
        System.out.println("/:||:\\");
        for (int j = 0; j < size - 1; j++) {
            System.out.println("|:||:|");
        }
        System.out.println("|/||\\|");
        System.out.println("  **");
        System.out.println("  **");
        in.close();
    }
}