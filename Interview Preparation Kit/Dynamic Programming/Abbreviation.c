// https://www.hackerrank.com/challenges/abbr/problem
#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

char* readline();

// Complete the abbreviation function below.

// Please either make the string static or allocate on the heap. For example,
// static char str[] = "hello world";
// return str;
//
// OR
//
// char* str = "hello world";
// return str;
//
char* abbreviation(char* a, char* b) {
    int m = strlen(a);
    int n = strlen(b);

    bool** valid = (bool**) malloc((m + 1) * sizeof(bool*));
    for (int i = 0; i <= m; i++) {
        valid[i] = (bool*) calloc(n + 1, sizeof(bool));
    }
    valid[0][0] = true;

    for (int i = 1; i <= m; i++) {
        int end = fmin(i, n);
        for (int j = 0; j <= end; j++) {
            char a_char = a[i - 1];

            if (j == 0) {
                if (islower(a_char)) {
                    valid[i][j] = valid[i - 1][j];
                }
            }
            else {
                char b_char = b[j - 1];

                if (a_char == b_char) {
                    valid[i][j] = valid[i - 1][j - 1];
                }
                else if (toupper(a_char) == b_char) {
                    valid[i][j] = valid[i - 1][j - 1] | valid[i - 1][j];
                }
                else if (islower(a_char)) {
                    valid[i][j] = valid[i - 1][j];
                }
            }
        }
    }

    bool result = valid[m][n];
    for (int i = 0; i <= m; i++) {
        free(valid[i]);
    }
    free(valid);

    if (result) {
        char* yes = "YES";
        return yes;
    }
    char* no = "NO";
    return no;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char* q_endptr;
    char* q_str = readline();
    int q = strtol(q_str, &q_endptr, 10);

    if (q_endptr == q_str || *q_endptr != '\0') { exit(EXIT_FAILURE); }

    for (int q_itr = 0; q_itr < q; q_itr++) {
        char* a = readline();

        char* b = readline();

        char* result = abbreviation(a, b);

        fprintf(fptr, "%s\n", result);
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
