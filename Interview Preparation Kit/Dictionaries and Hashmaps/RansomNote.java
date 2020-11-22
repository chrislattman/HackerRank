// https://www.hackerrank.com/challenges/ctci-ransom-note/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> wordCounts = new HashMap<>();
        boolean no = false;

        for (int i = 0; i < magazine.length; i++) {
            String word = magazine[i];
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            }
            else {
                wordCounts.put(word, 1);
            }
        }

        for (int j = 0; j < note.length; j++) {
            String word = note[j];
            if (wordCounts.containsKey(word) && wordCounts.get(word) > 0) {
                wordCounts.put(word, wordCounts.get(word) - 1);
            }
            else {
                System.out.println("No");
                no = true;
                break;
            }
        }

        if (!no) {
            System.out.println("Yes");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
