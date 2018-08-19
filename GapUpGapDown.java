// https://www.hackerrank.com/contests/moodys-analytics-2018-university-codesprint/challenges/gap-up-down

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
    static void solve(List<Integer> low, List<Integer> high, List<Integer> close) {
        int gapup = 0;
        int gapdown = 0;
        for (int i = 1; i < close.size(); i++) {
            if (low.get(i) > close.get(i - 1)) {
                gapup++;
            }
            if (high.get(i) < close.get(i - 1)) {
                gapdown++;
            }
        }
        System.out.println(gapup + " " + gapdown);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> low = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> high = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> close = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        solve(low, high, close);

        bufferedReader.close();
    }
}
