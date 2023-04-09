// [문제 링크]: https://www.acmicpc.net/problem/11729

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.valueOf(new StringTokenizer(br.readLine()).nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append((1 << k) - 1 + "\n");
        recursive(1, 3, k, sb);
        System.out.print(sb);
        br.close();
    }
​
    private void recursive(int a, int b, int k, StringBuilder sb) {
        if (k == 1) {
            sb.append(a + " " + b + "\n");
            return;
        }
        recursive(a, 6 - a - b, k - 1, sb);
        sb.append(a + " " + b + "\n");
        recursive(6 - a - b, b, k - 1, sb);
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}