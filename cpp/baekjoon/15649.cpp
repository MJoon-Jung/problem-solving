#include <iostream>
using namespace std;
int n,m;
int ar[9];
bool isused[9];
void func(int k) {
  if(k == m) {
    for(int i = 0; i < m; i++) cout << ar[i] << " ";
    cout << "\n";
    return;
  }
  for(int i = 1; i <= n; i++) {
    if(!isused[i]) {
      ar[k] = i;
      isused[i] = true;
      func(k+1);
      isused[i] = false;
    }
  }
}
int main(void) {
  ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
  cin >> n >> m;
  func(0);
}
