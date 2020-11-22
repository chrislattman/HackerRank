#!/bin/python3
# https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
import math
import os
import random
import re
import sys

# Complete the isValid function below.
def isValid(s):
    if len(s) < 2:
        return "YES"

    hashtable = {}
    
    for i in range(len(s)):
        current = s[i]
        if current in hashtable:
            hashtable[current] += 1
        else:
            hashtable[current] = 1

    highestFrequency = float('-inf')
    lowestFrequency = float('inf')
    highestFrequencyCount = 0
    lowestFrequencyCount = 0

    iterator = hashtable.values()
    for value in iterator:
        if value > highestFrequency:
            highestFrequency = value
            highestFrequencyCount = 1
        elif value == highestFrequency:
            highestFrequencyCount += 1

        if value < lowestFrequency:
            lowestFrequency = value
            lowestFrequencyCount = 1
        elif value == lowestFrequency:
            lowestFrequencyCount += 1

    if highestFrequency == lowestFrequency:
        return "YES"
    if highestFrequency * highestFrequencyCount == len(s) - 1 and lowestFrequency == 1:
        return "YES"
    if (lowestFrequency * lowestFrequencyCount + highestFrequency == len(s) and
        highestFrequency - 1 == lowestFrequency):
        return "YES"

    return "NO"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = isValid(s)

    fptr.write(result + '\n')

    fptr.close()
