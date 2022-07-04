#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
int m, n, k; 
int board[104][104];
bool visit[104][104];
vector<int> v;
queue<pair<int, int>> q;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int main() {
  cin >> m >> n >> k;
  for(int i = 0; i < k; i++) {
    int x1,x2,y1,y2;
    cin >> x1 >> y1 >> x2 >> y2;
    for(int y = y1; y < y2; y++) {
      for(int x = x1; x < x2; x++){
        board[y][x] = 1; 
      }
    }
  }
  int cnt = 0;
  for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){
      if(board[i][j] == 1) continue;
      if(visit[i][j]) continue;
      q.push({i,j});
      visit[i][j] = true;
      cnt++;
      int area = 0;
      while(!q.empty()) {
        area++;
        auto cur = q.front(); q.pop();
        for(int dir = 0; dir < 4; dir++) {
          int nx = cur.first + dx[dir];
          int ny = cur.second + dy[dir];
          if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
          if(board[nx][ny] == 1 || visit[nx][ny]) continue;
          q.push({nx,ny});
          visit[nx][ny] = true;
        }
      }
      v.push_back(area);
    }
  }
  cout << cnt << "\n";
  sort(v.begin(), v.end());
  for(int a: v) {
    cout << a << " ";
  }
  return 0;
}
