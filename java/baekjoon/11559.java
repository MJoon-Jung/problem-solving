import java.io.*;
import java.util.*;

class Main {
    static final int N = 12;
    static final int M = 6;
    static final String BLOCK = ".";
    String[][] board = new String[12][6];
    boolean[][] visit = new boolean[N][M];
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < N; i++) board[i] = br.readLine().split("");

        boolean flag = true;
        int result = 0;
        while(true) {
            flag = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(isBlock(i, j)) continue;
                    if(visit[i][j]) continue;
                    Stack<Point> stack = new Stack<>();
                    stack.push(new Point(i, j));
                    initVisit();
                    visit[i][j] = true;
                    int cnt = 0;

                    while(!stack.isEmpty()) {
                        Point p = stack.pop();
                        cnt++;

                        for(int dir = 0; dir < 4; dir++) {
                            int nx = p.x + dx[dir];
                            int ny = p.y + dy[dir];

                            if(nx < 0 || ny < 0 || nx >= N || ny >=M) continue;
                            if(isBlock(nx, ny)) continue;
                            if(visit[nx][ny]) continue;
                            if(!board[i][j].equals(board[nx][ny])) continue;
                            stack.push(new Point(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                    if(cnt >= 4) {
                        for(int k = 0; k < N; k++) {
                            for(int z = 0; z < M; z++) {
                                if(visit[k][z]) board[k][z] = BLOCK;
                            }
                        }
                        if(!flag) {
                            flag = true;
                            result++;
                        }
                    }
                }
            }
            if(!flag) break;

            for(int j = 0; j < M; j++) {
                for(int i = N-1; i >= 0; i--) {
                    if(!isBlock(i, j)) {
                        int tmp = i;
                        boolean down = false;
                        while(++tmp < N && isBlock(tmp,j)) down = true;
                        if(down) {
                            board[tmp - 1][j] = board[i][j];
                            board[i][j] = BLOCK;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
    boolean isBlock(int x, int y) {
        return board[x][y].equals(BLOCK);
    }
    void initVisit() {
        for(int i = 0; i < N; i++) Arrays.fill(visit[i], false);
    }
    class Point {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException  {
        new Main().solution();
    }
}
