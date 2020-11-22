#!/bin/python3
# https://www.hackerrank.com/challenges/minimum-swaps-2/problem
import math
import os
import random
import re
import sys

# Complete the minimumSwaps function below.
def minimumSwaps(arr):
    swaps = 0
    index = 0
    current_value = 1
    
    while current_value < len(arr):
        arr_value = arr[index]
        while arr_value != current_value:
            index = index + 1
            arr_value = arr[index]
        if arr_value != index + 1:
            arr[index] = arr[arr_value - 1]
            arr[arr_value - 1] = arr_value
            swaps = swaps + 1
        current_value = current_value + 1
        index = arr_value
    
    return swaps


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    res = minimumSwaps(arr)

    fptr.write(str(res) + '\n')

    fptr.close()
