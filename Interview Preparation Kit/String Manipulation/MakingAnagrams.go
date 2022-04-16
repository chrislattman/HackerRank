// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
package main

import (
    "bufio"
    "fmt"
    "io"
    "math"
    "os"
    "strings"
)

/*
 * Complete the 'makeAnagram' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING a
 *  2. STRING b
 */
func makeAnagram(a string, b string) int32 {
    a_map, b_map := make(map[rune]int32), make(map[rune]int32)

    for _, letter := range a {
        _, exists := a_map[letter]
        if exists {
            a_map[letter]++
        } else {
            a_map[letter] = 1
        }
    }

    for _, letter := range b {
        _, exists := b_map[letter]
        if exists {
            b_map[letter]++
        } else {
            b_map[letter] = 1
        }
    }

    removed := int32(0)
    for key := 'a'; key <= 'z'; key++ {
        a_val, a_exists := a_map[key]
        b_val, b_exists := b_map[key]
        if a_exists && b_exists {
            removed += int32(math.Abs(float64(a_val - b_val)))
        } else if a_exists {
            removed += a_val
        } else if b_exists {
            removed += b_val
        }
    }

    return removed
}

func main() {
    reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

    stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
    checkError(err)

    defer stdout.Close()

    writer := bufio.NewWriterSize(stdout, 16*1024*1024)

    a := readLine(reader)

    b := readLine(reader)

    res := makeAnagram(a, b)

    fmt.Fprintf(writer, "%d\n", res)

    writer.Flush()
}

func readLine(reader *bufio.Reader) string {
    str, _, err := reader.ReadLine()
    if err == io.EOF {
        return ""
    }

    return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
    if err != nil {
        panic(err)
    }
}
