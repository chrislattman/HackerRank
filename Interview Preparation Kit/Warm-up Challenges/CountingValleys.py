#!/bin/python3
# https://www.hackerrank.com/challenges/counting-valleys/problem
import math
import os
import random
import re
import sys

#
# Complete the 'countingValleys' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER steps
#  2. STRING path
#

def countingValleys(steps, path):
    altitude = 0
    valleys = 0
    inValley = False

    for i in range(steps):
        if path[i] == 'U':
            altitude += 1
        else:
            altitude -= 1

        if altitude < 0:
            inValley = True
        elif inValley:
            valleys += 1
            inValley = False

    return valleys

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    steps = int(input().strip())

    path = input()

    result = countingValleys(steps, path)

    fptr.write(str(result) + '\n')

    fptr.close()
