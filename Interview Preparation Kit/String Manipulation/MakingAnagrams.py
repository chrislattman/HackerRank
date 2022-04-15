#!/bin/python3
# https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
import math
import os
import random
import re
import sys
import string

# Complete the makeAnagram function below.
def makeAnagram(a, b):
    a_map = {}
    b_map = {}

    a_len = len(a)
    for i in range(a_len):
        letter = a[i]
        if letter in a_map:
            a_map[letter] += 1
        else:
            a_map[letter] = 1

    b_len = len(b)
    for j in range(b_len):
        letter = b[j]
        if letter in b_map:
            b_map[letter] += 1
        else:
            b_map[letter] = 1

    removed = 0
    for key in string.ascii_lowercase:
        if key in a_map and key in b_map:
            removed += abs(a_map[key] - b_map[key])
        elif key in a_map:
            removed += a_map[key]
        elif key in b_map:
            removed += b_map[key]

    return removed


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a = input()

    b = input()

    res = makeAnagram(a, b)

    fptr.write(str(res) + '\n')

    fptr.close()
