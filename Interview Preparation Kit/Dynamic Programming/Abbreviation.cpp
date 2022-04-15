// https://www.hackerrank.com/challenges/abbr/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the abbreviation function below.
string abbreviation(string a, string b) {
    int m = a.length();
    int n = b.length();

    vector<vector<bool>> valid(m + 1, vector<bool>(n + 1));
    valid[0][0] = true;

    for (int i = 1; i <= m; i++) {
        int end = min(i, n);
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

    if (valid[m][n]) {
        return "YES";
    }
    return "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string a;
        getline(cin, a);

        string b;
        getline(cin, b);

        string result = abbreviation(a, b);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
