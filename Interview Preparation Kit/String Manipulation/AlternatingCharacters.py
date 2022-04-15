#!/bin/python3
# https://www.hackerrank.com/challenges/alternating-characters/problem
import math
import os
import random
import re
import sys

# Complete the alternatingCharacters function below.
def alternatingCharacters(s):
    last = s[0]
    builder = [last]

    s_len = len(s)
    for i in range(1, s_len):
        current = s[i]
        if current != last:
            builder.append(current)
            last = current

    return s_len - len(builder)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        s = input()

        result = alternatingCharacters(s)

        fptr.write(str(result) + '\n')

    fptr.close()
