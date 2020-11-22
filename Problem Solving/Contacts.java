// https://www.hackerrank.com/challenges/contacts/problem
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static class Node {
        private Node[] children;
        private int size;
        
        public Node() {
            children = new Node[26];
            size = 0;
        }
        
        private int getCharIndex(char c) {
            return c - 'a';
        }
        
        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }
        
        private void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }
        
        public void add(String s) {
            add(s, 0);
        }
        
        private void add(String s, int index) {
            size++;
            if (index == s.length()) {
                return;
            }
            
            char current = s.charAt(index);
            Node child = getNode(current);
            if (child == null) {
                child = new Node();
                setNode(current, child);
            }
            child.add(s, index + 1);
        }
        
        public int findCount(String s) {
            return findCount(s, 0);
        }
        
        private int findCount(String s, int index) {
            if (index == s.length()) {
                return size;
            }
            
            Node child = getNode(s.charAt(index));
            if (child == null) {
                return 0;
            }
            return child.findCount(s, index + 1);
        }
    }

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        Node root = new Node();
        ArrayList<Integer> finds = new ArrayList<>();
        
        for (int i = 0; i < queries.length; i++) {
            String op = queries[i][0];
            String term = queries[i][1];
            if (op.equals("add")) {
                root.add(term);
            }
            else {
                finds.add(root.findCount(term));
            }
        }
        
        int[] result = new int[finds.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = finds.get(i);
        }
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
