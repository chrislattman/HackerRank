// https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
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

// Complete the stepPerms function below.
int stepPerms(int n) {
    if (n < 3) {
        return n;
    }

    int* vec = malloc(3 * sizeof(int));
    vec[0] = 1;
    vec[1] = 2;
    vec[2] = 4;
    int current;

    for (int i = 3; i < n; i++) {
        current = vec[2] + vec[1] + vec[0];
        vec[0] = vec[1];
        vec[1] = vec[2];
        vec[2] = current;
    }
    
    int result = vec[2];
    free(vec);
    
    return result;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char* s_endptr;
    char* s_str = readline();
    int s = strtol(s_str, &s_endptr, 10);

    if (s_endptr == s_str || *s_endptr != '\0') { exit(EXIT_FAILURE); }

    for (int s_itr = 0; s_itr < s; s_itr++) {
        char* n_endptr;
        char* n_str = readline();
        int n = strtol(n_str, &n_endptr, 10);

        if (n_endptr == n_str || *n_endptr != '\0') { exit(EXIT_FAILURE); }

        int res = stepPerms(n);

        fprintf(fptr, "%d\n", res);
    }

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
