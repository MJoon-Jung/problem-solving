#include <bits/stdc++.h>
using namespace std;
int n, m;
map<int, string> _m;
map<string, int> _m2;
string s;
bool isNumber(const string &str) {
  for (char const &c : str) {
    if (isdigit(c) == 0)
      return false;
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m;

  for (int i = 1; i <= n; i++) {
    cin >> s;
    _m[i] = s;
    _m2[s] = i;
  }

  for (int i = 0; i < m; i++) {
    cin >> s;
    if (atoi(s.c_str()) == 0)
      cout << _m2[s] << "\n";
    else
      cout << _m[atoi(s.c_str())] << "\n";
  }

  return 0;
}