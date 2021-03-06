#!/bin/python3
# https://www.hackerrank.com/challenges/ctci-ransom-note/problem
import math
import os
import random
import re
import sys

# Complete the checkMagazine function below.
def checkMagazine(magazine, note):
    wordCounts = {}
    no = False

    for i in range(len(magazine)):
        word = magazine[i]
        if word in wordCounts:
            wordCounts[word] = wordCounts[word] + 1
        else:
            wordCounts[word] = 1

    for j in range(len(note)):
        word = note[j]
        if word in wordCounts and wordCounts[word] > 0:
            wordCounts[word] = wordCounts[word] - 1
        else:
            print('No')
            no = True
            break

    if not no:
        print('Yes')

if __name__ == '__main__':
    mn = input().split()

    m = int(mn[0])

    n = int(mn[1])

    magazine = input().rstrip().split()

    note = input().rstrip().split()

    checkMagazine(magazine, note)
