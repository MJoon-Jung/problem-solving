// [문제 링크]: https://www.acmicpc.net/problem/1074

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = getValueByStringTokenizer(st);
        int r = getValueByStringTokenizer(st);
        int c = getValueByStringTokenizer(st);
        System.out.println(recursive(r, c, n));
    }
​
    private int getValueByStringTokenizer(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
​
    private int recursive(int r, int c, int n) {
        // r행 c열
        if (n == 0) {
            return 0;
        }
        int m = (int) Math.pow(2, n - 1);
        if (r < m && c < m) {
            //1사분면
            return recursive(r, c, n - 1);
        } else if (r < m && c >= m) {
            //2사분면
            return m * m + recursive(r, c - m, n - 1);
        } else if (r >= m && c < m) {
            //3사분면
            return m * m * 2 + recursive(r - m, c, n - 1);
        } else {
            //4사분면
            return m * m * 3 + recursive(r - m, c - m, n - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​