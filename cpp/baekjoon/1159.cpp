#include <bits/stdc++.h>
using namespace std;
int N;
string tmp;
char ar[27];
vector<char> v;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> N;

  if (N < 5) {
    cout << "PREDAJA";
    return 0;
  }

  for (int i = 0; i < N; i++) {
    cin >> tmp;
    ar[tmp[0] - 'a']++;
    if (ar[tmp[0] - 'a'] == 5) {
      v.push_back(tmp[0]);
    }
  }
  if (v.size() == 0) {
    cout << "PREDAJA";
    return 0;
  }
  sort(v.begin(), v.end());
  for (char z : v) {
    cout << z;
  }
  return 0;
}