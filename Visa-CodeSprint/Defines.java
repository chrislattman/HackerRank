// https://www.hackerrank.com/contests/visa-codesprint/challenges/defines

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String finish = "";
        String[] input = s.split("");
        Stack<String> letters = new Stack<String>();
        int p = 0;
        int i = 0;
        int size = 0;
        for (int index = input.length - 1; index >= 0; index--) {
            String current = input[index];
            if (current.equals("p")) {
                p++;
                if (size > 1) {
                    finish = "pair<" + letters.pop() + "," + 
                        letters.pop() + ">";
                    letters.push(finish);
                    size--;
                }
            }
            else {
                letters.push("int");
                i++;
                size++;
            }
        }
        if (i - p != 1 || size != 1 || letters.peek().equals("int")) {
            System.out.println(-1);
        }
        else {
            System.out.println(letters.pop());
        }
        in.close();
    }
}