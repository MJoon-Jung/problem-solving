#include <bits/stdc++.h>
using namespace std;
int A, B, C, r, a, b;
int ar[101];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> A >> B >> C;

  for (int i = 0; i < 3; i++) {
    cin >> a >> b;
    for (int j = a; j < b; j++) {
      ar[j]++;
    }
  }
  for (int i = 1; i <= 100; i++) {
    switch (ar[i]) {
    case 1:
      r += A;
      break;
    case 2:
      r += B * 2;
      break;
    case 3:
      r += C * 3;
      break;
    }
  }

  cout << r;
  return 0;
}