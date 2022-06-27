#include <bits/stdc++.h>
using namespace std;
int N, K;
int main() {
  cin >> N >> K;
  int ar[N] = {};
  int ar2[N] = {};
  for (int i = 0; i < N; i++) {
    cin >> ar2[i];
    if (i == 0)
      ar[i] = ar2[i];
    else if (i - K >= 0) {
      ar[i] = ar2[i] + ar[i - 1] - ar2[i - K];
    } else
      ar[i] = ar2[i] + ar[i - 1];
  }
  if (K > 1)
    cout << *max_element(ar + K - 1, ar + N);
  else
    cout << *max_element(ar, ar + N);
  return 0;
}