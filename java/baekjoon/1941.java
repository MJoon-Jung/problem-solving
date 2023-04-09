// [문제 링크]: https://www.acmicpc.net/problem/1941

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;
​
public class Main {
    int cnt;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[] board = new boolean[25];
    boolean[] visit = new boolean[25];
    int[] ar = new int[7];
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                board[i * 5 + j] = split[j].equals("S") ? true : false;
            }
        }
​
        permutation(0, 0);
        System.out.println(cnt);
    }
​
    private void permutation(int start, int k) {
        if (k == 7) {
            if (isSMoreThanY() && adjoin()) {
                cnt++;
            }
            return;
        }
​
        for (int i = start; i < 25; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            ar[k] = i;
            permutation(i + 1, k + 1);
            visit[i] = false;
        }
    }
​
    private boolean isSMoreThanY() {
        return IntStream.range(0, 7)
                .filter(i -> board[ar[i]])
                .count() >= 4;
    }
​
    private boolean adjoin() {
        boolean[][] tmp = new boolean[5][5];
        int c = 0;
        for (int i = 0; i < 5; i++) {
            Arrays.fill(tmp[i], false);
        }
        for (int i = 0; i < 7; i++) {
            tmp[ar[i] / 5][ar[i] % 5] = true;
        }
​
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(ar[0] / 5, ar[0] % 5));
        tmp[ar[0] / 5][ar[0] % 5] = false;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            c++;
​
            for (int i = 0; i < 4; i++) {
                int nx = p.x + (1 * dx[i]);
                int ny = p.y + (1 * dy[i]);
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }
                if (!tmp[nx][ny]) {
                    continue;
                }
​
                queue.add(new Point(nx, ny));
                tmp[nx][ny] = false;
            }
        }
        return c == 7;
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
}