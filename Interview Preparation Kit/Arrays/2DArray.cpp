// https://www.hackerrank.com/challenges/2d-array/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the hourglassSum function below.
int hourglassSum(vector<vector<int>> arr) {
    int max = INT_MIN;

    for (int i = 0; i < 16; i++) {
        int quotient = i / 4;
        int remainder = i % 4;

        int first = arr[quotient][remainder];
        int second = arr[quotient][remainder + 1];
        int third = arr[quotient][remainder + 2];
        int fourth = arr[quotient + 1][remainder + 1];
        int fifth = arr[quotient + 2][remainder];
        int sixth = arr[quotient + 2][remainder + 1];
        int seventh = arr[quotient + 2][remainder + 2];

        int sum = first + second + third + fourth + fifth + sixth + seventh;
        max = (int)fmax((double)sum, (double)max);
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
