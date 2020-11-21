// https://www.hackerrank.com/challenges/new-year-chaos/problem
#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the minimumBribes function below.
void minimumBribes(vector<int> q) {
    int swaps = 0;
    int index = 0;
    int lastSortedIndex = -1;
    bool too_chaotic = false;
    map<int, int> bribeMap;
    
    while (index < q.size() - 1) {
        if (q[index] > q[index + 1]) {
            if (bribeMap.count(q[index]) > 0 && bribeMap[q[index]] >= 2) {
                cout << "Too chaotic" << endl;
                too_chaotic = true;
                break;
            }
            if (bribeMap.count(q[index]) == 0) {
                bribeMap[q[index]] = 0;
            }
            bribeMap[q[index]]++;
            
            int temp = q[index];
            q[index] = q[index + 1];
            q[index + 1] = temp;
            
            swaps++;
            index = lastSortedIndex;
        }
        else if (q[index] == index + 1) {
            lastSortedIndex++;
        }
        index++;
    }
    
    if (!too_chaotic) {
        cout << swaps << endl;
    }
}

int main()
{
    int t;
    cin >> t;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int t_itr = 0; t_itr < t; t_itr++) {
        int n;
        cin >> n;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        string q_temp_temp;
        getline(cin, q_temp_temp);

        vector<string> q_temp = split_string(q_temp_temp);

        vector<int> q(n);

        for (int i = 0; i < n; i++) {
            int q_item = stoi(q_temp[i]);

            q[i] = q_item;
        }

        minimumBribes(q);
    }

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}
