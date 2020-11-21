#!/bin/python3
# https://www.hackerrank.com/challenges/triple-sum/problem
import math
import os
import random
import re
import sys

# Complete the triplets function below.
def triplets(a, b, c):
    a.sort()
    b.sort()
    c.sort()

    a_set = []
    b_set = []
    c_set = []
    a_set.append(a[0])
    b_set.append(b[0])
    c_set.append(c[0])

    for i in range(1, len(a)):
        if a[i] != a[i - 1]:
            a_set.append(a[i])

    for j in range(1, len(b)):
        if b[j] != b[j - 1]:
            b_set.append(b[j])

    for k in range(1, len(c)):
        if c[k] != c[k - 1]:
            c_set.append(c[k])

    a_size = len(a_set)
    b_size = len(b_set)
    c_size = len(c_set)

    triplets = 0
    a_index = 0
    c_index = 0
    for m in range(b_size):
        while a_index < a_size and a_set[a_index] <= b_set[m]:
            a_index += 1

        while c_index < c_size and c_set[c_index] <= b_set[m]:
            c_index += 1

        triplets += a_index * c_index

    return triplets


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    lenaLenbLenc = input().split()

    lena = int(lenaLenbLenc[0])

    lenb = int(lenaLenbLenc[1])

    lenc = int(lenaLenbLenc[2])

    arra = list(map(int, input().rstrip().split()))

    arrb = list(map(int, input().rstrip().split()))

    arrc = list(map(int, input().rstrip().split()))

    ans = triplets(arra, arrb, arrc)

    fptr.write(str(ans) + '\n')

    fptr.close()
