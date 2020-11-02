// https://www.hackerrank.com/challenges/triple-sum/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        ArrayList<Integer> a_set = new ArrayList<>();
        ArrayList<Integer> b_set = new ArrayList<>();
        ArrayList<Integer> c_set = new ArrayList<>();
        a_set.add(a[0]);
        b_set.add(b[0]);
        c_set.add(c[0]);

        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                a_set.add(a[i]);
            }
        }

        for (int j = 1; j < b.length; j++) {
            if (b[j] != b[j - 1]) {
                b_set.add(b[j]);
            }
        }

        for (int k = 1; k < c.length; k++) {
            if (c[k] != c[k - 1]) {
                c_set.add(c[k]);
            }
        }

        int a_size = a_set.size();
        int b_size = b_set.size();
        int c_size = c_set.size();

        long triplets = 0L;
        int a_index = 0;
        int c_index = 0;
        for (int m = 0; m < b_size; m++) {
            while (a_index < a_size && a_set.get(a_index) <= b_set.get(m)) {
                a_index++;
            }
            while (c_index < c_size && c_set.get(c_index) <= b_set.get(m)) {
                c_index++;
            }

            triplets += (long) a_index * (long) c_index;
        }

        return triplets;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
