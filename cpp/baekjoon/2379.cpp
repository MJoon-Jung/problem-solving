#include <iostream>
using namespace std;
int n, cnt, m = 30;
double t;
int main() {
  cin >> n;
  while (n--) {
    cin >> t;
    cout << t / 2 << "\n";
    if (t / 2 > m) {
      m = 30;
      continue;
    }
    m -= t;
    cnt++;
    if (m <= 0)
      m = 30;
  }
  cout << cnt;
}