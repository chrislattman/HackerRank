#!/bin/python3
# https://www.hackerrank.com/challenges/angry-children/problem
import math
import os
import random
import re
import sys

# Complete the maxMin function below.
def maxMin(k, arr):
    arr.sort()
    min_diff = float('inf')

    stop = len(arr) - k + 1
    for i in range(stop):
        diff = arr[i + k - 1] - arr[i]
        if diff < min_diff:
            min_diff = diff

    return min_diff

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    k = int(input())

    arr = []

    for _ in range(n):
        arr_item = int(input())
        arr.append(arr_item)

    result = maxMin(k, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
