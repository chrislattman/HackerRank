#!/bin/python3
# https://www.hackerrank.com/challenges/sock-merchant/problem
import math
import os
import random
import re
import sys

# Complete the sockMerchant function below.
def sockMerchant(n, ar):
    socks = set()
    pairs = 0

    for i in range(n):
        if ar[i] in socks:
            socks.remove(ar[i])
            pairs += 1
        else:
            socks.add(ar[i])
    
    return pairs

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    ar = list(map(int, input().rstrip().split()))

    result = sockMerchant(n, ar)

    fptr.write(str(result) + '\n')

    fptr.close()
