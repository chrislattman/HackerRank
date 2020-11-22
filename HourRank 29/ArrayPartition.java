// https://www.hackerrank.com/contests/hourrank-29/challenges/array-partition/problem

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
    static int mod = 1000000007;

    // Complete the solve function below.
    static int solve(List<Integer> a) {
        int result = 0;
        int iter = 1;
        Collections.sort(a);
        for (int x = 0; x < a.size(); x++) { //need to iterate through full # of permutations
            int groupa = 1;
            int groupb = 1;
            int p = 0;
            while (p < iter) {
                groupa *= a.get(p);
                p++;
            }
            for (int i = p; i < a.size(); i++) {
                groupb *= a.get(i);
            }
            while (groupb > 0) {
                int temp = groupa;
                groupa = groupb;
                groupb = temp % groupb;
            }
            if (groupa == 0) {
                result++;
            }
            iter++;
            //need to permute 
        }
        return result % mod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int aCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                int result = solve(a);

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
