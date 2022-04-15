// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
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
 * Complete the 'isValid' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */
func isValid(s string) string {
	if len(s) < 2 {
		return "YES"
	}

	dict := make(map[rune]int)

	for _, current := range s {
		_, exists := dict[current]
		if exists {
			dict[current]++
		} else {
			dict[current] = 1
		}
	}

	highestFrequency := math.MinInt32
	lowestFrequency := math.MaxInt32
	highestFrequencyCount, lowestFrequencyCount := 0, 0

	for _, value := range dict {
		if value > highestFrequency {
			highestFrequency = value
			highestFrequencyCount = 1
		} else if value == highestFrequency {
			highestFrequencyCount++
		}

		if value < lowestFrequency {
			lowestFrequency = value
			lowestFrequencyCount = 1
		} else if value == lowestFrequency {
			lowestFrequencyCount++
		}
	}

	if highestFrequency == lowestFrequency {
		return "YES"
	}
	if highestFrequency*highestFrequencyCount == len(s)-1 &&
		lowestFrequency == 1 {
		return "YES"
	}
	if lowestFrequency*lowestFrequencyCount+highestFrequency == len(s) &&
		highestFrequency-1 == lowestFrequency {
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

	s := readLine(reader)

	result := isValid(s)

	fmt.Fprintf(writer, "%s\n", result)

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
