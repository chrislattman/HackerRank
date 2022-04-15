#!/bin/python3
# https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
import math
import os
import random
import re
import sys

def search(grid, grid_rows, grid_cols, x, y):
    if (x >= 0 and y >= 0 and x < grid_rows and y < grid_cols
        and grid[x][y] == 1):
        grid[x][y] = 0
        return 1 + (search(grid, grid_rows, grid_cols, x - 1, y) +
            search(grid, grid_rows, grid_cols, x + 1, y) +
            search(grid, grid_rows, grid_cols, x, y - 1) +
            search(grid, grid_rows, grid_cols, x, y + 1) +
            search(grid, grid_rows, grid_cols, x - 1, y - 1) +
            search(grid, grid_rows, grid_cols, x + 1, y - 1) +
            search(grid, grid_rows, grid_cols, x - 1, y + 1) +
            search(grid, grid_rows, grid_cols, x + 1, y + 1))
    return 0

# Complete the maxRegion function below.
def maxRegion(grid):
    largest = 0

    grid_rows = len(grid)
    grid_cols = len(grid[0])
    for x in range(grid_rows):
        for y in range(grid_cols):
            if grid[x][y] == 1:
                current = search(grid, grid_rows, grid_cols, x, y)
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
