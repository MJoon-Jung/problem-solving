#include <bits/stdc++.h>
using namespace std;
int n,m;
string a, b;
int main()
{
  ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  cin >> n;
  for(int i = 0; i < n; i++) {
    map<string, int> map;
    cin >> m;
    for(int j = 0; j < m; j++) {
      cin >> a >> b;
      map[b]++; 
    }
    long long ret = 1;
    for(auto z: map) {
      ret *= ((long long)(z.second + 1));
    }
    ret--;
    cout << ret << "\n";
  }
  return 0;
}