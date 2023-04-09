import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
           /**
             * k일이 되기 전에는 계속 넣기만 한다.
             * 대신 정렬을 해서 첫번 째 값이 발표 점수이다.
             * k일이 넘어서면
             * 순서 정하기를 한다.
             * 1. 넣을 값과 제일 최소값을 비교한다.
             * 2. 넣을 값이 더 크면 최소값을 지우고 새 값을 넣고 정렬한다.
             * 3. 넣을 값이 더 작으면 그대로 둔다.
             * 첫번째 값이 발표 점수이다.
             * 순서 정하기를 반복한다.
             */
            int[] answer = new int[score.length];
            Queue<Integer> queue = new PriorityQueue<>();

            for (int i = 0; i < score.length; i++) {
                queue.add(score[i]);
                if (k < i + 1) {
                    queue.poll();
                }
                answer[i] = queue.peek();
            }

            return answer;
    }
}
