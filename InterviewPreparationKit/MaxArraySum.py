#!/bin/python3
# https://www.hackerrank.com/challenges/max-array-sum/problem
import math
import os
import random
import re
import sys

# Complete the maxSubsetSum function below.
def maxSubsetSum(arr):
    arr[0] = max(0, arr[0])
    arr[1] = max(arr[0], arr[1])
    
    for i in range(2, len(arr)):
        arr[i] = max(arr[i] + arr[i - 2], arr[i - 1])
        
    return arr[-1]


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    res = maxSubsetSum(arr)

    fptr.write(str(res) + '\n')

    fptr.close()
