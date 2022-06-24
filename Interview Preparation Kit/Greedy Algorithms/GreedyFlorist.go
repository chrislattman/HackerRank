// https://www.hackerrank.com/challenges/greedy-florist/problem
package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"sort"
	"strconv"
	"strings"
)

// Complete the getMinimumCost function below.
func getMinimumCost(k int32, c []int32) int32 {
	sort.Slice(c, func(i, j int) bool {
		return c[i] < c[j]
	})
	total, mod, multiplier := int32(0), int32(0), int32(1)

	for i := len(c) - 1; i >= 0; i-- {
		total += c[i] * multiplier
		mod = (mod + 1) % k
		if mod == 0 {
			multiplier++
		}
	}

	return total
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	nk := strings.Split(readLine(reader), " ")

	nTemp, err := strconv.ParseInt(nk[0], 10, 64)
	checkError(err)
	n := int32(nTemp)

	kTemp, err := strconv.ParseInt(nk[1], 10, 64)
	checkError(err)
	k := int32(kTemp)

	cTemp := strings.Split(readLine(reader), " ")

	var c []int32

	for i := 0; i < int(n); i++ {
		cItemTemp, err := strconv.ParseInt(cTemp[i], 10, 64)
		checkError(err)
		cItem := int32(cItemTemp)
		c = append(c, cItem)
	}

	minimumCost := getMinimumCost(k, c)

	fmt.Fprintf(writer, "%d\n", minimumCost)

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
