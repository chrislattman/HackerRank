// https://www.hackerrank.com/challenges/luck-balance/problem
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

int compare(const void *a, const void *b) {
    int arg1 = *(const int*) a;
    int arg2 = *(const int*) b;
 
    if (arg1 < arg2) {
        return -1;
    }
    if (arg1 > arg2) {
        return 1;
    }
    
    return 0;
}

// Complete the luckBalance function below.
int luckBalance(int k, int contests_rows, int contests_columns, int** contests) {
    int balance = 0;
    int* important = (int*) malloc(sizeof(int) * contests_rows);
    int importantIndex = 0;

    for (int i = 0; i < contests_rows; i++) {
        if (contests[i][1] == 0) {
            balance += contests[i][0];
        }
        else {
            important[importantIndex++] = contests[i][0];
        }
    }

    qsort(important, importantIndex, sizeof(int), compare);

    if (importantIndex > k) {
        for (int j = importantIndex - k; j < importantIndex; j++) {
            balance += important[j];
        }
        
        for (int m = 0; m < importantIndex - k; m++) {
            balance -= important[m];
        }
    }
    else {
        for (int p = 0; p < importantIndex; p++) {
            balance += important[p];
        }
    }

    return balance;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char** nk = split_string(readline());

    char* n_endptr;
    char* n_str = nk[0];
    int n = strtol(n_str, &n_endptr, 10);

    if (n_endptr == n_str || *n_endptr != '\0') { exit(EXIT_FAILURE); }

    char* k_endptr;
    char* k_str = nk[1];
    int k = strtol(k_str, &k_endptr, 10);

    if (k_endptr == k_str || *k_endptr != '\0') { exit(EXIT_FAILURE); }

    int** contests = malloc(n * sizeof(int*));

    for (int i = 0; i < n; i++) {
        *(contests + i) = malloc(2 * (sizeof(int)));

        char** contests_item_temp = split_string(readline());

        for (int j = 0; j < 2; j++) {
            char* contests_item_endptr;
            char* contests_item_str = *(contests_item_temp + j);
            int contests_item = strtol(contests_item_str, &contests_item_endptr, 10);

            if (contests_item_endptr == contests_item_str || *contests_item_endptr != '\0') { exit(EXIT_FAILURE); }

            *(*(contests + i) + j) = contests_item;
        }
    }

    int contests_rows = n;
    int contests_columns = 2;

    int result = luckBalance(k, contests_rows, contests_columns, contests);

    fprintf(fptr, "%d\n", result);

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
