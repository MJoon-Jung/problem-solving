// [문제 링크]: https://school.programmers.co.kr/learn/courses/30/lessons/133502

import java.util.*;
class Solution {
    int[] ar = new int[1_000_001];
    int idx, result;
    public int solution(int[] ingredient) {
        if(ingredient.length < 4) return 0;
        for(int val : ingredient) {
            ar[idx++] = val;
            if(idx < 4) continue;
            if(!isHamburguer()) continue;
            result++;
            idx -= 4;
        }
        return result;
    }
    boolean isHamburguer() {
        return ar[idx - 4] == 1 && ar[idx - 3] == 2 && ar[idx - 2] == 3 && ar[idx - 1] == 1;
    }
}
