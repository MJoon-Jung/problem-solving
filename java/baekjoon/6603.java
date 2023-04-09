// [문제 링크]: https://www.acmicpc.net/problem/6603

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
​
public class Main {
    StringBuilder sb = new StringBuilder();
    int[] ar;
    int[] board;
    private static final int M = 6;
    boolean[] check;
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
​
        while (true) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            if (len == 0) {
                break;
            }
            ar = new int[M + 1];
            check = new boolean[len];
            board = new int[len];
            for (int i = 0; i < board.length; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(board);
            solve(0);
            sb.append("\n");
        }
​
        System.out.println(sb);
        br.close();
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
            if (check[i] || ar[k] > board[i]) {
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