#include <iostream>
using namespace std;
typedef long long ll;
ll a, b, c;

ll solution(ll a, ll b, ll c) {
  if (b == 1)
    return a % c;
  ll r = solution(a, b / 2, c);
  r = (r * r) % c;
  if (b % 2)
    r = (r * a) % c;
  return r;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> a >> b >> c;
  cout << solution(a, b, c) << "\n";
  return 0;
}