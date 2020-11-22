// https://www.hackerrank.com/challenges/components-in-graph/problem
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    static int find(int vertex, int[] vertexArray) {
        if (vertexArray[vertex] == vertex) {
            return vertex;
        }
        vertexArray[vertex] = find(vertexArray[vertex], vertexArray);
        return vertexArray[vertex];
    }

    /*
     * Complete the componentsInGraph function below.
     */
    static int[] componentsInGraph(int[][] gb) {
        /*
         * Write your code here.
         */
        int array_length = gb.length * gb[0].length;
        int[] vertexArray = new int[array_length];
        int[] weights = new int[array_length];
        
        for (int i = 0; i < array_length; i++) {
            vertexArray[i] = i;
            weights[i] = 1;
        }
        
        for (int i = 0; i < gb.length; i++) {
            int u = gb[i][0] - 1;
            int v = gb[i][1] - 1;
            
            int u_parent = find(u, vertexArray);
            int v_parent = find(v, vertexArray);
            if (u_parent != v_parent) {
                if (weights[u_parent] < weights[v_parent]) {
                    vertexArray[u_parent] = v_parent;
                    weights[v_parent] += weights[u_parent];
                }
                else if (weights[u_parent] > weights[v_parent]) {
                    vertexArray[v_parent] = u_parent;
                    weights[u_parent] += weights[v_parent];
                }
                else if (u_parent < v_parent) {
                    vertexArray[v_parent] = u_parent;
                    weights[u_parent] += weights[v_parent];
                }
                else {
                    vertexArray[u_parent] = v_parent;
                    weights[v_parent] += weights[u_parent];
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for (int i = 0; i < array_length; i++) {
            if (weights[i] > 1) {
                if (weights[i] < min && vertexArray[i] == i) {
                    min = weights[i];
                }
                if (weights[i] > max && vertexArray[i] == i) {
                    max = weights[i];
                }
            }
        }
        
        return new int[]{min, max};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
