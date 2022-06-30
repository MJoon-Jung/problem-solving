#include <iostream>
#include <queue>
using namespace std;
int n, m, mx;
int board[1004][1004];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main() {
  cin >> n >> m;
  queue<pair<int, int>> q;
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      cin >> board[i][j];
      if (board[i][j] == 1) {
        q.push({i, j});
      }
    }
  }
  while (!q.empty()) {
    pair<int, int> cur = q.front();
    q.pop();
    for (int dir = 0; dir < 4; dir++) {
      int nx = cur.first + dx[dir];
      int ny = cur.second + dy[dir];
      if (nx < 0 || nx >= m || ny < 0 || ny >= n)
        continue;
      if (board[nx][ny] != 0)
        continue;

      board[nx][ny] = board[cur.first][cur.second] + 1;
      q.push({nx, ny});
    }
  }
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (board[i][j] == 0) {
        cout << -1;
        return 0;
      }
      mx = max(mx, board[i][j]);
    }
  }
  cout << mx - 1;
  return 0;
}