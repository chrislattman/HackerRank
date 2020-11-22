# https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
class Graph:
    class Node:
        def __init__(self):
            self.neighbors = []
    
    def __init__(self, size):
        self.edge_weight = 6
        self.nodes = []
        for i in range(size):
            new_node = self.Node()
            self.nodes.append(new_node)
    
    def connect(self, first, second):
        self.nodes[first].neighbors.append(second)
        self.nodes[second].neighbors.append(first)
    
    def find_all_distances(self, startId):
        queue = []
        queue.append(startId)
        
        distances = [-1] * len(self.nodes)
        distances[startId] = 0
        
        while (len(queue) > 0):
            node = queue.pop(0)
            for neighbor in self.nodes[node].neighbors:
                if distances[neighbor] == -1:
                    distances[neighbor] = distances[node] + self.edge_weight
                    queue.append(neighbor)
                    
        return distances


t = int(input())
for i in range(t):
    n, m = [int(value) for value in input().split()]
    graph = Graph(n)
    
    for i in range(m):
        x, y = [int(x) for x in input().split()]
        graph.connect(x - 1, y - 1)
    
    s = int(input()) - 1
    distances = graph.find_all_distances(s)
    
    for i in range(len(distances)):
        if i != s:
            print(distances[i], end=' ')
    print()
