// https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the stepPerms function below.
int stepPerms(int n) {
    if (n < 3) {
        return n;
    }
    if (n == 3) {
        return 4;
    }

    vector<int> vec;
    vec.insert(vec.end(), 1);
    vec.insert(vec.end(), 2);
    vec.insert(vec.end(), 4);
    for (int i = 3; i < n; i++) {
        vec.insert(vec.end(), vec[i - 1] + vec[i - 2] + vec[i - 3]);
    }
    
    return vec[n - 1];
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int s;
    cin >> s;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int s_itr = 0; s_itr < s; s_itr++) {
        int n;
        cin >> n;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        int res = stepPerms(n);

        fout << res << "\n";
    }

    fout.close();

    return 0;
}
