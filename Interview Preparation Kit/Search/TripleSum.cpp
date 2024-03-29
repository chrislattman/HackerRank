// https://www.hackerrank.com/challenges/triple-sum/problem
#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the triplets function below.
long triplets(vector<int> a, vector<int> b, vector<int> c) {
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    sort(c.begin(), c.end());

    vector<int> a_set;
    vector<int> b_set;
    vector<int> c_set;
    a_set.insert(a_set.end(), a[0]);
    b_set.insert(b_set.end(), b[0]);
    c_set.insert(c_set.end(), c[0]);

    int len_a = (int)a.size();
    int len_b = (int)b.size();
    int len_c = (int)c.size();

    for (int i = 1; i < len_a; i++) {
        if (a[i] != a[i - 1]) {
            a_set.insert(a_set.end(), a[i]);
        }
    }

    for (int j = 1; j < len_b; j++) {
        if (b[j] != b[j - 1]) {
            b_set.insert(b_set.end(), b[j]);
        }
    }

    for (int k = 1; k < len_c; k++) {
        if (c[k] != c[k - 1]) {
            c_set.insert(c_set.end(), c[k]);
        }
    }

    int a_size = a_set.size();
    int b_size = b_set.size();
    int c_size = c_set.size();

    long triplets = 0;
    int a_index = 0;
    int c_index = 0;
    for (int m = 0; m < b_size; m++) {
        while (a_index < a_size && a_set[a_index] <= b_set[m]) {
            a_index++;
        }
        while (c_index < c_size && c_set[c_index] <= b_set[m]) {
            c_index++;
        }

        triplets += (long) a_index * (long) c_index;
    }

    return triplets;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string lenaLenbLenc_temp;
    getline(cin, lenaLenbLenc_temp);

    vector<string> lenaLenbLenc = split_string(lenaLenbLenc_temp);

    int lena = stoi(lenaLenbLenc[0]);

    int lenb = stoi(lenaLenbLenc[1]);

    int lenc = stoi(lenaLenbLenc[2]);

    string arra_temp_temp;
    getline(cin, arra_temp_temp);

    vector<string> arra_temp = split_string(arra_temp_temp);

    vector<int> arra(lena);

    for (int i = 0; i < lena; i++) {
        int arra_item = stoi(arra_temp[i]);

        arra[i] = arra_item;
    }

    string arrb_temp_temp;
    getline(cin, arrb_temp_temp);

    vector<string> arrb_temp = split_string(arrb_temp_temp);

    vector<int> arrb(lenb);

    for (int i = 0; i < lenb; i++) {
        int arrb_item = stoi(arrb_temp[i]);

        arrb[i] = arrb_item;
    }

    string arrc_temp_temp;
    getline(cin, arrc_temp_temp);

    vector<string> arrc_temp = split_string(arrc_temp_temp);

    vector<int> arrc(lenc);

    for (int i = 0; i < lenc; i++) {
        int arrc_item = stoi(arrc_temp[i]);

        arrc[i] = arrc_item;
    }

    long ans = triplets(arra, arrb, arrc);

    fout << ans << "\n";

    fout.close();

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
