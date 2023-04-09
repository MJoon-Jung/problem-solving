// [문제 링크]: https://www.acmicpc.net/problem/2448

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
​
public class Main {
    String[][] board;
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        board = new String[N][2 * N - 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            }
        }
​
        solve(0, N - 1, N);
​
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
​
    private void solve(int x, int y, int h) {
        if (h < 3 || x < 0 || y < 0) {
            return;
        }
        /**
         * 높이의 반이 기준
         */
        draw(x, y, h);
        solve(x, y, h / 2);
        solve(x + h / 2, y - h / 2, h / 2);
        solve(x + h / 2, y + h / 2, h / 2);
    }
​
    private void draw(int x, int y, int h) {
        // 밑변
//        System.out.println("x, y : " + x + " " + y + " h : " + h);
        for (int i = 0; i < h; i++) {
            if (h != 3 && i % 6 == 0) {
                continue;
            }
            board[x + h - 1][y + i] = "*";
            board[x + h - 1][y - i] = "*";
        }
​
        // 빗변
        for (int i = 0; i < h; i++) {
            board[x + i][y + i] = "*";
            board[x + i][y - i] = "*";
        }
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​