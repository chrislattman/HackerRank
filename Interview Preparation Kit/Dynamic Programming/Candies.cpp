// https://www.hackerrank.com/challenges/candies/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the candies function below.
long candies(int n, vector<int> arr) {
    vector<int> up(n);
    vector<int> down(n);
    up[0] = 1;
    down[n - 1] = 1;
    long result = 0;

    for (int i = 1; i < n; i++) {
        if (arr[i] > arr[i - 1]) {
            up[i] = up[i - 1] + 1;
        }
        else {
            up[i] = 1;
        }
    }
    for (int j = n - 2; j >= 0; j--) {
        if (arr[j] > arr[j + 1]) {
            down[j] = down[j + 1] + 1;
        }
        else {
            down[j] = 1;
        }
    }
    for (int k = 0; k < n; k++) {
        result += (long) max(up[k], down[k]);
    }

    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item;
        cin >> arr_item;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        arr[i] = arr_item;
    }

    long result = candies(n, arr);

    fout << result << "\n";

    fout.close();

    return 0;
}
