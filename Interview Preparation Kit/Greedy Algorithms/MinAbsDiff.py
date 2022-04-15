#!/bin/python3
# https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
import math
import os
import random
import re
import sys

# Complete the minimumAbsoluteDifference function below.
def minimumAbsoluteDifference(arr):
    min_diff = float('inf')
    arr.sort()

    stop = len(arr) - 1
    for i in range(stop):
        diff = arr[i + 1] - arr[i]
        if diff < min_diff:
            min_diff = diff

    return min_diff

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    result = minimumAbsoluteDifference(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
