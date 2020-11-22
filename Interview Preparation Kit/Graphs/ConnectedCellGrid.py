#!/bin/python3
# https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
import math
import os
import random
import re
import sys

def search(grid, visited, x, y):
    if (x >= 0 and y >= 0 and x < len(grid) and y < len(grid[0]) 
        and grid[x][y] == 1 and not visited[x][y]):
        visited[x][y] = True
        return 1 + (search(grid, visited, x - 1, y) + 
            search(grid, visited, x + 1, y) + 
            search(grid, visited, x, y - 1) + 
            search(grid, visited, x, y + 1) + 
            search(grid, visited, x - 1, y - 1) + 
            search(grid, visited, x + 1, y - 1) + 
            search(grid, visited, x - 1, y + 1) + 
            search(grid, visited, x + 1, y + 1))
    return 0

# Complete the maxRegion function below.
def maxRegion(grid):
    visited = [[False] * len(grid[0]) for _ in range(len(grid))]
    largest = 0
    
    for x in range(len(grid)):
        for y in range(len(grid[0])):
            if grid[x][y] == 1 and not visited[x][y]:
                current = search(grid, visited, x, y)
                if current > largest:
                    largest = current
    
    return largest


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    m = int(input())

    grid = []

    for _ in range(n):
        grid.append(list(map(int, input().rstrip().split())))

    res = maxRegion(grid)

    fptr.write(str(res) + '\n')

    fptr.close()
