#!/bin/python3
# https://www.hackerrank.com/challenges/ctci-big-o/problem
import math
import os
import random
import re
import sys

# Complete the primality function below.
def primality(n):
    if n == 1:
        return 'Not prime'

    root = int(math.sqrt(n)) + 1
    for i in range(2, root):
        if n % i == 0:
            return 'Not prime'

    return 'Prime'


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    p = int(input())

    for p_itr in range(p):
        n = int(input())

        result = primality(n)

        fptr.write(result + '\n')

    fptr.close()
