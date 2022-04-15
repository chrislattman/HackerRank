#!/bin/python3
# https://www.hackerrank.com/challenges/abbr/problem
import math
import os
import random
import re
import sys

# Complete the abbreviation function below.
def abbreviation(a, b):
    m = len(a)
    n = len(b)

    valid = [[False] * (n + 1) for _ in range(m + 1)]
    valid[0][0] = True;

    for i in range(1, m + 1):
        end = min(i, n)
        for j in range(end + 1):
            a_char = a[i - 1]
            if j == 0:
                if a_char.islower():
                    valid[i][j] = valid[i - 1][j]
            else:
                b_char = b[j - 1]
                if a_char == b_char:
                    valid[i][j] = valid[i - 1][j - 1]
                elif a_char.upper() == b_char:
                    valid[i][j] = valid[i - 1][j - 1] | valid[i - 1][j]
                elif a_char.islower():
                    valid[i][j] = valid[i - 1][j]

    if valid[m][n]:
        return "YES"
    return "NO"


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        a = input()

        b = input()

        result = abbreviation(a, b)

        fptr.write(result + '\n')

    fptr.close()
