import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] ar = { "aya", "ye", "woo", "ma" };
        int answer = 0;
        for(String word : babbling) {
            boolean flag = false;
            for(int i = 0; i < ar.length; i++) {
                if(word.indexOf(ar[i].repeat(2)) != -1) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            
            for(int i = 0; i < ar.length; i++) {
                word = word.replace(ar[i], "#");
            }
            word = word.replace("#", "");
            answer += word.length() == 0 ? 1 : 0;
        }
        return answer;
    }
}
