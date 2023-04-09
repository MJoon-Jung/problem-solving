// [문제 링크]: https://www.acmicpc.net/problem/1629

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
​
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.valueOf(st.nextToken());
        long b = Integer.valueOf(st.nextToken());
        long c = Integer.valueOf(st.nextToken());
​
        System.out.println(recursive(a, b, c));
        br.close();
    }
​
    private long recursive(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long tmp = recursive(a, b / 2, c) % c;
        if (b % 2 == 1) {
            return tmp * tmp % c * a % c;
        }
        return tmp * tmp % c;
    }
​
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
​