#!/bin/python3
# https://www.hackerrank.com/challenges/frequency-queries/problem
import math
import os
import random
import re
import sys

# Complete the freqQuery function below.
def freqQuery(queries):
    output = []
    hashmap = {}
    frequencies = {}

    for i in range(len(queries)):
        queryType = queries[i][0]
        data = queries[i][1]

        if queryType == 1:
            if data in hashmap:
                old_frequency_key = hashmap[data]
                new_frequency_key = old_frequency_key + 1
                hashmap[data] = new_frequency_key
                frequencies[old_frequency_key] -= 1

                if new_frequency_key in frequencies:
                    frequencies[new_frequency_key] += 1
                else:
                    frequencies[new_frequency_key] = 1
            else:
                hashmap[data] = 1
                if 1 in frequencies:
                    frequencies[1] += 1
                else:
                    frequencies[1] = 1
        elif queryType == 2:
            if data in hashmap and hashmap[data] > 1:
                old_frequency_key = hashmap[data]
                new_frequency_key = old_frequency_key - 1
                hashmap[data] = new_frequency_key
                frequencies[old_frequency_key] -= 1

                if new_frequency_key in frequencies:
                    frequencies[new_frequency_key] += 1
                else:
                    frequencies[new_frequency_key] = 1
            elif data in hashmap:
                del hashmap[data]
                if 1 in frequencies:
                    frequencies[1] -= 1
        else:
            if data in frequencies and frequencies[data] > 0:
                output.append(1)
            else:
                output.append(0)

    return output


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    queries = []

    for _ in range(q):
        queries.append(list(map(int, input().rstrip().split())))

    ans = freqQuery(queries)

    fptr.write('\n'.join(map(str, ans)))
    fptr.write('\n')

    fptr.close()
