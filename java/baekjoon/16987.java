// [문제 링크]: https://www.acmicpc.net/problem/16987

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    int N, maxCnt;
    int[][] board = new int[8][2];
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        System.out.println(maxCnt);
    }
​
    private void solve(int cnt, int n) {
        if (maxCnt >= cnt + (N - n) * 2) {
            return;
        }
        
        if (n == N) {
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
​
        if (board[n][0] <= 0) {
            solve(cnt, n + 1);
            return;
        }
​
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (i == n || isBroken(i)) {
                continue;
            }
            flag = true;
            board[n][0] -= board[i][1];
            board[i][0] -= board[n][1];
            solve(cnt + (isBroken(n) ? 1 : 0) + (isBroken(i) ? 1 : 0), n + 1);
            board[n][0] += board[i][1];
            board[i][0] += board[n][1];
        }
        if (!flag) {
            solve(cnt, n + 1);
        }
    }
​
    private boolean isBroken(int idx) {
        return board[idx][0] <= 0;
    }
}
​