#include <iostream>
using namespace std;
int n,m,ar[10];
void func(int k, int start) {
  if(k == m) {
    for(int i = 0; i < m; i++) cout << ar[i] << " ";
    cout << "\n";
    return;
  }
  for(int i = start; i <= n; i++) {
    ar[k] = i;
    func(k+1, i);
  }
}
int main(void) {
  ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
  cin >> n >> m;
  func(0, 1);
}
