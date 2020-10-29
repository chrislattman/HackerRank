#!/bin/python3
# https://www.hackerrank.com/challenges/recursive-digit-sum/problem
import math
import os
import random
import re
import sys

# Complete the superDigit function below.
def superDigit(n, k):
    if len(n) == 1 and k == 1:
        return int(n)

    sum = 0
    for i in range(len(n)):
        sum += int(n[i]) * k

    return superDigit(str(sum), 1)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = nk[0]

    k = int(nk[1])

    result = superDigit(n, k)

    fptr.write(str(result) + '\n')

    fptr.close()
