// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the isValid function below.
string isValid(string s) {
    int s_len = (int)s.length();
    if (s_len < 2) {
        return "YES";
    }

    unordered_map<char, int> dict;

    for (int i = 0; i < s_len; i++) {
        char current = s[i];
        if (dict.count(current) > 0) {
            dict[current] += 1;
        }
        else {
            dict[current] = 1;
        }
    }

    int highestFrequency = INT_MIN;
    int lowestFrequency = INT_MAX;
    int highestFrequencyCount = 0;
    int lowestFrequencyCount = 0;

    for (unordered_map<char, int>::iterator it = dict.begin(); it != dict.end(); it++) {
        int value = it->second;
        if (value > highestFrequency) {
            highestFrequency = value;
            highestFrequencyCount = 1;
        }
        else if (value == highestFrequency) {
            highestFrequencyCount++;
        }

        if (value < lowestFrequency) {
            lowestFrequency = value;
            lowestFrequencyCount = 1;
        }
        else if (value == lowestFrequency) {
            lowestFrequencyCount++;
        }
    }

    if (highestFrequency == lowestFrequency) {
        return "YES";
    }
    if (highestFrequency * highestFrequencyCount == s_len - 1 &&
        lowestFrequency == 1) {
        return "YES";
    }
    if (lowestFrequency * lowestFrequencyCount + highestFrequency == s_len &&
        highestFrequency - 1 == lowestFrequency) {
        return "YES";
    }

    return "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = isValid(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
