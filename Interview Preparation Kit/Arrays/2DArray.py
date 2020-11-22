#!/bin/python3
# https://www.hackerrank.com/challenges/2d-array/problem
import math
import os
import random
import re
import sys

# Complete the hourglassSum function below.
def hourglassSum(arr):
    maximum = float('-inf')

    for i in range(16):
        first = arr[int(i / 4)][i % 4]
        second = arr[int(i / 4)][(i % 4) + 1]
        third = arr[int(i / 4)][(i % 4) + 2]
        fourth = arr[int(i / 4) + 1][(i % 4) + 1]
        fifth = arr[int(i / 4) + 2][i % 4]
        sixth = arr[int(i / 4) + 2][(i % 4) + 1]
        seventh = arr[int(i / 4) + 2][(i % 4) + 2]

        total = first + second + third + fourth + fifth + sixth + seventh

        if total > maximum:
            maximum = total
    
    return maximum

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []

    for _ in range(6):
        arr.append(list(map(int, input().rstrip().split())))

    result = hourglassSum(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
