// https://www.hackerrank.com/contests/moodys-analytics-fall-university-codesprint/challenges/lets-play-a-game-2/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int playGame(int[][] arr) {
        // Complete this function
        int a = 0;
        int b = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1][1] == arr[i][1]) {
                if (arr[i][1] != 0) {
                    b++;
                }
                else {
                    a++;
                }
            }
        }
        return arr.length - Math.max(a, b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int[][] arr = new int[n][2];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i][0] = in.nextInt();
            arr[arr_i][1] = s.charAt(arr_i) & 1;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int result = playGame(arr);
        System.out.println(result);
        in.close();
    }
}