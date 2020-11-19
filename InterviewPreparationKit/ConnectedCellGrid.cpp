// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
#include <bits/stdc++.h>

using namespace std;

int search(vector<vector<int>>& grid, int x, int y) {
    if (x >= 0 && y >= 0 && x < grid.size() && y < grid[0].size() && grid[x][y] == 1) {
        grid[x][y] = 0;
        return 1 + search(grid, x - 1, y) + 
                search(grid, x + 1, y) + 
                search(grid, x, y - 1) + 
                search(grid, x, y + 1) + 
                search(grid, x - 1, y - 1) + 
                search(grid, x + 1, y - 1) + 
                search(grid, x - 1, y + 1) + 
                search(grid, x + 1, y + 1);
    }
    return 0;
}

// Complete the maxRegion function below.
int maxRegion(vector<vector<int>> grid) {
    int largest = 0;
    
    for (int x = 0; x < grid.size(); x++) {
        for (int y = 0; y < grid[0].size(); y++) {
            if (grid[x][y] == 1) {
                int current = search(grid, x, y);
                if (current > largest) {
                    largest = current;
                }
            }
        }
    }
    
    return largest;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int m;
    cin >> m;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<vector<int>> grid(n);
    for (int i = 0; i < n; i++) {
        grid[i].resize(m);

        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int res = maxRegion(grid);

    fout << res << "\n";

    fout.close();

    return 0;
}
