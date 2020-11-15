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

    array = []
    array.append(1)
    array.append(2)
    array.append(4)
    for i in range(3, n):
        current = array[2] + array[1] + array[0]
        array[0] = array[1]
        array[1] = array[2]
        array[2] = current

    return array[2]


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = int(input())

    for s_itr in range(s):
        n = int(input())

        res = stepPerms(n)

        fptr.write(str(res) + '\n')

    fptr.close()
