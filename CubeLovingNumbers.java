// https://www.hackerrank.com/contests/university-codesprint-5/challenges/cube-loving-numbers/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the solve function below.
    static long solve(long n) {
        Set<Long> set = new HashSet<Long>();
        for (long i = 2; i * i * i <= n; i++) {
            boolean composite = false;
            for (long j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    composite = true;
                    break;
                }
            }
            if (!composite) {
                long cube = i * i * i;
                for (long k = 1; k <= n / cube; k++) {
                    set.add(cube * k);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = solve(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
