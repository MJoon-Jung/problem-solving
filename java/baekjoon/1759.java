// [문제 링크]: https://www.acmicpc.net/problem/1759

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
    private static final String VOWEL = "aeiou";
    int[] board = new int[15];
    int[] pick = new int[15];
    boolean[] check = new boolean[15];
    StringBuilder sb = new StringBuilder();
    int N, M;
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
​
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            board[i] = st.nextToken().charAt(0);
        }
​
        Arrays.sort(board, 0, N);
        solve(0);
        System.out.print(sb);
    }
​
    private void solve(int k) {
        if (k == M) {
            if (validate()) {
                for (int i = 1; i < M + 1; i++) {
                    sb.append((char) pick[i]);
                }
                sb.append("\n");
            }
            return;
        }
​
        for (int i = 0; i < N; i++) {
            if (check[i] || pick[k] > board[i]) {
                continue;
            }
            check[i] = true;
            pick[k + 1] = board[i];
            solve(k + 1);
            check[i] = false;
        }
    }
​
    private boolean validate() {
        int vowelCnt = 0;
        int consonantCnt = 0;
        for (int i = 1; i < M + 1; i++) {
            if (VOWEL.indexOf((char) pick[i]) != -1) {
                vowelCnt++;
            } else {
                consonantCnt++;
            }
        }
        return vowelCnt >= 1 && consonantCnt >= 2;
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​