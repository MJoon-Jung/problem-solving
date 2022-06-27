#include <bits/stdc++.h>
using namespace std;
string S;
int main() {
  getline(cin, S);
  for (char s : S) {
    if (s >= 65 && s <= 90) {
      if (s + 13 > 90)
        s = s + 13 - 26;
      else
        s += 13;
    } else if (s >= 97 && s <= 122) {
      if (s + 13 > 122)
        s = s + 13 - 26;
      else
        s += 13;
    }
    cout << s;
  }
  return 0;
}