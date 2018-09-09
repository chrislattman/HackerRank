// https://www.hackerrank.com/contests/university-codesprint-5/challenges/cube-loving-numbers/problem

#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

// Complete the solve function below.
long solve(long n) {
    set<long> cubeset;
    for (long i = 2; i * i * i <= n; i++) {
        bool composite = false;
        for (long j = 2; j <= i / 2; j++) {
            if (i % j == 0) {
                composite = true;
                break;
            }
        }
        if (!composite) {
            long cube = i * i * i;
            for (long k = 1; k <= n / cube; k++) {
                cubeset.insert(cube * k);
            }
        }
    }
    return cubeset.size();
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string t_temp;
    getline(cin, t_temp);

    int t = stoi(ltrim(rtrim(t_temp)));

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string n_temp;
        getline(cin, n_temp);

        long n = stol(ltrim(rtrim(n_temp)));

        long result = solve(n);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
