# https://www.hackerrank.com/challenges/no-idea/problem

n_and_m = [int(x) for x in input().split()]
array = [int(x) for x in input().split()]
list_A = set([int(x) for x in input().split()])
list_B = set([int(x) for x in input().split()])

n = n_and_m[0]
happiness = 0

for i in range(n):
    if array[i] in list_A:
        happiness = happiness + 1
    if array[i] in list_B:
        happiness = happiness - 1

print(happiness)
