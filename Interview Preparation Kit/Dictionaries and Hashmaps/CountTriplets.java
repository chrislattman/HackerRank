// https://www.hackerrank.com/challenges/count-triplets-1/problem
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

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> first = new HashMap<>();
        HashMap<Long, Long> second = new HashMap<>();
        long triplets = 0;

        for (int i = 0; i < arr.size(); i++) {
            long current = arr.get(i);
            if (current % r == 0) {
                long preceding = current / r;
                if (second.containsKey(preceding)) {
                    triplets += second.get(preceding);
                }
                if (first.containsKey(preceding)) {
                    if (second.containsKey(current)) {
                        second.put(current, second.get(current) + first.get(preceding));
                    }
                    else {
                        second.put(current, first.get(preceding));
                    }
                }
            }

            if (first.containsKey(current)) {
                first.put(current, first.get(current) + 1L);
            }
            else {
                first.put(current, 1L);
            }
        }

        return triplets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
