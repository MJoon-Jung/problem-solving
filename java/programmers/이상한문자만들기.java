class Solution {
    public String solution(String s) {
        String[] ar = s.split("");
        int cnt = 0;
        
        String answer = "";
        for(int i = 0; i < ar.length; i++) {
            cnt = ar[i].contains(" ") ? 0 : cnt + 1;
            answer += cnt % 2 == 0 ? ar[i].toLowerCase() : ar[i].toUpperCase();
        }
        return answer;
    }
}
