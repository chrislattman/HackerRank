// https://www.hackerrank.com/challenges/common-child/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the commonChild function below.
int commonChild(string s1, string s2) {
    int m = s1.length();
    int n = s2.length();
    vector<vector<int>> lcs(m + 1, vector<int>(n + 1));
    
    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
            if (i == 0 || j == 0) {
                lcs[i][j] = 0;
            }
            else if (s1[i - 1] == s2[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1;
            }
            else {
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
    }
    
    return lcs[m][n];
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s1;
    getline(cin, s1);

    string s2;
    getline(cin, s2);

    int result = commonChild(s1, s2);

    fout << result << "\n";

    fout.close();

    return 0;
}
