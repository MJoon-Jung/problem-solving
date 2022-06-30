#include <iostream>
using namespace std;
typedef long long ll;
ll n;
int main()
{
  ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  while(cin >> n) {
    ll cnt = 1, ret = 1;
    while (true) {
      if(cnt % n == 0) {
        cout << ret << "\n";
        break;
      }
      cnt = (cnt % n) * (10 % n) + 1 % n;
      ret++;
    }
  }
  return 0;
}

