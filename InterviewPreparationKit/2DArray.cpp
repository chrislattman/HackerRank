// https://www.hackerrank.com/challenges/2d-array/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the hourglassSum function below.
int hourglassSum(vector<vector<int>> arr) {
    int max = INT_MIN;

    for (int i = 0; i < 16; i++) {
        int first = arr[i / 4][i % 4];
        int second = arr[i / 4][(i % 4) + 1];
        int third = arr[i / 4][(i % 4) + 2];
        int fourth = arr[(i / 4) + 1][(i % 4) + 1];
        int fifth = arr[(i / 4) + 2][i % 4];
        int sixth = arr[(i / 4) + 2][(i % 4) + 1];
        int seventh = arr[(i / 4) + 2][(i % 4) + 2];

        int sum = first + second + third + fourth + fifth + sixth + seventh;
        if (sum > max) {
            max = sum;
        }
    }

    return max;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++) {
        arr[i].resize(6);

        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int result = hourglassSum(arr);

    fout << result << "\n";

    fout.close();

    return 0;
}
