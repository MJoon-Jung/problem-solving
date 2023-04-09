// [문제 링크]: https://www.acmicpc.net/problem/12100

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    int N, ans;
    int[][] initBoard = new int[20][20];
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                initBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
​
        solve(0, initBoard);
        System.out.println(ans);
    }
​
    private void solve(int cnt, int[][] board) {
        if (cnt == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans = Math.max(ans, board[i][j]);
                }
            }
            return;
        }
​
        for (int dir = 0; dir < 4; dir++) {
            int[][] copy = copy(board);
            tilt(copy, dir);
            solve(cnt + 1, copy);
        }
    }
​
    private int[][] copy(int[][] board) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }
​
    private void tilt(int[][] board, int dir) {
        while (dir-- > 0) rotate(board);
        for (int i = 0; i < N; i++) {
            int[] tmp = new int[N];
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;
                if (tmp[idx] == 0) tmp[idx] = board[i][j];
                else if (tmp[idx] == board[i][j]) tmp[idx++] *= 2;
                else tmp[++idx] = board[i][j];
            }
            for (int j = 0; j < N; j++) {
                board[i][j] = tmp[j];
            }
        }
    }
​
    private void rotate(int[][] board) {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = tmp[N - j - 1][i];
            }
        }
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}