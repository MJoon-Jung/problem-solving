#include <bits/stdc++.h>
using namespace std;
int N;
string p, f, s, tmp;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> N;
  cin >> p;
  int pos = p.find('*');
  f = p.substr(0, pos);
  s = p.substr(pos + 1);
  for (int i = 0; i < N; i++) {
    cin >> tmp;
    if (tmp.size() < f.size() + s.size())
      cout << "NE"
           << "\n";
    else {
      if (tmp.substr(0, f.size()) == f &&
          tmp.substr(tmp.size() - s.size()) == s)
        cout << "DA"
             << "\n";
      else
        cout << "NE"
             << "\n";
    }
  }
  return 0;
}