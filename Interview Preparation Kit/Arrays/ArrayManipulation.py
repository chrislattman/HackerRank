#!/bin/python3
# https://www.hackerrank.com/challenges/crush/problem
import math
import os
import random
import re
import sys

# Complete the arrayManipulation function below.
def arrayManipulation(n, queries):
    largest = 0
    array = [0] * n

    queries_len = len(queries)
    for i in range(queries_len):
        a = queries[i][0]
        b = queries[i][1]
        k = queries[i][2]

        array[a - 1] += k
        if (b < n):
            array[b] -= k

    curr_largest = 0
    for j in range(n):
        curr_largest += array[j]
        largest = max(curr_largest, largest)

    return largest


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    queries = []

    for _ in range(m):
        queries.append(list(map(int, input().rstrip().split())))

    result = arrayManipulation(n, queries)

    fptr.write(str(result) + '\n')

    fptr.close()
