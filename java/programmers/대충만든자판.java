import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> store = initializeKeymapStore(keymap);
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            answer[i] = getWriteCount(store, targets[i]);
        }
        return answer;
    }

    private int getWriteCount(Map<String, Integer> store, String target) {
        String[] values = target.split("");
        int sum = 0;
        for (String value : values) {
            Integer count = store.get(value);
            if(count == null) {
                return -1;
            }
            sum += count;
        }
        return sum;
    }

    private Map<String, Integer> initializeKeymapStore(String[] keymap) {
        Map<String, Integer> store = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            String[] keys = keymap[i].split("");
            for (int j = 0; j < keys.length; j++) {
                Integer count = store.get(keys[j]);
                if (count == null || count > j + 1) {
                    store.put(keys[j], j + 1);
                }
            }
        }
        return store;
    }
}
