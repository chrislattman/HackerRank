// https://www.hackerrank.com/challenges/even-odd-query

#include <stdio.h>
#include <stdlib.h>

int main() {
    int N, q, x, y;

    scanf("%d", &N);
    int * arr = malloc(sizeof(int) * N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }
    scanf("%d", &q);
    for (int j = 0; j < q; j++) {
        scanf("%d", &x);
        scanf("%d", &y);
        if (x > y) {
            printf("Odd\n");
        }
        else if (x < y && arr[x] == 0) {
            printf("Odd\n");
        }
        else if (arr[x - 1] % 2 == 0) {
            printf("Even\n");
        }
        else {
            printf("Odd\n");
        }
    }

    return 0;
}
