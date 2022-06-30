#include <iostream>
#include <queue>
using namespace std;
int n, m;
string board [104];
int dist[104][104];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m;
  for (int i = 0; i < n; i++)
    cin >> board[i];
  queue<pair<int, int>> q;
  q.push({0,0});
  dist[0][0] = 1;
  while(!q.empty()) {
    pair<int, int> cur = q.front(); q.pop();
    for(int dir = 0; dir < 4; dir++) {
      int nx = cur.first + dx[dir];
      int ny = cur.second + dy[dir];
      if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
      if(dist[nx][ny] > 0 || board[nx][ny] != '1') continue;
      q.push({nx,ny});
      dist[nx][ny] = dist[cur.first][cur.second] + 1;
    }
  }
  cout << dist[n-1][m-1];
  return 0;
}