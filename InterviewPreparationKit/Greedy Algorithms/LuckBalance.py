#!/bin/python3
# https://www.hackerrank.com/challenges/luck-balance/problem
import math
import os
import random
import re
import sys

# Complete the luckBalance function below.
def luckBalance(k, contests):
    balance = 0
    important = []

    for i in range(len(contests)):
        if contests[i][1] == 0:
            balance += contests[i][0]
        else:
            important.append(contests[i][0])

    important.sort()

    if len(important) > k:
        for j in range(len(important) - k, len(important)):
            balance += important[j]

        for m in range(len(important) - k):
            balance -= important[m]
    else:
        for p in range(len(important)):
            balance += important[p]

    return balance

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    contests = []

    for _ in range(n):
        contests.append(list(map(int, input().rstrip().split())))

    result = luckBalance(k, contests)

    fptr.write(str(result) + '\n')

    fptr.close()
