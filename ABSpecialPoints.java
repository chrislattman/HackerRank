// https://www.hackerrank.com/contests/university-codesprint-5/challenges/ab-special-points/problem

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
    static int solve(int n, List<List<Integer>> edges, int a, int b) {
        long[] adjacencies = new long[300000];
        long[] aa = new long[300000];
        long[] bb = new long[300000];
        int index = 0;
        int vertex = 0;
        int total = 0;
        
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            adjacencies[edge.get(0) - 1]++;
            adjacencies[edge.get(1) - 1]++;
            vertex = Math.max(edge.get(0), edge.get(1));
            index = Math.max(index, vertex);
        }
        for (int j = 0; j < index; j++) {
            aa[j] = ((long) a) * adjacencies[j];
            bb[j] = ((long) b) * adjacencies[j];
        }
        Arrays.sort(aa, 0, index);
        Arrays.sort(bb, 0, index);
        for (int k = 0; k < index; k++) {
            if (aa[0] < adjacencies[k] && adjacencies[k] < bb[index - 1]) {
                total++;
            }
        }
        
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmab = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nmab[0]);

        int m = Integer.parseInt(nmab[1]);

        int a = Integer.parseInt(nmab[2]);

        int b = Integer.parseInt(nmab[3]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = solve(n, edges, a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
