// https://www.hackerrank.com/challenges/even-odd-query

#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<int> A(N);
    for (int i = 0; i < N; i++)
        cin >> A[i];

    int q, x, y;
    cin >> q;
    for (int i = 0; i < q; i++)   {
        cin >> x >> y;
        if ((x == y && A[x-1] % 2 == 0) || (A[x-1] % 2 == 0 && A[x]!= 0)) {
            cout << "Even\n";
        }
        else {
            cout << "Odd\n";
        }
    }

    return 0;
}
