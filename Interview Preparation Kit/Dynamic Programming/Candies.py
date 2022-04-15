#!/bin/python3
# https://www.hackerrank.com/challenges/candies/problem
import math
import os
import random
import re
import sys

# Complete the candies function below.
def candies(n, arr):
    up = [0] * n
    down = [0] * n
    up[0] = 1
    down[n - 1] = 1
    result = 0

    for i in range(1, n):
        if arr[i] > arr[i - 1]:
            up[i] = up[i - 1] + 1
        else:
            up[i] = 1
    for j in range(n - 2, -1, -1):
        if arr[j] > arr[j + 1]:
            down[j] = down[j + 1] + 1
        else:
            down[j] = 1
    for k in range(n):
        result += max(up[k], down[k]);

    return result


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = []

    for _ in range(n):
        arr_item = int(input())
        arr.append(arr_item)

    result = candies(n, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
