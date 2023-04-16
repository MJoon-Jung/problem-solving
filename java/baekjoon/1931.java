import java.util.*;
import java.io.*;

class Main {
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] ar = new int[n][2];
        for(int i = 0; i < n; i++) {
            st =  new StringTokenizer(br.readLine());
            ar[i][0] = Integer.parseInt(st.nextToken());
            ar[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar, (a, b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);

        int cnt = 0;
        int finishTime = 0;
        for(int[] val : ar) {
            if(finishTime <= val[0]) {
                finishTime = val[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
