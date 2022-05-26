#!/bin/python3
# https://www.hackerrank.com/challenges/pairs/problem
import math
import os
import random
import re
import sys
from bisect import bisect

# Complete the pairs function below.
def pairs(k, arr):
    arr.sort()
    result = 0

    edge = len(arr) - 1
    for i in range(edge):
        key = arr[i] + k
        if arr[bisect(arr, key) - 1] == key:
            result += 1

    return result


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    arr = list(map(int, input().rstrip().split()))

    result = pairs(k, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
