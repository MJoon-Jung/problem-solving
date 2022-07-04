#include <iostream>
#include <string>
using namespace std;
string s;
int lcnt, vcnt;
bool isVowel(int idx) {
    return (idx == 0 || idx == 4 || idx == 8 || idx == 14 || idx == 20);
}
int main() {
  while(true) {
    cin >> s;
    if(s == "end") break;
    lcnt = vcnt = 0;
    int cnt[30] = {0,};
    bool flag = false;
    for(int i = 0; i < s.size(); i++) {
      int idx = s[i] - 'a';
      cnt[idx]++;
      if(isVowel(idx)) vcnt++, lcnt = 0;
      else lcnt++, vcnt = 0;
      if(vcnt == 3 || lcnt == 3) flag = true;
      if(i >= 1 && (s[i-1] == s[i]) && (idx != 4 && idx != 14)) flag = true;
    }
    if(!cnt[0] && !cnt[4] && !cnt[8] && !cnt[14] && !cnt[20]) flag = true;
    if(flag) cout << "<" << s << ">" << " is not acceptable.\n";
    else cout << "<" << s << ">" << " is acceptable.\n";
  }
  return 0;
}
