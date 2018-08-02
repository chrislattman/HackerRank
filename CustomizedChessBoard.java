// https://www.hackerrank.com/contests/hourrank-29/challenges/customized-chess-board

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
    static String solve(List<List<Integer>> board) {
        for (int i = 0; i < board.size() - 1; i++) {
            List<Integer> s = board.get(i);
            for (int j = 0; j < s.size() - 1; j++) {
                if (s.get(j) == s.get(j + 1)) {
                    return "No";
                }
                if (s.get(j) == board.get(i + 1).get(j)) {
                    return "No";
                }
            }
        }
        return "Yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> board = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        board.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = solve(board);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
