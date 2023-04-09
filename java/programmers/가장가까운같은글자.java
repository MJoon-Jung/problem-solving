import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> positionStore = new HashMap<>();
        for (int position = 0; position < s.length(); position++) {
            char keyCharacter = s.charAt(position);
            if (!positionStore.containsKey(keyCharacter)) {
                answer[position] = -1;
                positionStore.put(keyCharacter, position);
                continue;
            }
            answer[position] = position - positionStore.get(keyCharacter);
            positionStore.put(keyCharacter, position);
        }
        return answer;
    }
}
