// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int search(int[][] grid, boolean[][] visited, int x, int y) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && 
                grid[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            return 1 + search(grid, visited, x - 1, y) + 
                    search(grid, visited, x + 1, y) + 
                    search(grid, visited, x, y - 1) + 
                    search(grid, visited, x, y + 1) + 
                    search(grid, visited, x - 1, y - 1) + 
                    search(grid, visited, x + 1, y - 1) + 
                    search(grid, visited, x - 1, y + 1) + 
                    search(grid, visited, x + 1, y + 1);
        }
        return 0;
    }

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int largest = 0;
        
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1 && !visited[x][y]) {
                    int current = search(grid, visited, x, y);
                    if (current > largest) {
                        largest = current;
                    }
                }
            }
        }
        
        return largest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
