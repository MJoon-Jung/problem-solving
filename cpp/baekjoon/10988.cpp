#include <bits/stdc++.h>
using namespace std;
string s;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> s;

  for (int i = 0; i < s.length(); i++) {
    if (s[i] != s[s.length() - 1 - i]) {
      cout << 0;
      return 0;
    }
  }
  cout << 1;
  return 0;
}