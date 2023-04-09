// [문제 링크]: https://www.acmicpc.net/problem/15649

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
​
public class Main {
    int N, M;
    boolean[] check;
    int[] ar;
    StringBuilder sb;
​
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        br.close();
​
        check = new boolean[N + 1];
        ar = new int[M + 1];
        solve(0);
    }
​
    private void solve(int k) {
        if (k == M) {
            String collect = IntStream.range(1, M + 1)
                    .mapToObj(i -> ar[i])
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(collect);
        }
        for (int i = 1; i <= N; i++) {
            if (k < M && !check[i]) {
                check[i] = true;
                ar[k + 1] = i;
                solve(k + 1);
                check[i] = false;
            }
        }
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}