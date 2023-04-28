import java.io.*;
import java.util.*;

class Main {

    int[] gears = new int[4];

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++) {
            gears[i] = Integer.parseInt(br.readLine(), 2);
        }
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            int[] direction = makeRotateDirection(n , dir);
            rotate(direction);
        }
        System.out.println(score());
    }
    void print() {
        for(int i = 0; i < 4; i++) {
            System.out.println(Integer.toBinaryString(gears[i]) + " , ");
        }
    }
    void rotate(int[] direction) {
        for(int i = 0; i < 4; i++) {
            if(direction[i] == 0) continue;
            gears[i] = direction[i] == 1 ? clockWiseRotate(gears[i]) : antiClockWiseRotate(gears[i]);
        }
    }

    int[] makeRotateDirection(int n, int dir) {
        int[] direction = new int[4];
        Arrays.fill(direction, 0);
        direction[n] = dir;

        for(int i = n - 1; i >= 0; i--) {
            if(same(gears[i], gears[i + 1])) break;
            direction[i] = direction[i+1] * -1;
        }

        for(int i = n; i + 1 < 4; i++) {
            if(same(gears[i], gears[i + 1])) break;
            direction[i + 1] = direction[i] * -1;
        }

        return direction;
    }

    private int score() {
        int score = 0;

		score += (gears[0] & (1<<7)) == 0 ? 0 : 1;
		score += (gears[1] & (1<<7)) == 0 ? 0 : 2;
		score += (gears[2] & (1<<7)) == 0 ? 0 : 4;
		score += (gears[3] & (1<<7)) == 0 ? 0 : 8;

		return score;
    }

    private int clockWiseRotate(int n) {
        if((n&1)>0) {
            n >>>= 1;
            n |= (1<<7);
        }else n >>>= 1;
        return n;
    }

    private int antiClockWiseRotate(int n) {
        if((n & (1<<7)) > 0) {
            n <<= 1;
            n |= 1;
        } else n <<= 1;
        return n;
    }

    private boolean same(int a, int b) {
        int result1 = (a&(1<<5)) > 0 ? 1 : 0;
        int result2 = (b&(1<<1)) > 0 ? 1 : 0;
        return result1 == result2;
    }

    public static void main(String[] args) throws IOException  {
        new Main().solution();
    }
}
