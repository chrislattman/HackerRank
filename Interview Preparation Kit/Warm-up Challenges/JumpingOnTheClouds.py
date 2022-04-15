#!/bin/python3
# https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
import math
import os
import random
import re
import sys

# Complete the jumpingOnClouds function below.
def jumpingOnClouds(c):
    index = 0
    jumps = 0
    stop = len(c) - 2

    while index < stop:
        if c[index + 2] == 0:
            index += 2
        else:
            index += 1
        jumps += 1

    if index == stop:
        jumps += 1

    return jumps

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(c)

    fptr.write(str(result) + '\n')

    fptr.close()
