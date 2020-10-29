#!/bin/python3
# https://www.hackerrank.com/challenges/greedy-florist/problem
import math
import os
import random
import re
import sys

# Complete the getMinimumCost function below.
def getMinimumCost(k, c):
    c.sort()
    total = 0
    mod = 0
    multiplier = 1

    for i in reversed(range(len(c))):
        total += c[i] * multiplier
        mod = (mod + 1) % k
        if mod == 0:
            multiplier += 1

    return total

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    c = list(map(int, input().rstrip().split()))

    minimumCost = getMinimumCost(k, c)

    fptr.write(str(minimumCost) + '\n')

    fptr.close()
