// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the makeAnagram function below.
int makeAnagram(string a, string b) {
    unordered_map<char, int> a_map;
    unordered_map<char, int> b_map;

    int a_len = (int)a.length();
    for (int i = 0; i < a_len; i++) {
        char letter = a[i];
        if (a_map.count(letter) > 0) {
            a_map[letter] += 1;
        }
        else {
            a_map[letter] = 1;
        }
    }

    int b_len = (int)b.length();
    for (int j = 0; j < b_len; j++) {
        char letter = b[j];
        if (b_map.count(letter) > 0) {
            b_map[letter] += 1;
        }
        else {
            b_map[letter] = 1;
        }
    }

    int removed = 0;
    for (char key = 'a'; key <= 'z'; key++) {
        if (a_map.count(key) > 0 && b_map.count(key) > 0) {
            removed += abs(a_map[key] - b_map[key]);
        }
        else if (a_map.count(key) > 0) {
            removed += a_map[key];
        }
        else if (b_map.count(key) > 0) {
            removed += b_map[key];
        }
    }

    return removed;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string a;
    getline(cin, a);

    string b;
    getline(cin, b);

    int res = makeAnagram(a, b);

    fout << res << "\n";

    fout.close();

    return 0;
}
