// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        private Node[] nodes;
        private final int edge_weight = 6;

        public Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node();
            }
        }

        public void addEdge(int first, int second) {
            nodes[first].neighbors.add(second);
            nodes[second].neighbors.add(first);
        }

        public int[] shortestReach(int startId) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(startId);

            int[] distances = new int[nodes.length];
            Arrays.fill(distances, -1);
            distances[startId] = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : nodes[node].neighbors) {
                    if (distances[neighbor] == -1) {
                        distances[neighbor] = distances[node] + edge_weight;
                        queue.add(neighbor);
                    }
                }
            }

            return distances;
        }

        private class Node {
            public ArrayList<Integer> neighbors;

            public Node() {
                neighbors = new ArrayList<>();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
