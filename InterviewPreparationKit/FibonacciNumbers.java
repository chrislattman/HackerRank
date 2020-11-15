// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
import java.util.*;

public class Solution {

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        int a = 1;
        int b = 1;
        int current;

        for (int i = 2; i < n; i++) {
            current = a + b;
            a = b;
            b = current;
        }
        
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
