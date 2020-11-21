// https://www.hackerrank.com/challenges/triple-sum/problem
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
    else if (arg1 > arg2) {
        return 1;
    }
    else {
        return 0;
    }
}

// Complete the triplets function below.
long triplets(int a_count, int* a, int b_count, int* b, int c_count, int* c) {
    qsort(a, a_count, sizeof(int), compare);
    qsort(b, b_count, sizeof(int), compare);
    qsort(c, c_count, sizeof(int), compare);

    int* a_set = malloc(sizeof(int) * a_count);
    int* b_set = malloc(sizeof(int) * b_count);
    int* c_set = malloc(sizeof(int) * c_count);
    a_set[0] = a[0];
    b_set[0] = b[0];
    c_set[0] = c[0];
    int a_size = 1;
    int b_size = 1;
    int c_size = 1;

    for (int i = 1; i < a_count; i++) {
        if (a[i] != a[i - 1]) {
            a_set[a_size++] = a[i];
        }
    }

    for (int j = 1; j < b_count; j++) {
        if (b[j] != b[j - 1]) {
            b_set[b_size++] = b[j];
        }
    }

    for (int k = 1; k < c_count; k++) {
        if (c[k] != c[k - 1]) {
            c_set[c_size++] = c[k];
        }
    }

    long triplets = 0;
    int a_index = 0;
    int c_index = 0;
    for (int m = 0; m < b_size; m++) {
        while (a_index < a_size && a_set[a_index] <= b_set[m]) {
            a_index++;
        }
        while (c_index < c_size && c_set[c_index] <= b_set[m]) {
            c_index++;
        }

        triplets += (long) a_index * (long) c_index;
    }

    free(a_set);
    free(b_set);
    free(c_set);

    return triplets;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char** lenaLenbLenc = split_string(readline());

    char* lena_endptr;
    char* lena_str = lenaLenbLenc[0];
    int lena = strtol(lena_str, &lena_endptr, 10);

    if (lena_endptr == lena_str || *lena_endptr != '\0') { exit(EXIT_FAILURE); }

    char* lenb_endptr;
    char* lenb_str = lenaLenbLenc[1];
    int lenb = strtol(lenb_str, &lenb_endptr, 10);

    if (lenb_endptr == lenb_str || *lenb_endptr != '\0') { exit(EXIT_FAILURE); }

    char* lenc_endptr;
    char* lenc_str = lenaLenbLenc[2];
    int lenc = strtol(lenc_str, &lenc_endptr, 10);

    if (lenc_endptr == lenc_str || *lenc_endptr != '\0') { exit(EXIT_FAILURE); }

    char** arra_temp = split_string(readline());

    int* arra = malloc(lena * sizeof(int));

    for (int i = 0; i < lena; i++) {
        char* arra_item_endptr;
        char* arra_item_str = *(arra_temp + i);
        int arra_item = strtol(arra_item_str, &arra_item_endptr, 10);

        if (arra_item_endptr == arra_item_str || *arra_item_endptr != '\0') { exit(EXIT_FAILURE); }

        *(arra + i) = arra_item;
    }

    int arra_count = lena;

    char** arrb_temp = split_string(readline());

    int* arrb = malloc(lenb * sizeof(int));

    for (int i = 0; i < lenb; i++) {
        char* arrb_item_endptr;
        char* arrb_item_str = *(arrb_temp + i);
        int arrb_item = strtol(arrb_item_str, &arrb_item_endptr, 10);

        if (arrb_item_endptr == arrb_item_str || *arrb_item_endptr != '\0') { exit(EXIT_FAILURE); }

        *(arrb + i) = arrb_item;
    }

    int arrb_count = lenb;

    char** arrc_temp = split_string(readline());

    int* arrc = malloc(lenc * sizeof(int));

    for (int i = 0; i < lenc; i++) {
        char* arrc_item_endptr;
        char* arrc_item_str = *(arrc_temp + i);
        int arrc_item = strtol(arrc_item_str, &arrc_item_endptr, 10);

        if (arrc_item_endptr == arrc_item_str || *arrc_item_endptr != '\0') { exit(EXIT_FAILURE); }

        *(arrc + i) = arrc_item;
    }

    int arrc_count = lenc;

    long ans = triplets(arra_count, arra, arrb_count, arrb, arrc_count, arrc);

    fprintf(fptr, "%ld\n", ans);

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
