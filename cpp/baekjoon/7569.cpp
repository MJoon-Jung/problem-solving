#include <iostream>
#include <queue>
#include <tuple>
using namespace std;
int m, n, h;
int board[104][104][104];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int dz[2] = {-1,1};
queue<tuple<int, int, int>> q;
int main(){
    cin >> m >> n >> h;
    for(int z = 0; z < h; z++) {
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                cin >> board[z][y][x];
            }
        }
    }
    for(int z = 0; z < h; z++) {
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(board[z][y][x] == 1) {
                    q.push(make_tuple(z,y,x));
                    int curZ,curY,curX;
                    while(!q.empty()){
                        tie(curZ, curY, curX) = q.front(); q.pop();
                        for(int dir = 0; dir < 4; dir++) {
                            int nx = curX + dx[dir];
                            int ny = curY + dy[dir];
                            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if(board[curZ][ny][nx] < 0)  continue;
                            if(board[curZ][ny][nx] >= 1 && board[curZ][ny][nx] <= board[curZ][curY][curX] + 1) continue;
                            q.push(make_tuple(curZ,ny,nx));
                            board[curZ][ny][nx] = board[curZ][curY][curX] + 1;
                        }
                        for(int dir = 0; dir < 2; dir++) {
                            int nz = curZ + dz[dir];
                            if(nz < 0 || nz >= h) continue;
                            if(board[nz][curY][curX] < 0) continue;
                            if(board[nz][curY][curX] >= 1 && board[nz][curY][curX] <= board[curZ][curY][curX] + 1) continue;
                            q.push(make_tuple(nz,curY,curX));
                            board[nz][curY][curX] = board[curZ][curY][curX] + 1;
                        }
                    }
                }
            }
        }
    }
    int r = 0;
    for(int z = 0; z < h; z++) {
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(board[z][y][x] == 0) {
                    cout << -1;
                    return 0;
                }
                r = max(r, board[z][y][x]);
            }
        }
    }
    cout << r - 1;
    return 0;
}
