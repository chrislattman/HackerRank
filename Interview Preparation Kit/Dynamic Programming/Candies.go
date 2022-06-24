// https://www.hackerrank.com/challenges/candies/problem
package main

import (
	"bufio"
	"fmt"
	"io"
	"math"
	"os"
	"strconv"
	"strings"
)

/*
 * Complete the 'candies' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY arr
 */
func candies(n int32, arr []int32) int64 {
	up, down := make([]int, n), make([]int, n)
	up[0] = 1
	down[n-1] = 1
	result := int64(0)

	for i := int32(1); i < n; i++ {
		if arr[i] > arr[i-1] {
			up[i] = up[i-1] + 1
		} else {
			up[i] = 1
		}
	}
	for j := n - 2; j >= 0; j-- {
		if arr[j] > arr[j+1] {
			down[j] = down[j+1] + 1
		} else {
			down[j] = 1
		}
	}
	for k := int32(0); k < n; k++ {
		result += int64(math.Max(float64(up[k]), float64(down[k])))
	}

	return result
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 16*1024*1024)

	nTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)
	n := int32(nTemp)

	var arr []int32

	for i := 0; i < int(n); i++ {
		arrItemTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
		checkError(err)
		arrItem := int32(arrItemTemp)
		arr = append(arr, arrItem)
	}

	result := candies(n, arr)

	fmt.Fprintf(writer, "%d\n", result)

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
