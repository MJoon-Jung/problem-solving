#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
string x;
int main(void) {
  cin >> x;
  char ar[x.size()];
  for(int i = 0; i < x.size(); i++) ar[i] = x[i];
  int ans = 0;
  do {
    string s = "";
    for(int i = 0; i < x.size(); i++) s += ar[i];
    if(stoi(s) <= stoi(x)) continue;
    if(ans == 0 || ans > stoi(s)) ans = stoi(s);
  } while(next_permutation(ar, ar + x.size()));
  cout << ans;
}
