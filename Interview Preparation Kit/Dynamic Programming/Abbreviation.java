// https://www.hackerrank.com/challenges/abbr/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int m = a.length();
        int n = b.length();

        boolean[][] valid = new boolean[m + 1][n + 1];
        valid[0][0] = true;

        for (int i = 1; i <= m; i++) {
            int end = Math.min(i, n);
            for (int j = 0; j <= end; j++) {
                char a_char = a.charAt(i - 1);

                if (j == 0) {
                    if (Character.isLowerCase(a_char)) {
                        valid[i][j] = valid[i - 1][j];
                    }
                }
                else {
                    char b_char = b.charAt(j - 1);

                    if (a_char == b_char) {
                        valid[i][j] = valid[i - 1][j - 1];
                    }
                    else if (Character.toUpperCase(a_char) == b_char) {
                        valid[i][j] = valid[i - 1][j - 1] | valid[i - 1][j];
                    }
                    else if (Character.isLowerCase(a_char)) {
                        valid[i][j] = valid[i - 1][j];
                    }
                }
            }
        }

        if (valid[m][n]) {
            return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
