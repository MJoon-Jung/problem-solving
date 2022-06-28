#include <bits/stdc++.h>
using namespace std;
int n, m, r, temp;
map<int, bool> _map;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  cin >> m;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    _map[temp] = true;
  }
  for (auto t : _map) {
    if (_map.find(m - t.first) != _map.end()) {
      r++;
    }
  }
  cout << r / 2;
  return 0;
}