#include <iostream>
#include <queue>
using namespace std;
int t;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> t;
  while (t--) {
    int n, m, k;
    int board[54][54] = {
        0,
    };
    bool visit[54][54] = {
        false,
    };
    cin >> m >> n >> k;
    int x, y;
    while (k--) {
      cin >> y >> x;
      board[x][y] = 1;
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] != 1)
          continue;
        if (visit[i][j])
          continue;
        queue<pair<int, int>> q;
        q.push({i, j});
        visit[i][j] = true;
        cnt++;
        while (!q.empty()) {
          auto cur = q.front();
          q.pop();
          for (int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
              continue;
            if (board[nx][ny] == 0 || visit[nx][ny])
              continue;
            q.push({nx, ny});
            visit[nx][ny] = true;
          }
        }
      }
    }
    cout << cnt << "\n";
  }
  return 0;
}