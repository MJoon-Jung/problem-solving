import java.util.*;
// https://tes-b.github.io/codingtests/python_billiards 참고
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> answer = new ArrayList<>();

        for (int[] ball : balls) {
            int diffX = startX - ball[0];
            int diffY = startY - ball[1];

            int left = (int) (Math.pow(startX + ball[0], 2) + Math.pow(diffY, 2));
            int right = (int) (Math.pow((m - startX) + (m - ball[0]), 2) + Math.pow(diffY, 2));
            int up = (int) (Math.pow(diffX, 2) + Math.pow((n - startY) + (n - ball[1]), 2));
            int down = (int) (Math.pow(diffX, 2) + Math.pow(startY + ball[1], 2));

            int result;
            if (diffX == 0) {
                if (diffY > 0) {
                    result = min(left, right, up);
                } else {
                    result = min(left, right, down);
                }
            } else if (diffY == 0) {
                if (diffX > 0) {
                    result = min(up, down, right);
                } else {
                    result = min(up, down, left);
                }
            } else {
                result = min(left, right, up, down);
            }
            answer.add(result);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int min(int... args) {
        return Arrays.stream(args).min().getAsInt();
    }
}
