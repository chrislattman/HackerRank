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
        quotient = int(i / 4)
        remainder = i % 4

        first = arr[quotient][remainder]
        second = arr[quotient][remainder + 1]
        third = arr[quotient][remainder + 2]
        fourth = arr[quotient + 1][remainder + 1]
        fifth = arr[quotient + 2][remainder]
        sixth = arr[quotient + 2][remainder + 1]
        seventh = arr[quotient + 2][remainder + 2]

        total = first + second + third + fourth + fifth + sixth + seventh
        maximum = max(total, maximum)

    return maximum

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []

    for _ in range(6):
        arr.append(list(map(int, input().rstrip().split())))

    result = hourglassSum(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
