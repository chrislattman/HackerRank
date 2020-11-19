// https://www.hackerrank.com/challenges/new-year-chaos/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int swaps = 0;
        int index = 0;
        int lastSortedIndex = -1;
        boolean too_chaotic = false;
        HashMap<Integer, Integer> bribeMap = new HashMap<>();
        
        while (index < q.length - 1) {
            if (q[index] > q[index + 1]) {
                if (bribeMap.containsKey(q[index]) && bribeMap.get(q[index]) >= 2) {
                    System.out.println("Too chaotic");
                    too_chaotic = true;
                    break;
                }
                if (!bribeMap.containsKey(q[index])) {
                    bribeMap.put(q[index], 0);
                }
                bribeMap.put(q[index], bribeMap.get(q[index]) + 1);
                
                int temp = q[index];
                q[index] = q[index + 1];
                q[index + 1] = temp;
                
                swaps++;
                index = lastSortedIndex;
            }
            else if (q[index] == index + 1) {
                lastSortedIndex++;
            }
            index++;
        }
        
        if (!too_chaotic) {
            System.out.println(swaps);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
