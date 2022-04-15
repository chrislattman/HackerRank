// https://www.hackerrank.com/challenges/sorting-array-of-strings

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int lexicographic_sort(const char* a, const char* b) {
    return strcmp(a, b);
}

int lexicographic_sort_reverse(const char* a, const char* b) {
    return -1 * strcmp(a, b);
}

int sort_by_number_of_distinct_characters(const char* a, const char* b) {
    int acount, bcount;

    acount = 0;
    bcount = 0;
    for (int i = 97; i < 123; i++) {
        if (strchr(a, i) != NULL) {
            acount++;
        }
        if (strchr(b, i) != NULL) {
            bcount++;
        }
    }
    if (acount != bcount) {
        return acount > bcount;
    }
    return strcmp(a, b);
}

int sort_by_length(const char* a, const char* b) {
    if (strlen(a) != strlen(b)) {
        return strlen(a) > strlen(b);
    }
    return strcmp(a, b);
}

void string_sort(char** arr, const int len, int (*cmp_func)(const char*, const char*)) {
    int i, j;
    char * temp;

    for (i = 0; i < len - 1; i++) {
        for (j = i; j < len - 1; j++) {
            if (cmp_func(*(arr + i), *(arr + j + 1)) > 0) {
                temp = *(arr + j + 1);
                *(arr + j + 1) = *(arr + i);
                *(arr + i) = temp;
            }
        }
    }
}

int main(void) {
    int n;
    scanf("%d", &n);

    char** arr;
	arr = (char**)malloc(n * sizeof(char*));

    for(int i = 0; i < n; i++){
        *(arr + i) = malloc(1024 * sizeof(char));
        scanf("%s", *(arr + i));
        *(arr + i) = realloc(*(arr + i), strlen(*(arr + i)) + 1);
    }

    string_sort(arr, n, lexicographic_sort);
    for(int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");

    string_sort(arr, n, lexicographic_sort_reverse);
    for(int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");

    string_sort(arr, n, sort_by_length);
    for(int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");

    string_sort(arr, n, sort_by_number_of_distinct_characters);
    for(int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");
}
