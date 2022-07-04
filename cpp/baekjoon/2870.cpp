#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
vector<string> v;
int n;
string s;
bool isAlpa(int i) {
  if(i >= 0 && i < 26) return true;
  return false;
}
string eraseZero(string a) {
  if(a[0] != '0') return a;
  for(int i = 1; i < a.size(); i++) {
    if(a[i] != '0') return a.substr(i);
  }
  return "0";
}
bool cmp(string a, string b) {
    if(a.size() > b.size()) return false;
    else if(a.size() < b.size()) return true;
    for(int i = 0; i < a.size(); i++) {
      if(a[i] > b[i]) return false;
      else if(a[i] < b[i]) return true;
    }
    return false;
}
int main() {
  ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
  cin >> n;
  while(n--) {
    cin >> s;
    string str = "";
    for(int i = 0; i < s.size(); i++) {
      if(!isAlpa(s[i]-'a')) str += s[i];
      else 
        if(str != "") v.push_back(eraseZero(str)), str = "";
    }
    if(str != "") v.push_back(eraseZero(str));
  }
  sort(v.begin(), v.end(), cmp);
  for(auto a: v) cout << a << "\n";
  return 0;
}
