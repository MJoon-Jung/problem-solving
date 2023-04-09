import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        /**
        최대 이익 계산
        상자 안에 가장 낮은 점수인 사과 기준으로 가격을 측정
        score 정렬 후 m개씩 분리
        */
        
        List<Integer> sl = Arrays.stream(score)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        int answer = 0;
        int n = 1;
        while(true) {
            int idx = m * n++ - 1;
            if(idx >= score.length) {
                break;
            }
            answer += sl.get(idx) * m;
        }
        return answer;
    }
}
