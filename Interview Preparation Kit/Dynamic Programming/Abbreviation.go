// https://www.hackerrank.com/challenges/abbr/problem
package main

import (
	"bufio"
	"fmt"
	"io"
	"math"
	"os"
	"strconv"
	"strings"
	"unicode"
)

/*
 * Complete the 'abbreviation' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING a
 *  2. STRING b
 */
func abbreviation(a string, b string) string {
	m, n := len(a), len(b)

	valid := make([][]bool, m+1)
	for i := 0; i <= m; i++ {
		valid[i] = make([]bool, n+1)
	}
	valid[0][0] = true

	for i := 1; i <= m; i++ {
		end := int(math.Min(float64(i), float64(n)))
		for j := 0; j <= end; j++ {
			a_char := rune(a[i-1])

			if j == 0 {
				if unicode.IsLower(a_char) {
					valid[i][j] = valid[i-1][j]
				}
			} else {
				b_char := rune(b[j-1])

				if a_char == b_char {
					valid[i][j] = valid[i-1][j-1]
				} else if unicode.ToUpper(a_char) == b_char {
					valid[i][j] = valid[i-1][j-1] || valid[i-1][j]
				} else if unicode.IsLower(a_char) {
					valid[i][j] = valid[i-1][j]
				}
			}
		}
	}

	if valid[m][n] {
		return "YES"
	}
	return "NO"
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 16*1024*1024)

	qTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)
	q := int32(qTemp)

	for qItr := 0; qItr < int(q); qItr++ {
		a := readLine(reader)

		b := readLine(reader)

		result := abbreviation(a, b)

		fmt.Fprintf(writer, "%s\n", result)
	}

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
