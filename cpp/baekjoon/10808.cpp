#include <bits/stdc++.h>
using namespace std;

string S;
map<char, int> a;
int main() {
  cin >> S;
  for (char c : S) {
    a.emplace(c, a[c]++);
  }
  for (int i = 97; i <= 122; i++) {
    cout << a[char(i)] << "\n";
  }
  return 0;
}