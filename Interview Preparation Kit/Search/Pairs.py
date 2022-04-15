#!/bin/python3
# https://www.hackerrank.com/challenges/pairs/problem
import math
import os
import random
import re
import sys

def binarysearch(arr, left, right, val):
    while left <= right:
        mid = int((left + right) / 2)
        if arr[mid] == val:
            return mid
        elif arr[mid] > val:
            right = mid - 1
        else:
            left = mid + 1

    return -1

# Complete the pairs function below.
def pairs(k, arr):
    arr.sort()
    result = 0

    edge = len(arr) - 1
    for i in range(edge):
        if binarysearch(arr, 0, edge, arr[i] + k) >= 0:
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
