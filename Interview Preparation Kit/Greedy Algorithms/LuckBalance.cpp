// https://www.hackerrank.com/challenges/luck-balance/problem
#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the luckBalance function below.
int luckBalance(int k, vector<vector<int>> contests) {
    int balance = 0;
    vector<int> important;

    int contests_rows = (int)contests.size();
    for (int i = 0; i < contests_rows; i++) {
        if (contests[i][1] == 0) {
            balance += contests[i][0];
        }
        else {
            important.insert(important.end(), contests[i][0]);
        }
    }

    sort(important.begin(), important.end());

    int important_size = (int)important.size();
    if (important_size > k) {
        int midpoint = important_size - k;
        for (int j = midpoint; j < important_size; j++) {
            balance += important[j];
        }

        for (int m = 0; m < midpoint; m++) {
            balance -= important[m];
        }
    }
    else {
        for (int p = 0; p < important_size; p++) {
            balance += important[p];
        }
    }

    return balance;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nk_temp;
    getline(cin, nk_temp);

    vector<string> nk = split_string(nk_temp);

    int n = stoi(nk[0]);

    int k = stoi(nk[1]);

    vector<vector<int>> contests(n);
    for (int i = 0; i < n; i++) {
        contests[i].resize(2);

        for (int j = 0; j < 2; j++) {
            cin >> contests[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int result = luckBalance(k, contests);

    fout << result << "\n";

    fout.close();

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}
