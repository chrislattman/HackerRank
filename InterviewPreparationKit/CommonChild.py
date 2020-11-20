#!/bin/python3
# https://www.hackerrank.com/challenges/common-child/problem
import math
import os
import random
import re
import sys

# Complete the commonChild function below.
def commonChild(s1, s2):
    m = len(s1)
    n = len(s2)
    lcs = [[0] * (n + 1) for _ in range(m + 1)]
    
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0:
                lcs[i][j] = 0
            elif s1[i - 1] == s2[j - 1]:
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            else:
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
                
    return lcs[m][n]


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s1 = input()

    s2 = input()

    result = commonChild(s1, s2)

    fptr.write(str(result) + '\n')

    fptr.close()
