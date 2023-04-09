// [문제 링크]: https://www.acmicpc.net/problem/2447

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
​
public class Main {
    int N;
    String[][] board = new String[(int) Math.pow(3, 8)][(int) Math.pow(3, 8)];
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = "*";
            }
        }
        
        solve(0, 0, N);
​
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
​
    private void solve(int x, int y, int z) {
        if (z == 1) {
            return;
        }
        int n = z / 3;
​
        for (int i = x + n; i < x + n * 2; i++) {
            for (int j = y + n; j < y + n * 2; j++) {
                board[i][j] = " ";
            }
        }
​
        for (int i = x; i < x + z; i += n) {
            for (int j = y; j < y + z; j += n) {
                if (board[i][j].equals("")) {
                    continue;
                }
                solve(i, j, n);
​
            }
        }
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​