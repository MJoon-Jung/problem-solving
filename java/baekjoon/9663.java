// [문제 링크]: https://www.acmicpc.net/problem/9663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
​
public class Main {
    int N, cnt;
    boolean[] isUsed1 = new boolean[15];
    boolean[] isUsed2 = new boolean[30];
    boolean[] isUsed3 = new boolean[30];
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solve(0);
        System.out.println(cnt);
    }
​
    private void solve(int cur) {
        if (cur == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isUsed1[i] || isUsed2[i + cur] || isUsed3[Math.abs(i - N) + cur]) {
                continue;
            }
            isUsed1[i] = true;
            isUsed2[i + cur] = true;
            isUsed3[Math.abs(i - N) + cur] = true;
            solve(cur + 1);
            isUsed1[i] = false;
            isUsed2[i + cur] = false;
            isUsed3[Math.abs(i - N) + cur] = false;
        }
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​