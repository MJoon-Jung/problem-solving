#include <iostream>
using namespace std;
int ar[1000004];
int func(int n) {
  if(n == 1) return 0;
  if(ar[n] > 0) return ar[n];
  ar[n] = func(n-1)+1;
  if(n % 3 == 0) ar[n] = min(ar[n], func(n/3)+1);
  if(n % 2 == 0) ar[n] = min(ar[n], func(n/2)+1);
  return ar[n];
}
int main(void) {
  int n;
  cin >> n;
  cout << func(n);
}
