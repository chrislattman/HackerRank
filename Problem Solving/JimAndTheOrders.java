// https://www.hackerrank.com/challenges/jim-and-the-orders/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static class Receipt {
        int time;
        int customer;
        
        public Receipt(int time, int customer) {
            this.time = time;
            this.customer = customer;
        }
    }
    
    public static class Sorter implements Comparator<Receipt> {
        public int compare(Receipt r1, Receipt r2) {
            if (r1.time > r2.time) {
                return 1;
            }
            else if (r1.time < r2.time) {
                return -1;
            }
            else if (r1.customer > r2.customer) {
                return 1;
            }
            else if (r1.customer < r2.customer) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        Receipt[] receipts = new Receipt[orders.length];
        Sorter sorter = new Sorter();
        
        for (int i = 0; i < orders.length; i++) {
            int time = orders[i][0] + orders[i][1];
            receipts[i] = new Receipt(time, i + 1);
        }
        
        Arrays.sort(receipts, sorter);
        int[] result = new int[receipts.length];
        for (int i = 0; i < receipts.length; i++) {
            result[i] = receipts[i].customer;
        }
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
