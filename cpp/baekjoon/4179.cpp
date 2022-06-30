#include <iostream>
#include <queue>
using namespace std;
const int MAX_RANGE = 999999999;
int n, m;
string board[1004];
int canBoard[1004][1004];
int fireBoard[1004][1004];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m;
  queue<pair<int, int>> can;
  queue<pair<int, int>> fire;
  for (int i = 0; i < n; i++) {
    cin >> board[i];
    for (int j = 0; j < m; j++) {
      if (board[i][j] == 'F') {
        fire.push({i, j});
        fireBoard[i][j] = 1;
      } else if (board[i][j] == 'J') {
        can.push({i, j});
        canBoard[i][j] = 1;
      }
    }
  }
  // 불이 몇번째로 번진 불인지 기록
  while (!fire.empty()) {
    auto cur = fire.front();
    fire.pop();
    for (int dir = 0; dir < 4; dir++) {
      int nx = cur.first + dx[dir];
      int ny = cur.second + dy[dir];
      if (nx < 0 || nx >= m || ny < 0 || ny >= n)
        continue;
      if (board[nx][ny] == '#')
        continue;
      if (fireBoard[nx][ny] > 0)
        continue;
      fire.push({nx, ny});
      fireBoard[nx][ny] = fireBoard[cur.first][cur.second] + 1;
    }
  }
  // 순서가 같다면 애초에 못가던 길 불보다 번호가 낮은 길은 통과한걸로
  // 사람이 탈출하는 것을 몇번째 이동중인가 기록
  while (!can.empty()) {
    auto cur = can.front();
    can.pop();
    for (int dir = 0; dir < 4; dir++) {
      int nx = cur.first + dx[dir];
      int ny = cur.second + dy[dir];
      if (nx < 0 || nx >= n || ny < 0 || ny >= m)
        continue;
      if (board[nx][ny] != '.')
        continue;
      if (canBoard[nx][ny] > 0)
        continue;
      if (fireBoard[nx][ny] > 0 && canBoard[cur.first][cur.second] + 1 >= fireBoard[nx][ny])
        continue;
      can.push({nx, ny});
      canBoard[nx][ny] = canBoard[cur.first][cur.second] + 1;
    }
  }
  int r = MAX_RANGE;
  for (int i = 0; i < n; i++) {
    if (i == 0 || i == n - 1) {
      for (int j = 0; j < m; j++) {
        if (canBoard[i][j] > 0)
          r = min(r, canBoard[i][j]);
      }
    } else {
      if (canBoard[i][0] > 0)
        r = min(r, canBoard[i][0]);

      if (canBoard[i][m - 1] > 0)
        r = min(r, canBoard[i][m - 1]);
    }
  }
  if (r == MAX_RANGE)
    cout << "IMPOSSIBLE";
  else
    cout << r;
  return 0;
}