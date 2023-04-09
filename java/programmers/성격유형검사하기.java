import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] type = { "RT", "CF", "JM", "AN" };
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < survey.length; i++) {
            int choice = choices[i] - 4;
            if(survey[i].charAt(0) > survey[i].charAt(1)) {
                survey[i] = survey[i].charAt(1) + "" + survey[i].charAt(0);
                choice *= -1;
            }
            map.put(survey[i], map.getOrDefault(survey[i], 0) + choice);
        }
        
        String answer = "";
        for(int i = 0; i < type.length; i++) {
            int choice = map.getOrDefault(type[i], 0);
            if(choice <= 0) {
                answer += type[i].charAt(0) + "";
            } else {
                answer += type[i].charAt(1) + "";
            }
        }
        return answer;
    }
}
