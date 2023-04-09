// [문제 링크]: https://www.acmicpc.net/problem/15683

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    private static final int WALL = 6;
    int N, M, K, ans = 65;
    int[][] board = new int[8][8];
    Point[] points = new Point[64];
​
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
​
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
​
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] >= 1 && board[i][j] <= 5) {
                    points[K++] = new Point(i, j);
                }
            }
        }
​
        solve(0);
        System.out.println(ans);
        br.close();
    }
​
    private void solve(int idx) {
        if (idx == K) {
            ans = Math.min(ans, getCnt());
            return;
        }
        Point point = points[idx];
        int val = board[point.x][point.y];
        if (val == 1) {
            type1(idx, point);
        } else if (val == 2) {
            type2(idx, point);
        } else if (val == 3) {
            type3(idx, point);
        } else if (val == 4) {
            type4(idx, point);
        } else if (val == 5) {
            type5(idx, point);
        }
    }
​
    private void type5(int idx, Point point) {
        for (Direction dir : Direction.values()) {
            go(idx, point, dir);
        }
        solve(idx + 1);
        for (Direction dir : Direction.values()) {
            back(idx, point, dir);
        }
    }
​
    private void type4(int idx, Point point) {
        Direction[] dirs = Direction.values();
        for (int i = 0; i < 4; i++) {
            go(idx, point, dirs[i]);
            go(idx, point, dirs[(i + 1) % 4]);
            go(idx, point, dirs[(i + 2) % 4]);
            solve(idx + 1);
            back(idx, point, dirs[i]);
            back(idx, point, dirs[(i + 1) % 4]);
            back(idx, point, dirs[(i + 2) % 4]);
        }
    }
​
    private void type3(int idx, Point point) {
        Direction[] dirs = Direction.values();
        for (int i = 0; i < 4; i++) {
            go(idx, point, dirs[i]);
            go(idx, point, dirs[(i + 1) % 4]);
            solve(idx + 1);
            back(idx, point, dirs[i]);
            back(idx, point, dirs[(i + 1) % 4]);
        }
    }
​
    private void type2(int idx, Point point) {
        Direction[] dirs = Direction.values();
        for (int i = 0; i < 2; i++) {
            go(idx, point, dirs[i]);
            go(idx, point, dirs[i + 2]);
            solve(idx + 1);
            back(idx, point, dirs[i]);
            back(idx, point, dirs[i + 2]);
        }
    }
​
    private void type1(int idx, Point point) {
        for (Direction dir : Direction.values()) {
            go(idx, point, dir);
            solve(idx + 1);
            back(idx, point, dir);
        }
    }
​
    private void go(int idx, Point point, Direction dir) {
        if (dir == Direction.L) {
            leftGo(idx, point);
        } else if (dir == Direction.R) {
            rightGo(idx, point);
        } else if (dir == Direction.U) {
            upGo(idx, point);
        } else if (dir == Direction.D) {
            downGo(idx, point);
        }
    }
​
    private void back(int idx, Point point, Direction dir) {
        if (dir == Direction.L) {
            leftBack(idx, point);
        } else if (dir == Direction.R) {
            rightBack(idx, point);
        } else if (dir == Direction.U) {
            upBack(idx, point);
        } else if (dir == Direction.D) {
            downBack(idx, point);
        }
    }
​
    private void downGo(int idx, Point point) {
        for (int i = point.x + 1; i < N; i++) {
            if (board[i][point.y] == 6) {
                break;
            }
            if (board[i][point.y] == 0) {
                board[i][point.y] = idx + 7;
            }
        }
    }
​
    private void downBack(int idx, Point point) {
        for (int i = point.x + 1; i < N; i++) {
            if (board[i][point.y] == 6) {
                break;
            }
            if (board[i][point.y] == idx + 7) {
                board[i][point.y] = 0;
            }
        }
    }
​
    private void upGo(int idx, Point point) {
        for (int i = point.x - 1; i >= 0; i--) {
            if (board[i][point.y] == 6) {
                break;
            }
            if (board[i][point.y] == 0) {
                board[i][point.y] = idx + 7;
            }
        }
    }
​
    private void upBack(int idx, Point point) {
        for (int i = point.x - 1; i >= 0; i--) {
            if (board[i][point.y] == 6) {
                break;
            }
            if (board[i][point.y] == idx + 7) {
                board[i][point.y] = 0;
            }
        }
    }
​
    private void leftGo(int idx, Point point) {
        for (int i = point.y - 1; i >= 0; i--) {
            if (board[point.x][i] == 6) {
                break;
            }
            if (board[point.x][i] == 0) {
                board[point.x][i] = idx + 7;
            }
        }
    }
​
    private void leftBack(int idx, Point point) {
        for (int i = point.y - 1; i >= 0; i--) {
            if (board[point.x][i] == 6) {
                break;
            }
            if (board[point.x][i] == idx + 7) {
                board[point.x][i] = 0;
            }
        }
    }
​
    private void rightBack(int idx, Point point) {
        for (int i = point.y + 1; i < M; i++) {
            if (board[point.x][i] == 6) {
                break;
            }
            if (board[point.x][i] == idx + 7) {
                board[point.x][i] = 0;
            }
        }
    }
​
    private void rightGo(int idx, Point point) {
        for (int i = point.y + 1; i < M; i++) {
            if (board[point.x][i] == 6) {
                break;
            }
            if (board[point.x][i] == 0) {
                board[point.x][i] = idx + 7;
            }
        }
    }
​
    private int getCnt() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
​
    class Point {
        int x, y;
​
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
​
    enum Direction {
        U, R, D, L
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​