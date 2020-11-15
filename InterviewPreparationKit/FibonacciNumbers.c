// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
#include <stdio.h>

int fibonacci(int n) {
    if (n < 2) {
        return n;
    }

    int a = 1;
    int b = 1;
    int current;

    for (int i = 2; i < n; i++) {
        current = a + b;
        a = b;
        b = current;
    }
    
    return b;
}

int main() {
    int n;
    scanf("%d", &n);
    printf("%d", fibonacci(n));
    return 0;
}
