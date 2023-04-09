// [문제 링크]: https://www.acmicpc.net/problem/15654

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
​
public class Main {
    int N, M;
    int[] board;
    int[] ar;
    boolean[] check;
    StringBuilder sb = new StringBuilder();
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
​
        ar = new int[M + 1];
        check = new boolean[N];
        Arrays.sort(board);
        solve(0);
        System.out.println(sb);
    }
​
    private void solve(int k) {
        if (k == M) {
            String answer = IntStream.range(1, M + 1)
                    .mapToObj(i -> String.valueOf(ar[i]))
                    .collect(Collectors.joining(" "));
            sb.append(answer + "\n");
            return;
        }
​
        for (int i = 0; i < board.length; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            ar[k + 1] = board[i];
            solve(k + 1);
            check[i] = false;
        }
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​