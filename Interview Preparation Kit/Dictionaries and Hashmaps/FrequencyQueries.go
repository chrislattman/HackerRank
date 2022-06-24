// https://www.hackerrank.com/challenges/frequency-queries/problem
package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// Complete the freqQuery function below.
func freqQuery(queries [][]int32) []int32 {
	output := make([]int32, 0)
	dict, frequencies := make(map[int32]int32), make(map[int32]int32)

	for _, current := range queries {
		queryType := current[0]
		data := current[1]

		if queryType == 1 {
			first_val, exists1 := dict[data]
			if exists1 {
				dict[data]++
				frequencies[first_val]--

				_, exists2 := frequencies[first_val+1]
				if exists2 {
					frequencies[first_val+1]++
				} else {
					frequencies[first_val+1] = 1
				}
			} else {
				dict[data] = 1
				_, exists3 := frequencies[1]
				if exists3 {
					frequencies[1]++
				} else {
					frequencies[1] = 1
				}
			}
		} else if queryType == 2 {
			first_val, exists1 := dict[data]
			if exists1 && first_val > 1 {
				dict[data]--
				frequencies[first_val]--

				_, exists2 := frequencies[first_val-1]
				if exists2 {
					frequencies[first_val-1]++
				} else {
					frequencies[first_val-1] = 1
				}
			} else if exists1 {
				delete(dict, data)
				_, exists3 := frequencies[1]
				if exists3 {
					frequencies[1]--
				}
			}
		} else {
			val, exists := frequencies[data]
			if exists && val > 0 {
				output = append(output, 1)
			} else {
				output = append(output, 0)
			}
		}
	}

	return output
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

	var queries [][]int32
	for i := 0; i < int(q); i++ {
		queriesRowTemp := strings.Split(strings.TrimRight(readLine(reader), " \t\r\n"), " ")

		var queriesRow []int32
		for _, queriesRowItem := range queriesRowTemp {
			queriesItemTemp, err := strconv.ParseInt(queriesRowItem, 10, 64)
			checkError(err)
			queriesItem := int32(queriesItemTemp)
			queriesRow = append(queriesRow, queriesItem)
		}

		if len(queriesRow) != 2 {
			panic("Bad input")
		}

		queries = append(queries, queriesRow)
	}

	ans := freqQuery(queries)

	for i, ansItem := range ans {
		fmt.Fprintf(writer, "%d", ansItem)

		if i != len(ans)-1 {
			fmt.Fprintf(writer, "\n")
		}
	}

	fmt.Fprintf(writer, "\n")

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
