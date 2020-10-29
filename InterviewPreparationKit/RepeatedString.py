#!/bin/python3
# https://www.hackerrank.com/challenges/repeated-string/problem
import math
import os
import random
import re
import sys

# Complete the repeatedString function below.
def repeatedString(s, n):
    stringLength = len(s)
    quotient = int(n / stringLength)
    remainder = n % stringLength

    aCount = 0
    aCountRemainder = 0
    for i in range(stringLength):
        if s[i] == 'a':
            if i < remainder:
                aCountRemainder += 1
            aCount += 1

    return aCount * quotient + aCountRemainder

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    n = int(input())

    result = repeatedString(s, n)

    fptr.write(str(result) + '\n')

    fptr.close()
