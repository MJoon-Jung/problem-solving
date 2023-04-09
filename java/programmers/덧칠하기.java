import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int m, int[] section) {
        /**
         * p2
         * 1. 처음 section의 값을 저장한다.
         * 2. m만큼 이동한다.
         * 3. count++ 한다.
         * 4. section 값 중에 현재 값이랑 같거나 큰 값을 찾는다.
         * 5. 반복한다.
         */
        int answer = 0;
        int val = section[0];
        List<Integer> sectionList = Arrays.stream(section).boxed().collect(Collectors.toList());

        while (val <= n) {
            val += m - 1;
            answer++;
            int finalVal = val;
            val = sectionList.stream().filter(v -> v > finalVal).findFirst().orElse(n + 1);
        }
        return answer;
    }
}
