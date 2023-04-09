// [문제 링크]: https://www.acmicpc.net/problem/1992

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    int N;
    int[][] board = new int[64][64];
    String answer = "";
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
​
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
​
        solve(0, 0, N);
        System.out.println(answer);
    }
​
    private void solve(int x, int y, int n) {
        if (check(x, y, n)) {
            answer += board[x][y] + "";
            return;
        }
​
        answer += "(";
        for (int i = x; i < x + n; i += n / 2) {
            for (int j = y; j < y + n; j += n / 2) {
                solve(i, j, n / 2);
            }
        }
        answer += ")";
    }
​
    private boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[x][y] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​