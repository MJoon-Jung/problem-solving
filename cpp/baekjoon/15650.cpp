#include <iostream>
using namespace std;
int n,m;
int ar[9];
bool isused[9];
void func(int k, int start, int end) {
  if(k == m) {
    for(int i = 0; i < m; i++) cout << ar[i] << " ";
    cout << "\n";
    return;
  }
  for(int i = start; i <= end; i++) {
    if(isused[i]) continue;
    ar[k] = i;
    isused[i] = true;
    func(k+1, i, n);
    isused[i] = false;
  }
}
int main(void) {
  ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
  cin >> n >> m;
  func(0, 1, n);
}
