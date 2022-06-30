#include <bits/stdc++.h>
using namespace std;
int n, r;
string s;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  while (n--) {
    cin >> s;
    stack<char> st;
    for (char c : s) {
      if (st.size() && st.top() == c) {
        st.pop();
        continue;
      }
      st.push(c);
    }
    if (!st.size())
      r++;
  }
  cout << r;
  return 0;
}