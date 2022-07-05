#include <iostream>
#include <queue>
using namespace std;
int h,w;
int board[104][104];
char c;
queue<pair<int, int>> q;
int main() {
  cin >> h >> w;
  for(int y = 0; y < h; y++) {
    for(int x = 0; x < w; x++) {
      cin >> c;
      switch(c) {
        case 'c':
          board[y][x] = 0;
          break;
        case '.':
          board[y][x] = -1;
          break;
      }
    }
  } 

  for(int y = 0; y < h; y++) {
    for(int x = 0; x < w; x++) {
      if(board[y][x] == 0) {
        q.push({y,x});
        while(!q.empty()) {
          auto cur = q.front(); q.pop();
          if(cur.second + 1 >= w) continue;
          if(board[cur.first][cur.second+ 1] != -1) continue;
          q.push({cur.first,cur.second+1});
          board[cur.first][cur.second + 1] = board[cur.first][cur.second] + 1;
        }
      }
    }
  }

  for(int y = 0; y < h; y++) {
    for(int x = 0; x < w; x++) {
      cout << board[y][x] << " ";
    }
    cout << "\n";
  }
  return 0;
}
