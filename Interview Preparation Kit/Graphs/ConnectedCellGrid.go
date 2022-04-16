// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
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

func search(grid [][]int32, grid_rows, grid_cols, x, y int) int32 {
    if x >= 0 && y >= 0 && x < grid_rows && y < grid_cols && grid[x][y] == 1 {
        grid[x][y] = 0
        return 1 + search(grid, grid_rows, grid_cols, x-1, y) +
            search(grid, grid_rows, grid_cols, x+1, y) +
            search(grid, grid_rows, grid_cols, x, y-1) +
            search(grid, grid_rows, grid_cols, x, y+1) +
            search(grid, grid_rows, grid_cols, x-1, y-1) +
            search(grid, grid_rows, grid_cols, x+1, y-1) +
            search(grid, grid_rows, grid_cols, x-1, y+1) +
            search(grid, grid_rows, grid_cols, x+1, y+1)
    }
    return 0
}

/*
 * Complete the 'maxRegion' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY grid as parameter.
 */
func maxRegion(grid [][]int32) int32 {
    largest := int32(0)

    grid_rows, grid_cols := len(grid), len(grid[0])
    for x := 0; x < grid_rows; x++ {
        for y := 0; y < grid_cols; y++ {
            if grid[x][y] == 1 {
                current := search(grid, grid_rows, grid_cols, x, y)
                largest = int32(math.Max(float64(current), float64(largest)))
            }
        }
    }

    return largest
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

    mTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
    checkError(err)
    m := int32(mTemp)

    var grid [][]int32
    for i := 0; i < int(n); i++ {
        gridRowTemp := strings.Split(strings.TrimRight(readLine(reader), " \t\r\n"), " ")

        var gridRow []int32
        for _, gridRowItem := range gridRowTemp {
            gridItemTemp, err := strconv.ParseInt(gridRowItem, 10, 64)
            checkError(err)
            gridItem := int32(gridItemTemp)
            gridRow = append(gridRow, gridItem)
        }

        if len(gridRow) != int(m) {
            panic("Bad input")
        }

        grid = append(grid, gridRow)
    }

    res := maxRegion(grid)

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
