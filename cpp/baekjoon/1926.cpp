#include <iostream>
#include <queue>
using namespace std;
int n, m, cnt, mxArea;
int board[501][501], dx[4] = {1, 0, -1, 0}, dy[4] = {0, 1, 0, -1};
bool visit[501][501];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      cin >> board[i][j];

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (board[i][j] == 0 || visit[i][j])
        continue;
      cnt++;
      queue<pair<int, int>> q;
      visit[i][j] = 1;
      q.push({i, j});
      int area = 0;
      while (!q.empty()) {
        area++;
        pair<int, int> cur = q.front();
        q.pop();
        for (int dir = 0; dir < 4; dir++) {
          int nx = cur.first + dx[dir];
          int ny = cur.second + dy[dir];
          if (nx < 0 || nx >= n || ny < 0 || ny >= m)
            continue;
          if (board[nx][ny] != 1 || visit[nx][ny])
            continue;
          visit[nx][ny] = 1;
          q.push({nx, ny});
        }
      }
      mxArea = max(mxArea, area);
    }
  }

  cout << cnt << "\n" << mxArea;
  return 0;
}