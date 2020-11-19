// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char** split_string(char*);

int search(int** grid, int grid_rows, int grid_columns, int x, int y) {
    if (x >= 0 && y >= 0 && x < grid_rows && y < grid_columns && grid[x][y] == 1) {
        grid[x][y] = 0;
        return 1 + search(grid, grid_rows, grid_columns, x - 1, y) + 
                search(grid, grid_rows, grid_columns, x + 1, y) + 
                search(grid, grid_rows, grid_columns, x, y - 1) + 
                search(grid, grid_rows, grid_columns, x, y + 1) + 
                search(grid, grid_rows, grid_columns, x - 1, y - 1) + 
                search(grid, grid_rows, grid_columns, x + 1, y - 1) + 
                search(grid, grid_rows, grid_columns, x - 1, y + 1) + 
                search(grid, grid_rows, grid_columns, x + 1, y + 1);
    }
    return 0;
}

// Complete the maxRegion function below.
int maxRegion(int grid_rows, int grid_columns, int** grid) {
    int largest = 0;
    
    for (int x = 0; x < grid_rows; x++) {
        for (int y = 0; y < grid_columns; y++) {
            if (grid[x][y] == 1) {
                int current = search(grid, grid_rows, grid_columns, x, y);
                if (current > largest) {
                    largest = current;
                }
            }
        }
    }
    
    return largest;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char* n_endptr;
    char* n_str = readline();
    int n = strtol(n_str, &n_endptr, 10);

    if (n_endptr == n_str || *n_endptr != '\0') { exit(EXIT_FAILURE); }

    char* m_endptr;
    char* m_str = readline();
    int m = strtol(m_str, &m_endptr, 10);

    if (m_endptr == m_str || *m_endptr != '\0') { exit(EXIT_FAILURE); }

    int** grid = malloc(n * sizeof(int*));

    for (int i = 0; i < n; i++) {
        *(grid + i) = malloc(m * (sizeof(int)));

        char** grid_item_temp = split_string(readline());

        for (int j = 0; j < m; j++) {
            char* grid_item_endptr;
            char* grid_item_str = *(grid_item_temp + j);
            int grid_item = strtol(grid_item_str, &grid_item_endptr, 10);

            if (grid_item_endptr == grid_item_str || *grid_item_endptr != '\0') { exit(EXIT_FAILURE); }

            *(*(grid + i) + j) = grid_item;
        }
    }

    int grid_rows = n;
    int grid_columns = m;

    int res = maxRegion(grid_rows, grid_columns, grid);

    fprintf(fptr, "%d\n", res);

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

        if (!line) {
            break;
        }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') {
            break;
        }

        alloc_length <<= 1;

        data = realloc(data, alloc_length);

        if (!line) {
            break;
        }
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';

        data = realloc(data, data_length);
    } else {
        data = realloc(data, data_length + 1);

        data[data_length] = '\0';
    }

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
