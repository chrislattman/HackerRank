#!/bin/python3
# https://www.hackerrank.com/challenges/balanced-brackets/problem
import math
import os
import random
import re
import sys

# Complete the isBalanced function below.
def isBalanced(s):
    stack = []

    for i in range(len(s)):
        bracket = s[i]
        if bracket == '(' or bracket == '{' or bracket == '[':
            stack.append(bracket)
        else:
            if len(stack) == 0:
                return "NO"

            top = stack[-1]
            if bracket == ')' and top == '(':
                stack.pop()
            elif bracket == '}' and top == '{':
                stack.pop()
            elif bracket == ']' and top == '[':
                stack.pop()
            else:
                return "NO"

    if len(stack) == 0:
        return "YES"

    return "NO"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()
