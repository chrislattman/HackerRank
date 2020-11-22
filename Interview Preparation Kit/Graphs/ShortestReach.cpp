// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <deque>

using namespace std;

class Graph {
    private:
        class Node {
            public:
                vector<int> neighbors;
        };
        vector<Node> nodes;
        int edge_weight = 6;
        
    public:
        Graph(int n) {
            for (int i = 0; i < n; i++) {
                nodes.insert(nodes.end(), Node());
            }
        }
    
        void add_edge(int u, int v) {
            nodes[u].neighbors.insert(nodes[u].neighbors.end(), v);
            nodes[v].neighbors.insert(nodes[v].neighbors.end(), u);
        }
    
        vector<int> shortest_reach(int start) {
            deque<int> queue;
            queue.push_back(start);
            
            vector<int> distances(nodes.size(), -1);
            distances[start] = 0;
            
            while (!queue.empty()) {
                int node = queue.front();
                queue.pop_front();
                for (int neighbor : nodes[node].neighbors) {
                    if (distances[neighbor] == -1) {
                        distances[neighbor] = distances[node] + edge_weight;
                        queue.push_back(neighbor);
                    }
                }
            }
            
            return distances;
        }
};

int main() {
    int queries;
    cin >> queries;
    
    for (int t = 0; t < queries; t++) {
      
        int n, m;
        cin >> n;
        // Create a graph of size n where each edge weight is 6: 
        Graph graph(n);
        cin >> m;
        // read and set edges
        for (int i = 0; i < m; i++) {
            int u, v;
            cin >> u >> v;
            u--, v--;
            // add each edge to the graph
            graph.add_edge(u, v);
        }
        int startId;
        cin >> startId;
        startId--;
        // Find shortest reach from node s
        vector<int> distances = graph.shortest_reach(startId);

        for (int i = 0; i < distances.size(); i++) {
            if (i != startId) {
                cout << distances[i] << " ";
            }
        }
        cout << endl;
    }
    
    return 0;
}
