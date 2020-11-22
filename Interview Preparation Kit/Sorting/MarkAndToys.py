#!/bin/python3
# https://www.hackerrank.com/challenges/mark-and-toys/problem
import math
import os
import random
import re
import sys

# Complete the maximumToys function below.
def maximumToys(prices, k):
    prices.sort()
    toys = 0
    total = 0

    for i in range(len(prices)):
        total += prices[i]
        if total <= k:
            toys += 1
        else:
            return toys

    return toys

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    prices = list(map(int, input().rstrip().split()))

    result = maximumToys(prices, k)

    fptr.write(str(result) + '\n')

    fptr.close()
