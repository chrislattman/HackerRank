# https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
def fibonacci(n):
    if n < 2:
        return n

    a = 1
    b = 1

    for i in range(2, n):
        current = a + b
        a = b
        b = current
    
    return b


n = int(input())
print(fibonacci(n))
