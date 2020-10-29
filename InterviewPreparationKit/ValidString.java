// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        if (s.length() < 2) {
            return "YES";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            }
            else {
                map.put(current, 1);
            }
        }

        int highestFrequency = Integer.MIN_VALUE;
        int lowestFrequency = Integer.MAX_VALUE;
        int highestFrequencyCount = 0;
        int lowestFrequencyCount = 0;

        Iterator<Integer> iter = map.values().iterator();
        while (iter.hasNext()) {
            int value = iter.next();
            if (value > highestFrequency) {
                highestFrequency = value;
                highestFrequencyCount = 1;
            }
            else if (value == highestFrequency) {
                highestFrequencyCount++;
            }

            if (value < lowestFrequency) {
                lowestFrequency = value;
                lowestFrequencyCount = 1;
            }
            else if (value == lowestFrequency) {
                lowestFrequencyCount++;
            }
        }

        if (highestFrequency == lowestFrequency) {
            return "YES";
        }
        if (highestFrequency * highestFrequencyCount == s.length() - 1 &&
            lowestFrequency == 1) {
            return "YES";
        }
        if (lowestFrequency * lowestFrequencyCount + highestFrequency == 
            s.length() && highestFrequency - 1 == lowestFrequency) {
            return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
