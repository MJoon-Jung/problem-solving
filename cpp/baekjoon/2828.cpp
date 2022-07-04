#include <iostream>
using namespace std;
int n, m, j, cnt, a;
int main() {
  cin >> n >> m >> j;
  int cur = m;
  while(j--) {
    cin >> a;
    if(cur < a) {
      cnt += a - cur;
      cur = a;
    } else if(cur - m + 1 > a) {
      cnt += cur - a - m + 1; 
      cur = a + m - 1;
    } else {
        continue;
    }
  }
  cout << cnt;
  return 0;
}
