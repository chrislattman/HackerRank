# https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
def fibonacci(n):
    if n < 2:
        return n

    return fibonacci(n - 1) + fibonacci(n - 2)


n = int(input())
print(fibonacci(n))