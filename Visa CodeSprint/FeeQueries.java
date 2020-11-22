// https://www.hackerrank.com/contests/visa-codesprint/challenges/fee-queries

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x, result;
        String[] input;
        
        int n = in.nextInt();
        int q = in.nextInt();
        Hashtable<Integer, Integer> shopFees = 
            new Hashtable<Integer, Integer>();
        for (int index = 0; index < n; index++) {
            shopFees.put(index, in.nextInt());
        }
        in.nextLine();
        for (int queries = 0; queries < q; queries++) {
            input = in.nextLine().split(" ");
            if (input[0].equals("change")) {
                shopFees.replace(Integer.parseInt(input[1]), 
                                 Integer.parseInt(input[2]));
            }
            else {
                x = Integer.parseInt(input[1]);
                result = 0;
                for (int fee : shopFees.values()) {
                    if (fee >= x) {
                        result++;
                    }
                }
                System.out.println(result);
            }
        }
        in.close();
    }
}