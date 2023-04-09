// [문제 링크]: https://school.programmers.co.kr/learn/courses/30/lessons/134240

class Solution {
    public String solution(int[] food) {
        String answer = "0";
        for(int i = food.length - 1; i > 0; i--) {
            String foodNum = String.valueOf(i).repeat(food[i] / 2);
            answer = foodNum + answer + foodNum;
        }
        return answer;
    }
}
