import java.util.Arrays;

class Solution {
    int answer;
    boolean[] check = new boolean[13];
    int[] pick = new int[13];
    public int solution(int[] number) {
        Arrays.sort(number);
        solve(number, 0, 0);
        return answer;
    }
    void solve(int[] number, int sum, int cnt) {
        if(cnt == 3) {
            if(sum == 0) answer++;
            return;
        }
        
        for(int i = 0; i < number.length; i++) {
            if(check[i]) continue;
            if(cnt > 0 && pick[cnt - 1] >= i) continue;
            check[i] = true;
            pick[cnt] = i;
            solve(number, sum + number[i], cnt + 1);
            check[i] = false;
        }
    }
}
