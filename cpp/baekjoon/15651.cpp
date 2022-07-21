#include <iostream>
using namespace std;
int n, m, ar[8];
void func(int k) {
  if(k == m) {
    for(int i = 0; i < m; i++) cout << ar[i] << " ";
    cout << "\n";
    return;
  }
  for(int i = 1; i <= n; i++) {
    ar[k] = i;
    func(k+1);
  }
}
int main(void) {
  ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
  cin >> n >> m;
  func(0);
}
