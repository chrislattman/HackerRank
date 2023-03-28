// https://www.hackerrank.com/challenges/frequency-queries/problem
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

// Complete the freqQuery function below.
vector<int> freqQuery(vector<vector<int>> queries) {
    vector<int> output;
    unordered_map<int, int> dict;
    unordered_map<int, int> frequencies;

    for (int i = 0; i < queries.size(); i++) {
        int queryType = queries[i][0];
        int data = queries[i][1];

        if (queryType == 1) {
            if (dict.count(data) > 0) {
                int old_frequency_key = dict[data];
                int new_frequency_key = old_frequency_key + 1;
                dict[data] = new_frequency_key;
                frequencies[old_frequency_key] -= 1;

                if (frequencies.count(new_frequency_key) > 0) {
                    frequencies[new_frequency_key] += 1;
                }
                else {
                    frequencies[new_frequency_key] = 1;
                }
            }
            else {
                dict[data] = 1;
                if (frequencies.count(1) > 0) {
                    frequencies[1] += 1;
                }
                else {
                    frequencies[1] = 1;
                }
            }
        }
        else if (queryType == 2) {
            if (dict.count(data) > 0 && dict[data] > 1) {
                int old_frequency_key = dict[data];
                int new_frequency_key = old_frequency_key - 1;
                dict[data] = new_frequency_key;
                frequencies[old_frequency_key] -= 1;

                if (frequencies.count(new_frequency_key) > 0) {
                    frequencies[new_frequency_key] += 1;
                }
                else {
                    frequencies[new_frequency_key] = 1;
                }

            }
            else if (dict.count(data) > 0) {
                dict.erase(data);
                if (frequencies.count(1) > 0) {
                    frequencies[1] -= 1;
                }
            }
        }
        else {
            if (frequencies.count(data) > 0 && frequencies[data] > 0) {
                output.insert(output.end(), 1);
            }
            else {
                output.insert(output.end(), 0);
            }
        }
    }

    return output;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string q_temp;
    getline(cin, q_temp);

    int q = stoi(ltrim(rtrim(q_temp)));

    vector<vector<int>> queries(q);

    for (int i = 0; i < q; i++) {
        queries[i].resize(2);

        string queries_row_temp_temp;
        getline(cin, queries_row_temp_temp);

        vector<string> queries_row_temp = split(rtrim(queries_row_temp_temp));

        for (int j = 0; j < 2; j++) {
            int queries_row_item = stoi(queries_row_temp[j]);

            queries[i][j] = queries_row_item;
        }
    }

    vector<int> ans = freqQuery(queries);

    for (int i = 0; i < ans.size(); i++) {
        fout << ans[i];

        if (i != ans.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

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

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}
