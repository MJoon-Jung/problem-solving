import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String input_string) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, Boolean> flag = new HashMap<>();
        String[] input = input_string.split("");
        for(String s : input) {
            count.put(s, count.getOrDefault(s, 0) + 1);
            flag.put(s, false);
        }
        
        String answer = "";
        int i = -1;
        while(++i < input.length) {
            int j = i;
            while(j < input.length && input[i].equals(input[j])) j++;
            if(flag.get(input[i])) answer += input[i];
            if(i != j) i = j - 1;
            flag.put(input[i], true);
        }
        
        if(answer.equals("")) return "N";
        return Stream.of(answer.split(""))
            .distinct()
            .sorted()
            .collect(Collectors.joining());
    }
}
