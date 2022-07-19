#include <iostream>
using namespace std;
void func(int goal, int cur, int &cnt) {
  // base condition
  if(goal == cur) {
    cnt++;
    return;
  }
  // recursive
  if(cur + 1 <= goal) func(goal, cur + 1, cnt);
  if(cur + 2 <= goal) func(goal, cur + 2, cnt);
  if(cur + 3 <= goal) func(goal, cur + 3, cnt);
}
int main(void) {
  int t, n;
  cin >> t;
  while(t--) {
    cin >> n;
    int cnt = 0;
    for(int i = 1; i <= 3; i++) func(n, i, cnt);
    cout << cnt << "\n";
  }
}
