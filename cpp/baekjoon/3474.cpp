#include <iostream>
using namespace std;
int t, n, two, five;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> t;
  while (t--) {
    cin >> n;
    two = five = 0;
    for (long i = 2; i <= n; i *= 2) {
      two += n / i;
    }
    for (long i = 5; i <= n; i *= 5) {
      five += n / i;
    }
    cout << min(two, five) << "\n";
  }
  return 0;
}
