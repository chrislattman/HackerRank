// https://www.hackerrank.com/challenges/even-odd-query

#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char** split_string(char*);

FILE* fptr;

// Complete the solve function below.

// Please store the size of the string array to be returned in result_count pointer. For example,
// char a[2][6] = {"hello", "world"};
//
// *result_count = 2;
//
// return a;
//

///////------------------------/////////////

///////-------------------------/////////
int solve(int arr_count, int* arr, int queries_rows, int queries_columns, int** queries, int* result_count) {
    int a, i, x, y;
    
    *result_count = queries_rows;
    for (i = 0; i < queries_rows; i++) {
        x = **queries;
        y = *(*queries + 1);
        if (x > y) {
            fprintf(fptr, "Odd\n");
        }
        else if (x < y && arr[x] == 0) {
            fprintf(fptr, "Odd\n");
        }
        else if (arr[x - 1] % 2 == 0) {
            fprintf(fptr, "Even\n");
        }
        else {
            fprintf(fptr, "Odd\n");
        }
        queries++;
    }
    
    return 0;
}

int main()
{
    fptr = fopen(getenv("OUTPUT_PATH"), "w");
    char* arr_count_endptr;
    char* arr_count_str = readline();
    int arr_count = strtol(arr_count_str, &arr_count_endptr, 10);

    if (arr_count_endptr == arr_count_str || *arr_count_endptr != '\0') { exit(EXIT_FAILURE); }

    char** arr_temp = split_string(readline());

    int* arr = malloc(arr_count * sizeof(int));

    for (int arr_itr = 0; arr_itr < arr_count; arr_itr++) {
        char* arr_item_endptr;
        char* arr_item_str = *(arr_temp + arr_itr);
        int arr_item = strtol(arr_item_str, &arr_item_endptr, 10);

        if (arr_item_endptr == arr_item_str || *arr_item_endptr != '\0') { exit(EXIT_FAILURE); }

        *(arr + arr_itr) = arr_item;
    }

    char* q_endptr;
    char* q_str = readline();
    int q = strtol(q_str, &q_endptr, 10);

    if (q_endptr == q_str || *q_endptr != '\0') { exit(EXIT_FAILURE); }

    int** queries = malloc(q * sizeof(int*));

    for (int queries_row_itr = 0; queries_row_itr < q; queries_row_itr++) {
        *(queries + queries_row_itr) = malloc(2 * (sizeof(int)));

        char** queries_item_temp = split_string(readline());

        for (int queries_column_itr = 0; queries_column_itr < 2; queries_column_itr++) {
            char* queries_item_endptr;
            char* queries_item_str = *(queries_item_temp + queries_column_itr);
            int queries_item = strtol(queries_item_str, &queries_item_endptr, 10);

            if (queries_item_endptr == queries_item_str || *queries_item_endptr != '\0') { exit(EXIT_FAILURE); }

            *(*(queries + queries_row_itr) + queries_column_itr) = queries_item;
        }
    }

    int queries_rows = q;
    int queries_columns = 2;

    int result_count;
    solve(arr_count, arr, queries_rows, queries_columns, queries, &result_count);
    
    fclose(fptr);

    return 0;
}

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char* data = malloc(alloc_length);

    while (true) {
        char* cursor = data + data_length;
        char* line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line) { break; }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') { break; }

        size_t new_length = alloc_length << 1;
        data = realloc(data, new_length);

        if (!data) { break; }

        alloc_length = new_length;
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';
    }

    data = realloc(data, data_length);

    return data;
}

char** split_string(char* str) {
    char** splits = NULL;
    char* token = strtok(str, " ");

    int spaces = 0;

    while (token) {
        splits = realloc(splits, sizeof(char*) * ++spaces);
        if (!splits) {
            return splits;
        }

        splits[spaces - 1] = token;

        token = strtok(NULL, " ");
    }

    return splits;
}
