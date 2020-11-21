#!/bin/python3
# https://www.hackerrank.com/challenges/count-triplets-1/problem
import math
import os
import random
import re
import sys

# Complete the countTriplets function below.
def countTriplets(arr, r):
    first = {}
    second = {}
    triplets = 0
    
    for i in range(len(arr)):
        current = arr[i]
        if current % r == 0:
            preceding = current / r
            if preceding in second:
                triplets += second[preceding]
            if preceding in first:
                if current in second:
                    second[current] += first[preceding]
                else:
                    second[current] = first[preceding]
        
        if current in first:
            first[current] += 1
        else:
            first[current] = 1
            
    return triplets


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nr = input().rstrip().split()

    n = int(nr[0])

    r = int(nr[1])

    arr = list(map(int, input().rstrip().split()))

    ans = countTriplets(arr, r)

    fptr.write(str(ans) + '\n')

    fptr.close()
