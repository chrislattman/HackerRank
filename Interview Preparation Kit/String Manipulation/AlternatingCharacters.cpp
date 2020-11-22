// https://www.hackerrank.com/challenges/alternating-characters/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the alternatingCharacters function below.
int alternatingCharacters(string s) {
    char last = s[0];
    vector<char> list = {last};

    for (int i = 1; i < s.length(); i++) {
        char current = s[i];
        if (current != last) {
            list.insert(list.end(), current);
            last = current;
        }
    }

    return s.length() - list.size();
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        getline(cin, s);

        int result = alternatingCharacters(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
