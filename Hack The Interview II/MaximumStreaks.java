// https://www.hackerrank.com/contests/hack-the-interview-u-s-2/challenges/heads-or-tails/problem
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

class Result {

    /*
     * Complete the 'getMaxStreaks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY toss as parameter.
     */

    public static List<Integer> getMaxStreaks(List<String> toss) {
        // Return an array of two integers containing the maximum streak of heads and tails respectively
        String last = new String();
        int maxHeads = 0;
        int maxTails = 0;
        int currHeads = 0;
        int currTails = 0;
        for (int i = 0; i < toss.size(); i++) {
            String currString = toss.get(i);
            if (currString.equals("Heads")) {
                currHeads++;
            }
            else {
                currTails++;
            }
            if (!currString.equals(last) && last.length() > 0) {
                if (currString.equals("Tails")) {
                    if (currHeads > maxHeads) {
                        maxHeads = currHeads;
                    }
                    currHeads = 0;
                }
                if (currString.equals("Heads")) {
                    if (currTails > maxTails) {
                        maxTails = currTails;
                    }
                    currTails = 0;
                }
            }
            last = currString;
            if (i == toss.size() - 1 && currHeads > maxHeads) {
                maxHeads = currHeads;
            }
            if (i == toss.size() - 1 && currTails > maxTails) {
                maxTails = currTails;
            }
            System.out.println(i + ". currHeads = " + currHeads + ", currTails = " + currTails);
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(maxHeads);
        result.add(maxTails);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tossCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> toss = IntStream.range(0, tossCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> ans = Result.getMaxStreaks(toss);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
