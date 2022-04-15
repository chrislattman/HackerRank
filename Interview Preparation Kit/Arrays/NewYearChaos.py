#!/bin/python3
# https://www.hackerrank.com/challenges/new-year-chaos/problem
import math
import os
import random
import re
import sys

# Complete the minimumBribes function below.
def minimumBribes(q):
    swaps = 0
    index = 0
    lastSortedIndex = -1
    too_chaotic = False
    bribeMap = {}

    stop = len(q) - 1
    while index < stop:
        current = q[index]
        if current > q[index + 1]:
            if current in bribeMap and bribeMap[current] >= 2:
                print("Too chaotic")
                too_chaotic = True
                break
            if current not in bribeMap:
                bribeMap[current] = 0
            bribeMap[current] += 1

            q[index], q[index + 1] = q[index + 1], q[index]

            swaps = swaps + 1
            index = lastSortedIndex
        elif current == index + 1:
            lastSortedIndex = lastSortedIndex + 1
        index = index + 1

    if not too_chaotic:
        print(swaps)


if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        n = int(input())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
