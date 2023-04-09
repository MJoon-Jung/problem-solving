// [문제 링크]: https://www.acmicpc.net/problem/1182

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    int N, S, cnt;
    int[] board = new int[20];
    boolean[] visit = new boolean[20];
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
​
        solve(0, 0, 0);
        System.out.println(cnt);
    }
​
    private void solve(int idx, int cur, int depth) {
        if (depth > 0 && cur == S) {
            cnt++;
        }
​
        for (int i = idx; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            solve(i + 1, cur + board[i], depth + 1);
            visit[i] = false;
        }
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​