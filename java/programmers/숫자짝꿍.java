import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> xmap = initializeMap(X);
        Map<String, Integer> ymap = initializeMap(Y);
        
        String answer = "";
        for(int i = 9; i >= 0; i--) {
            int xlen = xmap.getOrDefault(i + "", 0);
            int ylen = ymap.getOrDefault(i + "", 0);
            if(i == 0 && answer.length() == 0 && Math.min(xlen, ylen) > 0) answer = "0";
            else answer += (i + "").repeat(Math.min(xlen, ylen));
        }
        return answer.length() == 0 ? "-1" : answer;
    }
    Map<String, Integer> initializeMap(String word) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i) + "", map.getOrDefault(word.charAt(i) + "", 0) + 1);
        }
        return map;
    }
}
