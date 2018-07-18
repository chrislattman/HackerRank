// https://www.hackerrank.com/contests/visa-codesprint/challenges/vbv-password

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Pattern num = Pattern.compile("[0-9]");
        Pattern letter = Pattern.compile("[a-zA-Z]");
        Pattern special = Pattern.compile("[@$%&*]");
        Matcher matchNum = num.matcher(s);
        Matcher matchLetter = letter.matcher(s);
        Matcher matchSpecial = special.matcher(s);
        if (s.length() > 7 && matchNum.find() && matchLetter.find() && matchSpecial.find()) {
            System.out.println("VALID");
        }
        else {
            System.out.println("INVALID");
        }
        in.close();
    }
}