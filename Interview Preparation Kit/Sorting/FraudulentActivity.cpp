// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

template<typename T> class max_heap : public priority_queue<T, vector<T>> {
    public:
        bool remove(const T& value) {
            auto it = std::find(this->c.begin(), this->c.end(), value);
            if (it != this->c.end()) {
                this->c.erase(it);
                make_heap(this->c.begin(), this->c.end(), this->comp);
                return true;
            }
            else {
                return false;
            }
        }
};

template<typename T> class min_heap : public priority_queue<T, vector<T>, greater<T>> {
    public:
        bool remove(const T& value) {
            auto it = std::find(this->c.begin(), this->c.end(), value);
            if (it != this->c.end()) {
                this->c.erase(it);
                make_heap(this->c.begin(), this->c.end(), this->comp);
                return true;
            }
            else {
                return false;
            }
        }
};

class RollingMedianHeaps {
    private:
        max_heap<int> maxHeap;
        min_heap<int> minHeap;

        void balanceHeaps() {
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.push(minHeap.top());
                minHeap.pop();
            }
            else if (maxHeap.size() > 1 + minHeap.size()) {
                minHeap.push(maxHeap.top());
                maxHeap.pop();
            }
        }

    public:
        double getMedian() {
            int size = minHeap.size() + maxHeap.size();
            if (size % 2 == 0) {
                return (maxHeap.top() + minHeap.top()) / 2.0;
            }
            return (double) maxHeap.top();
        }

        void add(int number) {
            if (maxHeap.size() == 0 || number <= maxHeap.top()) {
                maxHeap.push(number);
            }
            else {
                minHeap.push(number);
            }
            balanceHeaps();
        }

        void remove(int number) {
            if (!maxHeap.remove(number)) {
                minHeap.remove(number);
            }
            balanceHeaps();
        }
};

// Complete the activityNotifications function below.
int activityNotifications(vector<int> expenditure, int d) {
    int notifications = 0;
    RollingMedianHeaps heaps;

    for (int i = 0; i < expenditure.size(); i++) {
        if (i >= d) {
            if ((double) expenditure[i] >= 2 * heaps.getMedian()) {
                notifications++;
            }
            heaps.remove(expenditure[i - d]);
        }
        heaps.add(expenditure[i]);
    }

    return notifications;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nd_temp;
    getline(cin, nd_temp);

    vector<string> nd = split_string(nd_temp);

    int n = stoi(nd[0]);

    int d = stoi(nd[1]);

    string expenditure_temp_temp;
    getline(cin, expenditure_temp_temp);

    vector<string> expenditure_temp = split_string(expenditure_temp_temp);

    vector<int> expenditure(n);

    for (int i = 0; i < n; i++) {
        int expenditure_item = stoi(expenditure_temp[i]);

        expenditure[i] = expenditure_item;
    }

    int result = activityNotifications(expenditure, d);

    fout << result << "\n";

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
