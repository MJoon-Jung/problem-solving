// [문제 링크]: https://www.acmicpc.net/problem/1780

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    int N;
    int[][] paper = new int[2200][2200];
    int[] cnt = new int[3];
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }
​
    private void solve(int x, int y, int z) {
        if (check(x, y, z)) {
            cnt[paper[x][y] + 1]++;
            return;
        }
        int n = z / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(x + i * n, y + j * n, n);
            }
        }
    }
​
    private boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[x][y] != paper[i][j]) {
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