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

    a = 1
    b = 2
    c = 4

    for i in range(3, n):
        current = a + b + c
        a = b
        b = c
        c = current

    return c


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = int(input())

    for s_itr in range(s):
        n = int(input())

        res = stepPerms(n)

        fptr.write(str(res) + '\n')

    fptr.close()
