// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> a_map = new HashMap<>();
        HashMap<Character, Integer> b_map = new HashMap<>();

        int a_len = a.length();
        for (int i = 0; i < a_len; i++) {
            char letter = a.charAt(i);
            if (a_map.containsKey(letter)) {
                a_map.put(letter, a_map.get(letter) + 1);
            }
            else {
                a_map.put(letter, 1);
            }
        }

        int b_len = b.length();
        for (int j = 0; j < b_len; j++) {
            char letter = b.charAt(j);
            if (b_map.containsKey(letter)) {
                b_map.put(letter, b_map.get(letter) + 1);
            }
            else {
                b_map.put(letter, 1);
            }
        }

        int removed = 0;
        for (char key = 'a'; key <= 'z'; key++) {
            if (a_map.containsKey(key) && b_map.containsKey(key)) {
                removed += (int) Math.abs(a_map.get(key) - b_map.get(key));
            }
            else if (a_map.containsKey(key)) {
                removed += a_map.get(key);
            }
            else if (b_map.containsKey(key)) {
                removed += b_map.get(key);
            }
        }

        return removed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
