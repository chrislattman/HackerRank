// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static class RollingMedianHeaps {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public RollingMedianHeaps() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public double getMedian() {
            int size = minHeap.size() + maxHeap.size();
            if (size % 2 == 0) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            return (double) maxHeap.peek();
        }

        public void add(int number) {
            if (maxHeap.size() == 0 || number <= maxHeap.peek()) {
                maxHeap.add(number);
            }
            else {
                minHeap.add(number);
            }
            balanceHeaps();
        }

        public void remove(int number) {
            if (maxHeap.contains(number)) {
                maxHeap.remove(number);
            }
            else if (minHeap.contains(number)) {
                minHeap.remove(number);
            }
            balanceHeaps();
        }

        private void balanceHeaps() {
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            else if (maxHeap.size() > 1 + minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
        }
    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        RollingMedianHeaps heaps = new RollingMedianHeaps();

        for (int i = 0; i < expenditure.length; i++) {
            if (i >= d) {
                if ((double) expenditure[i] >= 2 * heaps.getMedian()) {
                    notifications++;
                }
                heaps.remove(expenditure[i - d]);
            }
            heaps.add(expenditure[i]);
        }

        return notifications;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
