#include <bits/stdc++.h>
using namespace std;
int N, K, temp, ar[100001], ret = -10000004;
int main() {
  cin >> N >> K;
  for (int i = 0; i < N; i++) {
    cin >> temp;
    ar[i] = temp + ar[i - 1];
  }
  for (int i = K; i < N; i++) {
    ret = max(ret, ar[i] - ar[i - K]);
  }
  cout << ret;
  return 0;
}