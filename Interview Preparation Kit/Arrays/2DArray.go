// https://www.hackerrank.com/challenges/2d-array/problem
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
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */
func hourglassSum(arr [][]int32) int32 {
	max := int32(math.MinInt32)

	for i := 0; i < 16; i++ {
		quotient := i / 4
		remainder := i % 4

		first := arr[quotient][remainder]
		second := arr[quotient][remainder+1]
		third := arr[quotient][remainder+2]
		fourth := arr[quotient+1][remainder+1]
		fifth := arr[quotient+2][remainder]
		sixth := arr[quotient+2][remainder+1]
		seventh := arr[quotient+2][remainder+2]

		sum := first + second + third + fourth + fifth + sixth + seventh
		max = int32(math.Max(float64(sum), float64(max)))
	}

	return max
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 16*1024*1024)

	var arr [][]int32
	for i := 0; i < 6; i++ {
		arrRowTemp := strings.Split(strings.TrimRight(readLine(reader), " \t\r\n"), " ")

		var arrRow []int32
		for _, arrRowItem := range arrRowTemp {
			arrItemTemp, err := strconv.ParseInt(arrRowItem, 10, 64)
			checkError(err)
			arrItem := int32(arrItemTemp)
			arrRow = append(arrRow, arrItem)
		}

		if len(arrRow) != 6 {
			panic("Bad input")
		}

		arr = append(arr, arrRow)
	}

	result := hourglassSum(arr)

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
