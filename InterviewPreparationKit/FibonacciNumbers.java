// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
import java.util.*;

public class Solution {

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}