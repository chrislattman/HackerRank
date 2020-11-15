#!/bin/python3
# https://www.hackerrank.com/challenges/pairs/problem
import math
import os
import random
import re
import sys

# Complete the pairs function below.
def pairs(k, arr):
    arr.sort()
    result = 0

    for i in range(len(arr) - 1):
        if binarysearch(arr, 0, len(arr) - 1, arr[i] + k) >= 0:
            result += 1

    return result


def binarysearch(arr, left, right, val):
    if left > right:
        return -1

    mid = int((left + right) / 2)

    if arr[mid] == val:
        return mid
    elif arr[mid] > val:
        return binarysearch(arr, left, mid - 1, val)
    else:
        return binarysearch(arr, mid + 1, right, val)


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    arr = list(map(int, input().rstrip().split()))

    result = pairs(k, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
