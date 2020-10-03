# https://www.hackerrank.com/challenges/maximize-it/problem
from itertools import product

k_and_m = [int(num) for num in input().split()]
k = k_and_m[0]
m = k_and_m[1]

lists = []
max_value = 0

for k in range(k):
    array = [int(num) for num in input().split()]
    lists.append(array[1:])

combinations = list(product(*lists))

for combo in combinations:
    curr = sum([x ** 2 for x in combo]) % m
    if curr > max_value:
        max_value = curr

print(max_value)
