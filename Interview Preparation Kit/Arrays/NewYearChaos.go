// https://www.hackerrank.com/challenges/new-year-chaos/problem
package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */
func minimumBribes(q []int32) {
	swaps, index, lastSortedIndex := 0, int32(0), int32(-1)
	too_chaotic := false
	bribeMap := make(map[int32]int32)

	stop := int32(len(q) - 1)
	for index < stop {
		current := q[index]
		if current > q[index+1] {
			val, exists := bribeMap[current]
			if exists && val >= 2 {
				fmt.Println("Too chaotic")
				too_chaotic = true
				break
			}
			if !exists {
				bribeMap[current] = 0
			}
			bribeMap[current]++

			q[index], q[index+1] = q[index+1], q[index]

			swaps++
			index = lastSortedIndex
		} else if current == index+1 {
			lastSortedIndex++
		}
		index++
	}

	if !too_chaotic {
		fmt.Println(swaps)
	}
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	tTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)
	t := int32(tTemp)

	for tItr := 0; tItr < int(t); tItr++ {
		nTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
		checkError(err)
		n := int32(nTemp)

		qTemp := strings.Split(strings.TrimSpace(readLine(reader)), " ")

		var q []int32

		for i := 0; i < int(n); i++ {
			qItemTemp, err := strconv.ParseInt(qTemp[i], 10, 64)
			checkError(err)
			qItem := int32(qItemTemp)
			q = append(q, qItem)
		}

		minimumBribes(q)
	}
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
