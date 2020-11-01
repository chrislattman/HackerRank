#!/bin/python3
# https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
import math
import os
import random
import re
import sys

# Complete the stepPerms function below.
def stepPerms(n):
    if n < 3:
        return n
    if n == 3:
        return 4

    array = []
    array.append(1)
    array.append(2)
    array.append(4)
    for i in range(3, n):
        array.append(array[i - 1] + array[i - 2] + array[i - 3])

    return array[n - 1]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = int(input())

    for s_itr in range(s):
        n = int(input())

        res = stepPerms(n)

        fptr.write(str(res) + '\n')

    fptr.close()
