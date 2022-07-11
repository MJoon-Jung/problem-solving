#include <iostream>
#include <queue>
using namespace std;
int n, cnt;
queue<pair<int, int>> q;
string board[104];
bool visit[104][104];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {
  cin >> n;
  for(int i = 0; i < n; i++) {
    cin >> board[i];
  }

  for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
      if(visit[i][j]) continue;
      cnt++;
      q.push({i,j});
      visit[i][j] = true;
      while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir = 0; dir < 4; dir++) {
          int nx = cur.first + dx[dir];
          int ny = cur.second + dy[dir];
          if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
          if(visit[nx][ny]) continue;
          if(board[cur.first][cur.second] != board[nx][ny]) continue;
          q.push({nx,ny});
          visit[nx][ny] = true;
        }
      }
    }
  }
  cout << cnt << " ";
  cnt = 0;
  fill(&visit[0][0], &visit[n+2][n+2], false);
  for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
      if(visit[i][j]) continue;
      cnt++;
      q.push({i,j});
      visit[i][j] = true;
      while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir = 0; dir < 4; dir++) {
          int nx = cur.first + dx[dir];
          int ny = cur.second + dy[dir];
          if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
          if(visit[nx][ny]) continue;
          if(board[cur.first][cur.second] == 'B') {
            if(board[nx][ny] != 'B') continue; 
          } else {
            if(board[nx][ny] == 'B') continue;
          }
          q.push({nx,ny});
          visit[nx][ny] = true;
        }
      }
    }
  }
  cout << cnt;
  return 0;
}
