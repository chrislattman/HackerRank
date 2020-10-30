#!/bin/python3
# https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
import math
import os
import random
import re
import sys

# Complete the whatFlavors function below.
def whatFlavors(cost, money):
    prices = {}

    for i in range(len(cost)):
        prices[cost[i]] = i

    for j in range(len(cost)):
        first_price = cost[j]
        second_price = money - cost[j]
        if second_price in prices and prices[second_price] != j:
            first_index = j + 1
            second_index = prices[second_price] + 1
            print(str(first_index) + " " + str(second_index))
            break
        

if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        money = int(input())

        n = int(input())

        cost = list(map(int, input().rstrip().split()))

        whatFlavors(cost, money)
