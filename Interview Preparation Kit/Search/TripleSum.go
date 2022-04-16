// https://www.hackerrank.com/challenges/triple-sum/problem
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

// Complete the triplets function below.
func triplets(a []int32, b []int32, c []int32) int64 {
    sort.Slice(a, func(i, j int) bool {
        return a[i] < a[j]
    })
    sort.Slice(b, func(i, j int) bool {
        return b[i] < b[j]
    })
    sort.Slice(c, func(i, j int) bool {
        return c[i] < c[j]
    })

    a_set, b_set, c_set := make([]int32, 0), make([]int32, 0), make([]int32, 0)
    a_set = append(a_set, a[0])
    b_set = append(b_set, b[0])
    c_set = append(c_set, c[0])

    len_a, len_b, len_c := len(a), len(b), len(c)

    for i := 1; i < len_a; i++ {
        if a[i] != a[i-1] {
            a_set = append(a_set, a[i])
        }
    }

    for j := 1; j < len_b; j++ {
        if b[j] != b[j-1] {
            b_set = append(b_set, b[j])
        }
    }

    for k := 1; k < len_c; k++ {
        if c[k] != c[k-1] {
            c_set = append(c_set, c[k])
        }
    }

    a_size, b_size, c_size := len(a_set), len(b_set), len(c_set)

    triplets := int64(0)
    a_index, c_index := 0, 0
    for m := 0; m < b_size; m++ {
        for a_index < a_size && a_set[a_index] <= b_set[m] {
            a_index++
        }
        for c_index < c_size && c_set[c_index] <= b_set[m] {
            c_index++
        }

        triplets += int64(a_index) * int64(c_index)
    }

    return triplets
}

func main() {
    reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

    stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
    checkError(err)

    defer stdout.Close()

    writer := bufio.NewWriterSize(stdout, 1024*1024)

    lenaLenbLenc := strings.Split(readLine(reader), " ")

    lenaTemp, err := strconv.ParseInt(lenaLenbLenc[0], 10, 64)
    checkError(err)
    lena := int32(lenaTemp)

    lenbTemp, err := strconv.ParseInt(lenaLenbLenc[1], 10, 64)
    checkError(err)
    lenb := int32(lenbTemp)

    lencTemp, err := strconv.ParseInt(lenaLenbLenc[2], 10, 64)
    checkError(err)
    lenc := int32(lencTemp)

    arraTemp := strings.Split(readLine(reader), " ")

    var arra []int32

    for i := 0; i < int(lena); i++ {
        arraItemTemp, err := strconv.ParseInt(arraTemp[i], 10, 64)
        checkError(err)
        arraItem := int32(arraItemTemp)
        arra = append(arra, arraItem)
    }

    arrbTemp := strings.Split(readLine(reader), " ")

    var arrb []int32

    for i := 0; i < int(lenb); i++ {
        arrbItemTemp, err := strconv.ParseInt(arrbTemp[i], 10, 64)
        checkError(err)
        arrbItem := int32(arrbItemTemp)
        arrb = append(arrb, arrbItem)
    }

    arrcTemp := strings.Split(readLine(reader), " ")

    var arrc []int32

    for i := 0; i < int(lenc); i++ {
        arrcItemTemp, err := strconv.ParseInt(arrcTemp[i], 10, 64)
        checkError(err)
        arrcItem := int32(arrcItemTemp)
        arrc = append(arrc, arrcItem)
    }

    ans := triplets(arra, arrb, arrc)

    fmt.Fprintf(writer, "%d\n", ans)

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
