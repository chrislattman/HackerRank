// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
package main

import "fmt"

func fibonacci(n int) int {
    if n < 2 {
        return n
    }

    a, b, current := 1, 1, 0

    for i := 2; i < n; i++ {
        current = a + b
        a = b
        b = current
    }

    return b
}

func main() {
    var n int
    fmt.Scanf("%d\n", &n)
    fmt.Println(fibonacci(n))
}
