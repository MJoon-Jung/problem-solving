#include <bits/stdc++.h>
using namespace std;

int a[9];
int sum;
int b, c;
int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  for (int i = 0; i < 9; i++)
  {
    cin >> a[i];
    sum += a[i];
  }
  sum -= 100;
  sort(a, a + 9);

  for (int i = 8; i > 0; i--)
  {
    for (int j = i - 1; j >= 0; j--)
    {
      if (sum == a[i] + a[j])
      {
        b = a[i];
        c = a[j];
        break;
      }
      else if (sum > a[i] + a[j])
        break;
    }
  }
  for (int i = 0; i < 9; i++)
  {
    if (a[i] == b || a[i] == c)
      continue;
    cout << a[i] << "\n";
  }

  return 0;
}
