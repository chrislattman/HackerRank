// https://www.hackerrank.com/challenges/balanced-brackets/problem
#include <bits/stdc++.h>

using namespace std;

// Complete the isBalanced function below.
string isBalanced(string s) {
    stack<char> brackets;

    int s_len = (int)s.length();
    for (int i = 0; i < s_len; i++) {
        char bracket = s[i];
        if (bracket == '(' || bracket == '{' || bracket == '[') {
            brackets.push(bracket);
        }
        else {
            if (brackets.empty()) {
                return "NO";
            }

            char top = brackets.top();
            if (bracket == ')' && top == '(') {
                brackets.pop();
            }
            else if (bracket == '}' && top == '{') {
                brackets.pop();
            }
            else if (bracket == ']' && top == '[') {
                brackets.pop();
            }
            else {
                return "NO";
            }
        }
    }

    if (brackets.empty()) {
        return "YES";
    }

    return "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int t;
    cin >> t;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string s;
        getline(cin, s);

        string result = isBalanced(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
