class Solution {
    public String solution(int a, int b) {
        int[] month = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int ans = -1;
        for(int i = 1; i <= a; i++) {
            if(i == a) {
                ans += b;
            } else {
                ans += month[i];
            }
        }
        return day[ans % 7];
    }
}
