#include <bits/stdc++.h>
using namespace std;
string s, r;
int cut;
map<char, int, greater<char>> _map;
int main() {
  cin >> s;
  for (char c : s) {
    _map[c]++;
  }
  for (auto t : _map) {
    if (t.second % 2) {
      cut++;
      if (cut > 1) {
        cout << "I'm Sorry Hansoo";
        return 0;
      }
      r = r.substr(0, r.size() / 2) + t.first +
          r.substr(r.size() / 2, r.size());
    }
    int c = t.second / 2;
    while (c--) {
      r = t.first + r;
      r = r + t.first;
    }
  }
  cout << r;
  return 0;
}