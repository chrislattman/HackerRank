// https://www.hackerrank.com/challenges/repeated-string/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the repeatedString function below.
long repeatedString(string s, long n) {
    long stringLength = (long) s.length();
    long quotient = n / stringLength;
    long remainder = n % stringLength;

    long aCount = 0;
    long aCountRemainder = 0;
    for (int i = 0; i < stringLength; i++) {
        if (s[i] == 'a') {
            if (i < remainder) {
                aCountRemainder++;
            }
            aCount++;
        }
    }

    return aCount * quotient + aCountRemainder;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    long n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    long result = repeatedString(s, n);

    fout << result << "\n";

    fout.close();

    return 0;
}
